package br.com.livroandroid.carros.utils.extensions

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.toastUP(s: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, s, length).show()
}