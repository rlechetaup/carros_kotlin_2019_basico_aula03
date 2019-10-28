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

        // Usa a função apply porque o carro pode ser nulo
        cidade.apply {
            // Vamos mostrar a localização do usuário apenas para carros com lat/lng=0.
            if (lat.toDouble() == 0.0) {
                // Ativa o botão para mostrar minha localização
                val ok = PermissionUtils.validate(this@CidadeActivity, 1,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
                if (ok) {
                    // Somente usa o GPS se a permissão estiver OK.
                    map.isMyLocationEnabled = true
                }
            } else {
                // Cria o objeto lat/lng com a coordenada da fábrica
                val location = LatLng(lat, lng)
                // Posiciona o mapa na coordenada da fábrica (zoom = 13)
                val update = CameraUpdateFactory.newLatLngZoom(location, 13f)
                map.moveCamera(update)
                // Marcador no local da fábrica
                map.addMarker(
                    MarkerOptions()
                    .title(nome)
                    .position(location))
            }

            // Tipo do mapa: normal, satélite, terreno ou híbrido
            map.mapType = GoogleMap.MAP_TYPE_NORMAL
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
