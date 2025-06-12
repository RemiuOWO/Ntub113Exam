package ntub.imd.ntuexam_113

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stores")
data class Store(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var name: String,
    var phone: String,
    var address: String,
    var imageUri: String?,
    var rating: Float = 0f
)
