package br.com.livroandroid.carros.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import br.com.livroandroid.carros.R
import br.com.livroandroid.carros.home.TabsAdapter
import kotlinx.android.synthetic.main.activity_main.*

// Home com Tabs
// O ViewPager faz o carroussel
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPagerTabs()
    }

    private fun setupViewPagerTabs() {
        viewPager.adapter = TabsAdapter(this, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

        val cor = ContextCompat.getColor(this, R.color.branco)
        tabLayout.setTabTextColors(cor, cor)
    }
}
