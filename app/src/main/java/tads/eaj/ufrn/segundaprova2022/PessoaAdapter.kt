package tads.eaj.ufrn.segundaprova2022

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PessoaAdapter : RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>() {

    var list:List<Pessoa> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pessoa_layout, parent, false)
        return PessoaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        val pessoa = list[position]
        holder.nomeTextView.text = pessoa.nome
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class PessoaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nomeTextView = itemView.findViewById<TextView>(R.id.nome)
    }
}