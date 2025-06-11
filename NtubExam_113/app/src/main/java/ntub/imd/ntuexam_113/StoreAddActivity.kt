package ntub.imd.ntuexam_113

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class StoreAddActivity : AppCompatActivity() {
    private val viewModel: StoreViewModel by viewModels()
    private var imageUri: String? = null
    private lateinit var imgStore: ImageView
    private lateinit var edtName: TextInputEditText
    private lateinit var edtPhone: TextInputEditText
    private lateinit var edtAddress: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_add)

        imgStore = findViewById(R.id.imgStoreAdd)
        edtName = findViewById(R.id.edtNameAdd)
        edtPhone = findViewById(R.id.edtPhoneAdd)
        edtAddress = findViewById(R.id.edtAddressAdd)

        findViewById<com.google.android.material.button.MaterialButton>(R.id.btnSelectImageAdd).setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, 101)
        }

        findViewById<com.google.android.material.button.MaterialButton>(R.id.btnAddConfirm).setOnClickListener {
            val name = edtName.text.toString().trim()
            val phone = edtPhone.text.toString().trim()
            val address = edtAddress.text.toString().trim()
            if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                Snackbar.make(edtName, "請填寫所有欄位", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val store = Store(
                name = name,
                phone = phone,
                address = address,
                imageUri = imageUri,
                rating = 0f
            )
            viewModel.insert(store)
            setResult(Activity.RESULT_OK, Intent().putExtra("action", "add"))
            finish()
        }

        findViewById<com.google.android.material.button.MaterialButton>(R.id.btnAddCancel).setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
            val uri = data?.data
            if (uri != null) {
                imageUri = uri.toString()
                imgStore.setImageURI(uri)
            }
        }
    }
}
