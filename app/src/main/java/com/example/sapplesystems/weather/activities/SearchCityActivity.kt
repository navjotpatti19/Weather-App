package com.example.sapplesystems.weather.activities

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.widget.*
import com.example.sapplesystems.weather.R
import com.google.android.gms.location.FusedLocationProviderClient
import java.io.*
import java.util.HashMap

class SearchCityActivity : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val REQUEST_ID_MULTIPLE_PERMISSIONS = 1
    var line: String? = null
    val aList = ArrayList<String>()

    lateinit var autocomplete_cityname: AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_city)
        autocomplete_cityname = findViewById(R.id.autocomplete_cityname)

        // method for requesting and granting location permission
        checkAndRequestPermission()

        //binding the adapter with list of cities
        val adapter = ArrayAdapter(this@SearchCityActivity, R.layout.support_simple_spinner_dropdown_item, aList)
        autocomplete_cityname.setAdapter(adapter)

        autocomplete_cityname.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(this@SearchCityActivity, CurrentWeatherActivity::class.java)
            intent.putExtra("CITY_NAME", autocomplete_cityname.text.toString().trim())
            startActivity(intent)
//            finish()
        }
    }

    // method to read data from file placed in assets folder
    private fun readData() {
        try {
            val inputStream = assets.open("cityList.txt")
            val inputStreamReader = InputStreamReader(inputStream)
            val br = BufferedReader(inputStreamReader)
            while (br.readLine() != null) {
                line = br.readLine()
                val str = line.toString().split("\t")
                aList.add(str[1].trim())
            }
        } catch(e: IOException) {
            Toast.makeText(this@SearchCityActivity, "Exception Occurs", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkAndRequestPermission(): Boolean {
        val fineLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        val coarseLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        val readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        val writePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        val listOfPermissions = ArrayList<String>()

        if(fineLocationPermission != PackageManager.PERMISSION_GRANTED) {
            listOfPermissions.add(Manifest.permission.ACCESS_FINE_LOCATION)
        }

        if(coarseLocationPermission != PackageManager.PERMISSION_GRANTED) {
            listOfPermissions.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        if(readPermission != PackageManager.PERMISSION_GRANTED) {
            listOfPermissions.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        if(writePermission != PackageManager.PERMISSION_GRANTED) {
            listOfPermissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        if(!listOfPermissions.isEmpty()) {
            ActivityCompat.requestPermissions(this, listOfPermissions.toTypedArray(), REQUEST_ID_MULTIPLE_PERMISSIONS)
            return false
        } else {
            readData()
            return true
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            REQUEST_ID_MULTIPLE_PERMISSIONS -> {

                val perms = HashMap<String, Int>()
                //initialize the map with both permissions
                perms[Manifest.permission.ACCESS_COARSE_LOCATION] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.ACCESS_FINE_LOCATION] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.READ_EXTERNAL_STORAGE] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.WRITE_EXTERNAL_STORAGE] = PackageManager.PERMISSION_GRANTED

                if(grantResults.isNotEmpty()) {
                    for (i in permissions.indices)
                        perms[permissions[i]] = grantResults[i]

                    //check for all permissions
                    if(perms[Manifest.permission.ACCESS_FINE_LOCATION] == PackageManager.PERMISSION_GRANTED
                            && perms[Manifest.permission.ACCESS_COARSE_LOCATION] == PackageManager.PERMISSION_GRANTED
                            && perms[Manifest.permission.READ_EXTERNAL_STORAGE] == PackageManager.PERMISSION_GRANTED
                            && perms[Manifest.permission.WRITE_EXTERNAL_STORAGE] == PackageManager.PERMISSION_GRANTED) {
                        readData()
                    } else {

                        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)
                                || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                                || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                                || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {

                            showDialogWithMsg("Location permissions are required for this app",
                                    DialogInterface.OnClickListener { dialog, which ->
                                        when(which) {

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

    //method to get permission from settings if user deny the permission after clicking checkbox on permission dialog
    private fun permissionInSettings(msg: String) {
        val dialog = android.support.v7.app.AlertDialog.Builder(this)
        dialog.setMessage(msg)
                .setPositiveButton("OK") {
                    paramDialogInterface, paramInt ->
                    startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                            Uri.parse("package:com.example.sapplesystems.weather")))
                }
                .setNegativeButton("Cancel") {
                    paramDialogInterface, paramInt ->
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
