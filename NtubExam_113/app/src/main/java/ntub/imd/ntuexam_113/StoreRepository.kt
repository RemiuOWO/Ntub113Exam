package ntub.imd.ntuexam_113

import androidx.lifecycle.LiveData

class StoreRepository(private val storeDao: StoreDao) {
    val allStores: LiveData<List<Store>> = storeDao.getAll()

    suspend fun insert(store: Store) = storeDao.insert(store)
    suspend fun update(store: Store) = storeDao.update(store)
    suspend fun delete(store: Store) = storeDao.delete(store)
    suspend fun getById(id: Int) = storeDao.getById(id)
}
