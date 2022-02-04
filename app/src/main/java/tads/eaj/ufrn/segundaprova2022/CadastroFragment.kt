package tads.eaj.ufrn.segundaprova2022

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import tads.eaj.ufrn.segundaprova2022.databinding.FragmentCadastroBinding


class CadastroFragment : Fragment() {

    lateinit var binding:FragmentCadastroBinding
    lateinit var viewmodel:CadastroViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastro, container, false)
        viewmodel = ViewModelProvider(this).get(CadastroViewModel::class.java)

        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this

        binding.buttonCadastrar.setOnClickListener {
            viewmodel.cadastraPessoa()
            Navigation.findNavController(it).navigate(CadastroFragmentDirections.actionCadastroFragmentToHomeFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.ajuda_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.opcao_menu_ajuda){
            Toast.makeText(context, "Ajuda da tela de Cadastro", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}