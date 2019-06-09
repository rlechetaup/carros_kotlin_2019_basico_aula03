package br.com.livroandroid.carros.login

class LoginResponse {
    var status = ""
    var msg = ""
    fun isOk(): Boolean {
        return "OK" == status
    }
}