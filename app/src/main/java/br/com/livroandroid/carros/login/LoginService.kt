package br.com.livroandroid.carros.login

import android.util.Log
import br.com.livroandroid.carros.utils.HttpHelper
import br.com.livroandroid.carros.utils.extensions.fromJson

// API de Login
// "object" no Kotlin deixa essa classe com Singleton
object LoginService {

    fun login(login:String, senha:String): LoginResponse {

        try {
            val url = "http://livrowebservices.com.br/rest/login"
            Log.d("up","post $url")

            val params = mutableMapOf<String,String>()
            params["login"] = login
            params["senha"] = senha

            val json = HttpHelper.postForm(url, params)
            Log.d("up","json: $json")
            val response = fromJson<LoginResponse>(json)
            Log.d("up","response: $response")
            return response
        }catch (error: Exception) {
            Log.e("up","Error $error")
            throw error
        }
    }
}