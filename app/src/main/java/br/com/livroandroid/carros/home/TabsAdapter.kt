package br.com.livroandroid.carros.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.livroandroid.carros.R
import br.com.livroandroid.carros.cidades.CidadesFragment
import br.com.livroandroid.carros.favoritos.FavoritosFragment
import br.com.livroandroid.carros.lista.CarrosFragment

// Controla a quantidade de tabs
class TabsAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    // Qtde de Tabs
    override fun getCount() = 3

    // Título da Tab
    override fun getPageTitle(position: Int): CharSequence {
        if(position == 0) {
            return context.getString(R.string.tab1)
        } else if(position == 1) {
            return context.getString(R.string.tab2)
        } else {
            return context.getString(R.string.tab3)
        }
    }

    // Fragment com a lista de carros
    override fun getItem(position: Int): Fragment {
        if(position == 0) {
            return CarrosFragment()
        } else if(position == 1) {
            return FavoritosFragment()
        } else {
            return CidadesFragment()
        }

    }
}