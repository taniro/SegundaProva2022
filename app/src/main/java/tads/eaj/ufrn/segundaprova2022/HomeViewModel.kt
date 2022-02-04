package tads.eaj.ufrn.segundaprova2022

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room


class HomeViewModel(application: Application) : AndroidViewModel(application) {
    var list:LiveData<List<Pessoa>>

    private val db:PessoaDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            PessoaDatabase::class.java,
            "pessoas.sqlite")
            .build()
    }

    init {
        list = db.pessoaDao().buscarTodos()
    }
}