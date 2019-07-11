package com.example.aplicacion2

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback,
    GoogleMap.OnCameraMoveStartedListener,
    GoogleMap.OnCameraIdleListener,
    GoogleMap.OnCameraMoveListener,
    GoogleMap.OnPolylineClickListener,
    GoogleMap.OnPolygonClickListener {

    override fun onPolylineClick(p0: Polyline?) {
        Log.i("mapMove", "PolyLinea: //////    ${p0.toString()}")
    }

    override fun onPolygonClick(p0: Polygon?) {
        Log.i("mapMove", "Polygon: //////    ${p0.toString()}")
    }

    override fun onCameraMoveStarted(p0: Int) {
        Log.i("mapMove", "Me voy a empezar a mover")
    }

    override fun onCameraIdle() {
        Log.i("mapMove", "Me quedo quieto")
    }

    override fun onCameraMove() {
        Log.i("mapMove", "Me estoy mociendo")
    }

    private lateinit var mMap: GoogleMap
    private var tienePermisosLocalizacion = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
//        1) Que permisos necesita esta actividad
//        2) Revisar esos permisos
        solicitarPermisosLocalizacion()

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        establecerConfiguracionMapa(mMap)
        establecerListenersMovimientoMapa(mMap)
        // Add a marker in Sydney and move the camera
        val epn = LatLng(-0.210169, -78.488632)
        val titulo = "EPN"
        anadirMArcador(epn, titulo)
        moverCamaraConZoom(epn)

        val polyLineaUno = googleMap.addPolyline(
            PolylineOptions().clickable(true).add(
                LatLng(-0.210462, -78.493948),
                LatLng(-0.208218, -78.490163),
                LatLng(-0.208583, -78.488940),
                LatLng(-0.209377, -78.490303)
            )
        )
        val poligonoUno = googleMap.addPolygon(
            PolygonOptions().clickable(true).add(
                LatLng(-0.209431, -78.490078),
                LatLng(-0.208734, -78.488951),
                LatLng(-0.209431, -78.488286),
                LatLng(-0.210085, -78.489745)
            )
        )

//        poligonoUno.fillColor = -0xc771c4
        poligonoUno.fillColor = Color.RED

        mMap.setOnMarkerClickListener {
            Toast.makeText(this, "${mMap.myLocation.longitude} ${mMap.myLocation.latitude}", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "${mMap.myLocation.longitude} ${mMap.myLocation.latitude}", Toast.LENGTH_LONG).show();
            true
        }
    }

    fun establecerListenersMovimientoMapa(map: GoogleMap) {
        with(map) {
            setOnCameraIdleListener(this@MapsActivity)
            setOnCameraMoveStartedListener(this@MapsActivity)
            setOnCameraMoveListener(this@MapsActivity)
            setOnCameraMoveListener(this@MapsActivity)
            setOnPolygonClickListener(this@MapsActivity)
            setOnPolylineClickListener(this@MapsActivity)
        }
    }

    fun anadirMArcador(latLng: LatLng, title: String) {
        mMap.addMarker(MarkerOptions().position(latLng).title(title))
    }

    fun moverCamaraConZoom(latLng: LatLng, zoom: Float = 13f) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13f))
    }

    fun establecerConfiguracionMapa(mapa: GoogleMap) {
        val contexto = this.applicationContext
        with(mapa) {
            val permisoFineLocation = ContextCompat
                .checkSelfPermission(
                    contexto,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )

            val tienePermiso = permisoFineLocation == PackageManager.PERMISSION_GRANTED
            if (tienePermiso) {
                mapa.isMyLocationEnabled = true
            }

            this.uiSettings.isZoomControlsEnabled = true
            uiSettings.isMyLocationButtonEnabled = true
        }

    }

    fun solicitarPermisosLocalizacion() {
        val permisoFineLocation = ContextCompat
            .checkSelfPermission(
                this.applicationContext,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )

        val tienePermiso = permisoFineLocation == PackageManager.PERMISSION_GRANTED

        if (tienePermiso) {
            Log.i("mapa", "Tiene permisos de FINE_LOCATION")
            this.tienePermisosLocalizacion = true
        } else {
            // Codigo que vamos a esperar (1)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (resultCode) {
            Activity.RESULT_OK -> {
                Log.i("intent-respuesta", "Lo logramos!!!! ${Activity.RESULT_OK}")
                when (requestCode) {
                    304 -> {
                        Log.i("intent-respuesta", "Contacto llego!!!!")
                        val uri = data?.data
                        var cursor = contentResolver.query(uri, null, null, null, null)
                        cursor.moveToFirst()
                        val indiceTelefono = cursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                        )

                        val telefono = cursor.getString(indiceTelefono)
                        Log.i("intent-respuesta", "Telefono ${telefono}")

                    }
                    305 -> {
                        val nombre = data?.getStringExtra("nombreUsuario")
                        val edad = data?.getIntExtra("edadUsuario", 0)
                        Log.i("intent-respuesta", "Nombre: $nombre //////////   Edad: $edad")
                    }
                }
            }
            Activity.RESULT_CANCELED -> {
                Log.i("intent-respuesta", "No escogiooo!!! ${Activity.RESULT_CANCELED}")
            }
        }
    }

}
