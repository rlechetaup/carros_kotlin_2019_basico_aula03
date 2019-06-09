package br.com.livroandroid.carros.domain

class Response {
    var status = ""
    var msg = ""
    fun isOk(): Boolean {
        return "OK" == status
    }
}