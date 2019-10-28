package br.com.livroandroid.carros.lista

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.livroandroid.carros.R
import br.com.livroandroid.carros.favoritos.FavoritosService
import br.com.livroandroid.carros.utils.extensions.loadUrl
import kotlinx.android.synthetic.main.activity_carro.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

// Detalhes do carro
// Possui o botão para favoritar na ActionBar
class CarroActivity : AppCompatActivity() {

    val carro by lazy {
        // Quando suar a variável carro vai ler do parâmetro
        intent.getSerializableExtra("carro") as Carro
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carro)

        img.loadUrl(carro.urlFoto)

        supportActionBar?.title = carro.nome
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_carro, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home) {
            // Estou fazendo Finish na mao para desempilhar a tela
            // Assim não perdemos o scroll da lista de carros
            // Por padrao o voltar do Android cria outra activity ao voltar.
            finish()
        } else if(item?.itemId == R.id.action_favoritar) {
            favoritar()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun favoritar() {
        /**
         * Favoritar o carro
         */
        doAsync {
            val favoritado = FavoritosService.favoritar(carro)

            uiThread {
                if (favoritado) {
                    toast("Carro favoritado com sucesso")
                } else {
                    toast("Carro removido dos favoritos")
                }
            }
        }
    }
}
