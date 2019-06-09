package br.com.livroandroid.carros.domain

import android.util.Log
import br.com.livroandroid.carros.extensions.fromJson
import br.com.livroandroid.carros.utils.HttpHelper

/**
 * Implementação com OkHttp
 */
class CarroService {

    companion object {

        // Busca os carros por tipo (clássicos, esportivos ou luxo)
        fun getCarros(): List<Carro> {
            try {
                val url = "http://livrowebservices.com.br/rest/carros"
                Log.d("up","get $url")
                val json = HttpHelper.get(url)
                Log.d("up","json: $json")
                val carros = fromJson<List<Carro>>(json)
                Log.d("up","carros: $carros")
                return carros
            }catch (error: Exception) {
                Log.e("up","Error $error")
            }
            return emptyList()
        }
    }


}