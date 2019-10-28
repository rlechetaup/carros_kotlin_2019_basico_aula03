package br.com.livroandroid.carros.cidades


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager

import br.com.livroandroid.carros.R
import br.com.livroandroid.cidades.cidades.CidadeAdapter
import kotlinx.android.synthetic.main.fragment_carros.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

/**
 * A simple [Fragment] subclass.
 *
 */
class CidadesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_cidades, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()

        // Swipe to Refresh
        swipeToRefresh.setOnRefreshListener {
            taskCidades()
        }
        swipeToRefresh.setColorSchemeResources(
            R.color.refresh_progress_1,
            R.color.refresh_progress_2,
            R.color.refresh_progress_3
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        taskCidades()
    }

    private fun taskCidades() {
        doAsync {
            val carros = CidadeService.getCidades()

            uiThread {
                recyclerView.adapter = CidadeAdapter(carros) { c -> onClickCidade(c) }

                swipeToRefresh.isRefreshing = false
            }
        }

    }

    private fun onClickCidade(c: Cidade) {
        activity?.toast("Cidade ${c.nome}")

//        val intent = Intent(this, CidadeActivity::class.java)
//        intent.putExtra("carro", c)
//        startActivity(intent)

        //import org.jetbrains.anko.startActivity
        activity?.startActivity<CidadeActivity>("cidade" to c)

    }

}
