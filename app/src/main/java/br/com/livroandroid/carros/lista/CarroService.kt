package br.com.livroandroid.carros.lista

import android.util.Log
import br.com.livroandroid.carros.utils.extensions.fromJson
import br.com.livroandroid.carros.utils.HttpHelper

// Web Service dos carros
class CarroService {

    // isso faz com que os métodos aqui dentro fiquem estáticos
    companion object {

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