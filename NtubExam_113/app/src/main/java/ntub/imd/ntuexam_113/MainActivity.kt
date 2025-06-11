package ntub.imd.ntuexam_113

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: StoreAdapter
    private val viewModel: StoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)
        adapter = StoreAdapter(listOf(), onItemClick = { store ->
            val intent = Intent(this, StoreDetailActivity::class.java)
            intent.putExtra("store_id", store.id)
            startActivityForResult(intent, 200)
        }, onRatingChanged = { store, rating ->
            store.rating = rating
            viewModel.update(store)
            Snackbar.make(recyclerView, "已更新評分", Snackbar.LENGTH_SHORT).show()
        })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.allStores.observe(this, Observer { stores ->
            adapter.updateData(stores)
        })

        findViewById<com.google.android.material.button.MaterialButton>(R.id.btnAddStore).setOnClickListener {
            val intent = Intent(this, StoreAddActivity::class.java)
            startActivityForResult(intent, 201)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 200 && resultCode == RESULT_OK && data != null) {
            val action = data.getStringExtra("action")
            val msg = when (action) {
                "update" -> "店家資料已更新"
                "delete" -> "店家已刪除"
                else -> null
            }
            msg?.let {
                Snackbar.make(findViewById(R.id.recyclerView), it, Snackbar.LENGTH_SHORT).show()
            }
        } else if (requestCode == 201 && resultCode == RESULT_OK && data != null) {
            val action = data.getStringExtra("action")
            if (action == "add") {
                Snackbar.make(findViewById(R.id.recyclerView), "新增店家成功", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}