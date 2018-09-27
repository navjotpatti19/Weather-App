package com.example.sapplesystems.weather.activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.sapplesystems.weather.R
import com.example.sapplesystems.weather.adapters.DataAdapter
import com.example.sapplesystems.weather.interfaces.RequestInterface
import com.example.sapplesystems.weather.models.ListData
import com.example.sapplesystems.weather.models.RootObject
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val REQUEST_ID_MULTIPLE_PERMISSIONS = 1
    private lateinit var cityName: String

    private var compositeDisposable:CompositeDisposable? = null

    private var dataArrayList: List<ListData>? = null

    private var mAdapter: DataAdapter? = null

    companion object {
        var BASE_URL: String = "http://api.openweathermap.org"
        val API_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" //put your API key from open weather API to get the weather forecasting data of 5 days
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkAndRequestPermission()

        cityName = intent.getStringExtra("CITY_NAME")

        compositeDisposable = CompositeDisposable()

        initRecyclerView()

        loadJson()
    }

    //initialize the recycler view
    private fun initRecyclerView() {
        recyclerView.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    private fun loadJson() {
        val requestInterface = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RequestInterface::class.java)

        compositeDisposable?.add(requestInterface.getData(cityName,"metric", API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError))
    }

    private fun handleResponse(rootObject: RootObject) {
        dataArrayList = rootObject.list
        mAdapter = DataAdapter(dataArrayList!!, this)
        recyclerView.adapter = mAdapter
    }

    private fun handleError(error: Throwable) {
        Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }

    @SuppressLint("MissingPermission")
    private fun findLocation() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this@MainActivity)

        fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location ->

                    val lat = location.latitude
                    val longi = location.longitude

//                    getCityName(lat, longi)
                }
    }

    /*private fun getCityName(lat: Double, longi: Double) {

        val geocoder = Geocoder(this, Locale.getDefault())
        var addresses: List<Address> = emptyList()
        addresses = geocoder.getFromLocation(lat, longi, 1)
        cityName = addresses.get(0).locality
        Toast.makeText(this, cityName, Toast.LENGTH_SHORT).show()
    }*/

    private fun checkAndRequestPermission(): Boolean {
        val fineLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        val coarseLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)

        val listOfPermissions = ArrayList<String>()

        if (fineLocationPermission != PackageManager.PERMISSION_GRANTED) {
            listOfPermissions.add(Manifest.permission.ACCESS_FINE_LOCATION)
        }

        if (coarseLocationPermission != PackageManager.PERMISSION_GRANTED) {
            listOfPermissions.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        if (!listOfPermissions.isEmpty()) {
            ActivityCompat.requestPermissions(this, listOfPermissions.toTypedArray(), REQUEST_ID_MULTIPLE_PERMISSIONS)
            return false
        } else {
            findLocation()
            return true
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_ID_MULTIPLE_PERMISSIONS -> {

                val perms = HashMap<String, Int>()
                //initialize the map with both permissions
                perms[Manifest.permission.ACCESS_COARSE_LOCATION] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.ACCESS_FINE_LOCATION] = PackageManager.PERMISSION_GRANTED

                if (grantResults.isNotEmpty()) {
                    for (i in permissions.indices)
                        perms[permissions[i]] = grantResults[i]

                    //check for all permissions
                    if (perms[Manifest.permission.ACCESS_FINE_LOCATION] == PackageManager.PERMISSION_GRANTED
                            && perms[Manifest.permission.ACCESS_COARSE_LOCATION] == PackageManager.PERMISSION_GRANTED) {
                        findLocation()
                    } else {

                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)
                                || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {

                            showDialogWithMsg("Location permissions are required for this app",
                                    DialogInterface.OnClickListener { dialog, which ->
                                        when (which) {

                                            DialogInterface.BUTTON_POSITIVE -> checkAndRequestPermission()
                                            DialogInterface.BUTTON_NEGATIVE -> finish()
                                        }
                                    })
                        } else {
                            permissionInSettings("You need to give some permissions for the proper working of app")
                        }
                    }
                }
            }
        }
    }

    private fun permissionInSettings(msg: String) {
        val dialog = android.support.v7.app.AlertDialog.Builder(this)
        dialog.setMessage(msg)
                .setPositiveButton("OK") { paramDialogInterface, paramInt ->
                    startActivity(Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                            Uri.parse("package:com.example.sapplesystems.weather")))
                }
                .setNegativeButton("Cancel") { paramDialogInterface, paramInt ->
                    finish()
                }
        dialog.show()
    }

    private fun showDialogWithMsg(msg: String, onClickListener: DialogInterface.OnClickListener) {
        AlertDialog.Builder(this)
                .setMessage(msg)
                .setPositiveButton("OK", onClickListener)
                .setNegativeButton("Cancel", onClickListener)
                .create()
                .show()
    }
}
