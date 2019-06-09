package br.com.livroandroid.carros.lista

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Carro : Serializable {

    @PrimaryKey
    var id: Long = 0
    var tipo = ""
    var nome = ""
    var desc = ""
    var urlFoto = ""
    var urlInfo = ""
    var urlVideo = ""

    override fun toString(): String {
        return nome
    }
}