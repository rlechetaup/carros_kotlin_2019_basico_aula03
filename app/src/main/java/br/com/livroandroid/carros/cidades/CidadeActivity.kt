package br.com.livroandroid.carros.cidades

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.livroandroid.carros.R
import br.com.livroandroid.carros.utils.PermissionUtils
import br.com.livroandroid.carros.utils.extensions.loadUrl
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_carro.*
import kotlinx.android.synthetic.main.activity_cidade.*
import kotlinx.android.synthetic.main.activity_cidade.img

class CidadeActivity : AppCompatActivity() , OnMapReadyCallback {
    // Objeto que controla o Google Maps
    private var map: GoogleMap? = null

    val cidade by lazy {
        // Quando suar a variável carro vai ler do parâmetro
        intent.getSerializableExtra("cidade") as Cidade
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cidade)

        img.loadUrl(cidade.urlFoto)

        // Inicia o Mapa
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        supportActionBar?.title = cidade.nome
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(map: GoogleMap) {
        // O método onMapReady(map) é chamado quando a inicialização do mapa estiver Ok
        this.map = map

        map.mapType = GoogleMap.MAP_TYPE_NORMAL

        // Localização do mapa
        val update = CameraUpdateFactory.newLatLngZoom(LatLng(cidade.lat, cidade.lng), 11.0f)
        map.moveCamera(update)

        // Adiciona os marcadores
        cidade.pontosTuristicos.forEach { p ->
            map.addMarker(
                MarkerOptions()
                    .title(p.nome)
                    .position(LatLng(p.lat, p.lng)))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_cidade, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}
