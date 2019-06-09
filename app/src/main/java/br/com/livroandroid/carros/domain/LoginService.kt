package br.com.livroandroid.carros.domain

import android.util.Log
import br.com.livroandroid.carros.extensions.fromJson
import br.com.livroandroid.carros.utils.HttpHelper

object LoginService {

    fun login(login:String, senha:String): Response {
        // Post
        //http://livrowebservices.com.br/rest/login

        try {
            val url = "http://livrowebservices.com.br/rest/login"
            Log.d("up","post $url")

            val params = mutableMapOf<String,String>()
            params["login"] = login
            params["senha"] = senha

            val json = HttpHelper.postForm(url, params)
            Log.d("up","json: $json")
            val response = fromJson<Response>(json)
            Log.d("up","response: $response")
            return response
        }catch (error: Exception) {
            Log.e("up","Error $error")
            throw error
        }
    }
}