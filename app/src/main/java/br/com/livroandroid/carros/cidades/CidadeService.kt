package br.com.livroandroid.carros.cidades

import android.util.Log
import br.com.livroandroid.carros.utils.extensions.fromJson
import br.com.livroandroid.carros.utils.HttpHelper

// Web Service dos carros
class CidadeService {

    // isso faz com que os métodos aqui dentro fiquem estáticos
    companion object {

        fun getCidades(): List<Cidade> {
            try {
                val url = "http://www.mocky.io/v2/5db35e0a300000500057b628"
                Log.d("up","get $url")
                val json = HttpHelper.get(url)
                Log.d("up","json: $json")
                val cidades = fromJson<List<Cidade>>(json)
                Log.d("up","cidades: $cidades")
                return cidades
            }catch (error: Exception) {
                Log.e("up","Error $error")
            }
            return emptyList()
        }
    }


}