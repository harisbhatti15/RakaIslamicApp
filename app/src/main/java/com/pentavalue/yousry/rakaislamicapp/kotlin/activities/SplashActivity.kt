package com.pentavalue.yousry.rakaislamicapp.kotlin.activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.marcinorlowski.fonty.Fonty
import com.pentavalue.yousry.rakaislamicapp.R
import com.pentavalue.yousry.rakaislamicapp.Util.Util
import com.pentavalue.yousry.salaty.kotlin.models.GPSTracker
import kotlinx.android.synthetic.main.activity_splash.*


@Suppress("IMPLICIT_CAST_TO_ANY")
class SplashActivity : AppCompatActivity() {

    val PERMISSIONS_REQUEST_ACCESS_LOCATION: Int = 100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Fonty.setFonts(this)
        avi.setIndicator(Util.ANIMATION_LOADING)
        try {
            val sharedPref: SharedPreferences = getSharedPreferences(Util.SHARED_KEY, Context.MODE_PRIVATE)

            val intent = Intent(this, HomeActivity::class.java)

            if (Util.isNetworkAvailable(this)) {
                getLocation()
            } else {
                Toast.makeText(this, getString(R.string.no_internet_message), Toast.LENGTH_SHORT).show()

                onHandlerRunning(false)

            }
        } catch (e: KotlinNullPointerException) {
            //Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            locationCheck = false
        }
    }


    var locationCheck: Boolean = false;
    var x = 0L
    override fun onResume() {
        super.onResume()

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSIONS_REQUEST_ACCESS_LOCATION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                runLocation()
            } else {
                Toast.makeText(this, "Until you grant the permission, we canot take your location", Toast.LENGTH_SHORT).show();
                val intent = Intent(this, HomeActivity::class.java)
                locationCheck = false
                startActivity(intent.putExtra("location", locationCheck))
                finish()
            }
        }
    }


    private fun getLocation(): Boolean {
        var result = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //Toast.makeText(this, "This Version "+Build.VERSION.BASE_OS+" is not support", Toast.LENGTH_LONG).show()
            requestPermissions(arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION), PERMISSIONS_REQUEST_ACCESS_LOCATION);
        } else {
            result = true
            runLocation()

        }
        return result
    }

    @SuppressLint("ApplySharedPref")
    private fun runLocation() {
        val gps = GPSTracker(this)
        val location = gps.getLocation()
        val gcd = Geocoder(this, resources.configuration.locale)
        try {
            val addresses = gcd.getFromLocation(location!!.latitude, location?.longitude, 1)
            val nameOfCity: String = addresses[0].adminArea
            val nameOfCountry: String = addresses[0].countryName
            //Toast.makeText(this, """City is $nameOfCity Country is $nameOfCountry""", Toast.LENGTH_LONG).show()
            val preferences = getSharedPreferences(Util.SHARED_KEY, Context.MODE_PRIVATE)
            locationCheck = true
            val editor = preferences.edit()
            editor!!.putBoolean(Util.CHECK_LOACTION, true)
            editor.putString(Util.CITY_SHARED_PREFERENCE, nameOfCity)
            editor.putString(Util.COUNTRY_SHARED_PREFERENCE, nameOfCountry)
            editor.apply()
            onHandlerRunning(true)
        } catch (e: KotlinNullPointerException) {
            //Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            locationCheck = false
            onHandlerRunning(false)
        }
    }

    fun onHandlerRunning(a: Boolean) {
        Handler().postDelayed({
            locationCheck = a
            val intent = Intent(this, HomeActivity::class.java)

            startActivity(intent.putExtra("location", locationCheck))
            finish()
        }, 5000)
    }
}
