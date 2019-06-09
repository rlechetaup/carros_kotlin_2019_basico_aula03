package br.com.livroandroid.carros.adapter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.livroandroid.carros.R
import br.com.livroandroid.carros.fragment.CarrosFragment
import br.com.livroandroid.carros.fragment.FavoritosFragment

class TabsAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    // Qtde de Tabs
    override fun getCount() = 2

    // Título da Tab
    override fun getPageTitle(position: Int): CharSequence {
        if(position == 0) {
            return context.getString(R.string.tab1)
        }
        return context.getString(R.string.tab2)
    }

    // Fragment com a lista de carros
    override fun getItem(position: Int): Fragment {
        if(position == 0) {
            return CarrosFragment()
        }
        return FavoritosFragment()
    }
}