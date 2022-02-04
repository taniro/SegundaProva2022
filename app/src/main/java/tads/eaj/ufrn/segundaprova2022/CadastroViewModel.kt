package tads.eaj.ufrn.segundaprova2022

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch

class CadastroViewModel(application: Application) : AndroidViewModel(application) {

    var pessoa = Pessoa()

    private val db:PessoaDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            PessoaDatabase::class.java,
            "pessoas.sqlite")
            .build()
    }

    fun cadastraPessoa(){
        viewModelScope.launch {
            db.pessoaDao().cadastrar(pessoa)
        }
    }
}