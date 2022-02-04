package tads.eaj.ufrn.segundaprova2022

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Pessoa::class], version = 1)
abstract class PessoaDatabase:RoomDatabase() {
    abstract fun pessoaDao():PessoaDao
}