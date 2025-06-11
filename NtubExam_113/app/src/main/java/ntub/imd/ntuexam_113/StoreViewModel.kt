package ntub.imd.ntuexam_113

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class StoreViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: StoreRepository
    val allStores: LiveData<List<Store>>

    init {
        val storeDao = AppDatabase.getDatabase(application).storeDao()
        repository = StoreRepository(storeDao)
        allStores = repository.allStores
    }

    fun insert(store: Store) = viewModelScope.launch { repository.insert(store) }
    fun update(store: Store) = viewModelScope.launch { repository.update(store) }
    fun delete(store: Store) = viewModelScope.launch { repository.delete(store) }
    fun getById(id: Int, callback: (Store?) -> Unit) = viewModelScope.launch {
        callback(repository.getById(id))
    }
}
