package br.com.livroandroid.carros.cidades

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import br.com.livroandroid.carros.R
import br.com.livroandroid.carros.favoritos.FavoritosService
import br.com.livroandroid.carros.lista.Carro
import br.com.livroandroid.carros.utils.extensions.loadUrl
import kotlinx.android.synthetic.main.activity_carro.*

import kotlinx.android.synthetic.main.activity_cidade.*
import kotlinx.android.synthetic.main.activity_cidade.img
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class CidadeActivity : AppCompatActivity() {

    val cidade by lazy {
        // Quando suar a variável carro vai ler do parâmetro
        intent.getSerializableExtra("cidade") as Cidade
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carro)

        img.loadUrl(cidade.urlFoto)

        supportActionBar?.title = cidade.nome
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_cidade, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home) {
            // Estou fazendo Finish na mao para desempilhar a tela
            // Assim não perdemos o scroll da lista de carros
            // Por padrao o voltar do Android cria outra activity ao voltar.
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}
