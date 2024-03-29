package br.com.livroandroid.carros.lista


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager

import br.com.livroandroid.carros.R
import kotlinx.android.synthetic.main.fragment_carros.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

/**
 * A simple [Fragment] subclass.
 *
 */
class CarrosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_carros, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()

        // Swipe to Refresh
        swipeToRefresh.setOnRefreshListener {
            taskCarros()
        }
        swipeToRefresh.setColorSchemeResources(
            R.color.refresh_progress_1,
            R.color.refresh_progress_2,
            R.color.refresh_progress_3
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        taskCarros()
    }

    private fun taskCarros() {
        doAsync {
            val carros = CarroService.getCarros()

            uiThread {
                recyclerView.adapter = CarroAdapter(carros) { c -> onClickCarro(c) }

                swipeToRefresh.isRefreshing = false
            }
        }

    }

    private fun onClickCarro(c: Carro) {
        activity?.toast("Carro ${c.nome}")

//        val intent = Intent(this, CarroActivity::class.java)
//        intent.putExtra("carro", c)
//        startActivity(intent)

        //import org.jetbrains.anko.startActivity
        activity?.startActivity<CarroActivity>("carro" to c)

    }

}
