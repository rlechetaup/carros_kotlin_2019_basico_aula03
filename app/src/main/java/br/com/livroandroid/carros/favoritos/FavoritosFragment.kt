package br.com.livroandroid.carros.favoritos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.livroandroid.carros.R
import br.com.livroandroid.carros.lista.Carro
import br.com.livroandroid.carros.lista.CarroActivity
import br.com.livroandroid.carros.lista.CarroAdapter
import kotlinx.android.synthetic.main.fragment_carros.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

// Componente da lista de favoritos
class FavoritosFragment : Fragment() {

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

    override fun onResume() {
        super.onResume()

        taskCarros()
    }

    private fun taskCarros() {
        doAsync {
            val carros = FavoritosService.getCarros()

            uiThread {
                recyclerView.adapter = CarroAdapter(carros) { c -> onClickCarro(c) }

                swipeToRefresh.isRefreshing = false
            }
        }

    }

    private fun onClickCarro(c: Carro) {

        //import org.jetbrains.anko.startActivity
        activity?.startActivity<CarroActivity>("carro" to c)

    }

}
