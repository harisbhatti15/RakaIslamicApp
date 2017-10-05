package com.pentavalue.yousry.rakaislamicapp.kotlin.activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.pentavalue.yousry.rakaislamicapp.R
import com.pentavalue.yousry.rakaislamicapp.Util.Util
import com.pentavalue.yousry.salaty.kotlin.models.GPSTracker
import kotlinx.android.synthetic.main.activity_splash.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import kotlin.concurrent.timerTask
import android.preference.PreferenceManager
import android.content.Intent
import com.marcinorlowski.fonty.Fonty
import com.pentavalue.yousry.rakaislamicapp.java.dialogs.CustomDialog


@Suppress("IMPLICIT_CAST_TO_ANY")
class SplashActivity : AppCompatActivity() {

    val PERMISSIONS_REQUEST_ACCESS_LOCATION: Int =100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Fonty.setFonts(this)
        avi.setIndicator(Util.ANIMATION_LOADING);
    }

    var locationCheck :Boolean =false;
    var x = 0L
    override fun onResume() {
        super.onResume()
        try {

            val sharedPref :SharedPreferences = getSharedPreferences(Util.SHARED_KEY, Context.MODE_PRIVATE)

            val intent = Intent(this, HomeActivity::class.java)

            /*if(sharedPref != null && sharedPref!!.getBoolean(Util.CHECK_LOACTION,false)){
                Handler().postDelayed({
                    locationCheck =true
                    Toast.makeText(this,"Done",Toast.LENGTH_LONG).show()
                    startActivity(intent.putExtra("location",locationCheck))
                    finish()
                }, 5000)
            }*/
            if(Util.isNetworkAvailable(this)){
                getLocation()
            }else{
                Toast.makeText(this, getString(R.string.no_internet_message), Toast.LENGTH_SHORT).show()

                Handler().postDelayed({
                    locationCheck =false
                    startActivity(intent.putExtra("location",locationCheck))
                    finish()
                }, 5000)
            }
        }catch (e :KotlinNullPointerException){
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
            locationCheck =false
        }
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
                locationCheck =false
                startActivity(intent.putExtra("location",locationCheck))
                finish()
            }
        }
    }



    private fun getLocation() :Boolean {
        var result =false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
         //if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //Toast.makeText(this, "This Version "+Build.VERSION.BASE_OS+" is not support", Toast.LENGTH_LONG).show()
            requestPermissions(arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION), PERMISSIONS_REQUEST_ACCESS_LOCATION);
        } else {
            runLocation()
        }
        return result
    }
    @SuppressLint("ApplySharedPref")
    private fun runLocation(){
        val gps = GPSTracker(this)
        val location = gps.getLocation()
        val gcd = Geocoder(this, resources.configuration.locale)
        try{
            val addresses = gcd.getFromLocation(location!!.latitude, location?.longitude, 1)
            val nameOfCity: String = addresses[0].adminArea
            val nameOfCountry: String = addresses[0].countryName
            Toast.makeText(this,
                    """City is $nameOfCity Country is $nameOfCountry""",
                    Toast.LENGTH_LONG).show()
            val preferences = getSharedPreferences(Util.SHARED_KEY, Context.MODE_PRIVATE)
            locationCheck =true
            val editor = preferences.edit()
            editor!!.putBoolean(Util.CHECK_LOACTION,true)
            editor.putString(Util.CITY_SHARED_PREFERENCE,nameOfCity)
            editor.putString(Util.COUNTRY_SHARED_PREFERENCE,nameOfCountry)
            editor.apply()
            val intent = Intent(this, HomeActivity::class.java)
            Handler().postDelayed({
                Toast.makeText(this,"Done",Toast.LENGTH_LONG).show()
                locationCheck =true
                startActivity(intent.putExtra("location",locationCheck))
                finish()
            }, 5000)
        }catch (e: KotlinNullPointerException){
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
            locationCheck =false
        }
    }
}
