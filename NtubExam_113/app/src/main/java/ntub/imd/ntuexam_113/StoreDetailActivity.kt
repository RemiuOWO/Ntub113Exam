package ntub.imd.ntuexam_113

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class StoreDetailActivity : AppCompatActivity() {
    private val viewModel: StoreViewModel by viewModels()
    private var storeId: Int = -1
    private var imageUri: String? = null
    private lateinit var imgStore: ImageView
    private lateinit var edtName: TextInputEditText
    private lateinit var edtPhone: TextInputEditText
    private lateinit var edtAddress: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)

        imgStore = findViewById(R.id.imgStoreDetail)
        edtName = findViewById(R.id.edtName)
        edtPhone = findViewById(R.id.edtPhone)
        edtAddress = findViewById(R.id.edtAddress)

        storeId = intent.getIntExtra("store_id", -1)
        if (storeId == -1) {
            finish()
            return
        }

        viewModel.getById(storeId) { store ->
            store?.let {
                edtName.setText(it.name)
                edtPhone.setText(it.phone)
                edtAddress.setText(it.address)
                imageUri = it.imageUri
                if (!imageUri.isNullOrEmpty()) {
                    imgStore.setImageURI(Uri.parse(imageUri))
                }
            }
        }

        findViewById<com.google.android.material.button.MaterialButton>(R.id.btnSelectImage).setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, 100)
        }

        findViewById<com.google.android.material.button.MaterialButton>(R.id.btnUpdate).setOnClickListener {
            val name = edtName.text.toString().trim()
            val phone = edtPhone.text.toString().trim()
            val address = edtAddress.text.toString().trim()
            if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                Snackbar.make(edtName, "請填寫所有欄位", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            viewModel.getById(storeId) { store ->
                store?.let {
                    it.name = name
                    it.phone = phone
                    it.address = address
                    it.imageUri = imageUri
                    viewModel.update(it)
                    setResult(Activity.RESULT_OK, Intent().putExtra("action", "update"))
                    finish()
                }
            }
        }

        findViewById<com.google.android.material.button.MaterialButton>(R.id.btnDelete).setOnClickListener {
            viewModel.getById(storeId) { store ->
                store?.let {
                    viewModel.delete(it)
                    setResult(Activity.RESULT_OK, Intent().putExtra("action", "delete"))
                    finish()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            val uri = data?.data
            if (uri != null) {
                imageUri = uri.toString()
                imgStore.setImageURI(uri)
            }
        }
    }
}

