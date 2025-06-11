package ntub.imd.ntuexam_113

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StoreAdapter(
    private var stores: List<Store>,
    private val onItemClick: (Store) -> Unit,
    private val onRatingChanged: (Store, Float) -> Unit
) : RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {

    inner class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgStore: ImageView = itemView.findViewById(R.id.imgStore)
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtPhone: TextView = itemView.findViewById(R.id.txtPhone)
        val txtAddress: TextView = itemView.findViewById(R.id.txtAddress)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_store, parent, false)
        return StoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val store = stores[position]
        holder.txtName.text = store.name
        holder.txtPhone.text = store.phone
        holder.txtAddress.text = store.address
        holder.ratingBar.rating = store.rating
        // 載入圖片
        if (!store.imageUri.isNullOrEmpty()) {
            holder.imgStore.setImageURI(Uri.parse(store.imageUri))
        } else {
            holder.imgStore.setImageResource(R.drawable.ic_launcher_background)
        }
        holder.itemView.setOnClickListener { onItemClick(store) }
        holder.ratingBar.setOnRatingBarChangeListener { _, rating, fromUser ->
            if (fromUser) onRatingChanged(store, rating)
        }
        // 電話號碼點擊事件：複製並撥號
        holder.txtPhone.setOnClickListener {
            val context = holder.txtPhone.context
            val clipboard = context.getSystemService(android.content.Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
            val clip = android.content.ClipData.newPlainText("phone", store.phone)
            clipboard.setPrimaryClip(clip)
            val intent = android.content.Intent(android.content.Intent.ACTION_DIAL)
            intent.data = android.net.Uri.parse("tel:${store.phone}")
            context.startActivity(intent)
            android.widget.Toast.makeText(context, "電話已複製並準備撥號", android.widget.Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = stores.size

    fun updateData(newStores: List<Store>) {
        stores = newStores
        notifyDataSetChanged()
    }
}
