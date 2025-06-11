package ntub.imd.ntuexam_113

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StoreDao {
    @Query("SELECT * FROM stores")
    fun getAll(): LiveData<List<Store>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(store: Store): Long

    @Update
    suspend fun update(store: Store)

    @Delete
    suspend fun delete(store: Store)

    @Query("SELECT * FROM stores WHERE id = :id")
    suspend fun getById(id: Int): Store?
}
