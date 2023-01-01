package com.seda.huaweimapkitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.MapView
import com.huawei.hms.maps.OnMapReadyCallback
import com.seda.huaweimapkitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMainBinding
    private var hMap: HuaweiMap?=null
    private var mMapView: MapView?=null
    companion object {
        private const val TAG = "MapViewDemoActivity"
        private const val MAPVIEW_BUNDLE_KEY = "MapViewBundleKey"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var mapViewBundle: Bundle? = null

        if (savedInstanceState != null) {
            mapViewBundle =
                savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY)
        }
binding.mapView.onCreate(mapViewBundle)
binding.mapView.getMapAsync(this)
    }
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onMapReady(p0: HuaweiMap?) {

      hMap = p0




    }


    override fun onStart() {
        super.onStart()
        mMapView?.onStart()
    }

    override fun onResume() {
        super.onResume()
        mMapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mMapView?.onPause()
    }

    override fun onStop() {
        super.onStop()
        mMapView?.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMapView?.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mMapView?.onLowMemory()
    }
    //InstanceState
    //Android‘in kullanıcıdan alınan değerleri tutup
    // performansa olumsuz etkisi olmaması için
   // statik değer olduğu farzedilen değerleri hafızaya almamasıdır.
  //Bu sorunun çözmenin yolu; telefonun yönü değiştiğinde sırası
  // ile onSaveInstanceState ve onRestoreInstanceState olayları tetikleniyor.
}