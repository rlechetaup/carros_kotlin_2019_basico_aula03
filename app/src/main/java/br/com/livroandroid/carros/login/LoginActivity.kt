package br.com.livroandroid.carros.login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.livroandroid.carros.R
import br.com.livroandroid.carros.home.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*

// Tela de Login
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //val btLogin = findViewById<Button>(R.id.btOk)


        btLogin.setOnClickListener { onClickLogin() }
    }

    fun getContext() : Context {
        return this
    }

    private fun onClickLogin() {

        val login = tLogin.text.toString()
        val senha = tSenha.text.toString()

        doAsync {
            val response = LoginService.login(login, senha)

            uiThread {
                if(response.isOk()) {
//                    val intent = Intent(getContext(), CarrosActivity::class.java)
//                    intent.putExtra("nome", "Ricardo")
//                    startActivity(intent)

                    startActivity<MainActivity>("nome" to "Ricardo")

                    finish()
                } else {
//                    toast(response.msg)
                    alert(response.msg,"UP").show()
                }
            }
        }
    }
}
