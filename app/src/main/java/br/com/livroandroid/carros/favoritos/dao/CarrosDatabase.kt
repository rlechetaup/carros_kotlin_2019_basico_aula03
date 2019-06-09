package br.com.livroandroid.carros.favoritos.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.livroandroid.carros.lista.Carro

// Define as classes que precisam ser persistidas e a versão do banco
@Database(entities = arrayOf(Carro::class), version = 1, exportSchema = false)
abstract class CarrosDatabase : RoomDatabase() {
    abstract fun carroDAO(): CarroDAO

}
