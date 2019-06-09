package br.com.livroandroid.carros.lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.livroandroid.carros.R

// Activity com a lista de carros
// No layout XML dela é adicionado o componente da lista que é o fragment
// Não estamos mais utilizando essa classe...
class CarrosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carros)


    }


}