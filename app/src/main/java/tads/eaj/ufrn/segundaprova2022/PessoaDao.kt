package tads.eaj.ufrn.segundaprova2022

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PessoaDao {
    @Insert
    suspend fun cadastrar(p:Pessoa)
    @Update
    suspend fun editar(p:Pessoa)
    @Delete
    suspend fun excluir(p: Pessoa)
    @Query("SELECT * from Pessoa")
    fun buscarTodos():LiveData<List<Pessoa>>
    @Query("SELECT * from pessoa where id=:id")
    fun buscarPorId(id:Long):LiveData<Pessoa>
    @Query("DELETE FROM Pessoa")
    fun excluirTodos()
}