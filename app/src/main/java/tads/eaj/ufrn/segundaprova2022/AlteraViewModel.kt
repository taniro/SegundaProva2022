package tads.eaj.ufrn.segundaprova2022

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.launch

class AlteraViewModel(application: Application, id:Long) : AndroidViewModel(application)  {

    lateinit var pessoa:LiveData<Pessoa>

    private val db:PessoaDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            PessoaDatabase::class.java,
            "pessoas.sqlite")
            .build()
    }

    init {
        viewModelScope.launch {
            pessoa =  db.pessoaDao().buscarPorId(id)
        }
    }

    fun alteraPessoa(){
        viewModelScope.launch {
            db.pessoaDao().editar(pessoa.value!!)
        }
    }

    class AlteraViewModelFactory(val application: Application,val id: Long) : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlteraViewModel::class.java)) {
                return AlteraViewModel(application, id) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}