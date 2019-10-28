package br.com.livroandroid.carros.cidades

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

class Cidade : Serializable {

    var id: Long = 0
    var nome = ""
    var urlFoto = ""
    var lat = 0.0;
    var lng = 0.0;

//    var pontosTuristicos : List<PontoTuristico>;

    override fun toString(): String {
        return nome
    }
}

class PontoTuristico : Serializable {

    var nome = ""
    var urlFoto = ""
    var lat = 0.0;
    var lng = 0.0;

    override fun toString(): String {
        return nome
    }
}