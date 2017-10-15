package com.pentavalue.yousry.rakaislamicapp.kotlin.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.marcinorlowski.fonty.Fonty
import com.marcinorlowski.fonty.Utils
import com.pentavalue.yousry.rakaislamicapp.R
import com.pentavalue.yousry.rakaislamicapp.Util.Util
import com.pentavalue.yousry.rakaislamicapp.java.adapters.CountryAdpater
import kotlinx.android.synthetic.main.activity_country.*

class CountryActivity : AppCompatActivity() {

    val TAG : String? = CountryActivity::class.java.simpleName
    @SuppressLint("ApplySharedPref")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)
        Fonty.setFonts(this)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)


        val sharedPref =getSharedPreferences(Util.SHARED_KEY, Context.MODE_PRIVATE)
        val country = sharedPref.getString(Util.COUNTRY_SHARED_PREFERENCE, "")
        val position = sharedPref.getInt(Util.POSITION_COUNTRY_EXTRA, -1)

        var checker = false;
        if(intent.hasExtra("dialog")){
            checker =intent.getBooleanExtra("diaolog", false)
        }
        val adapter : CountryAdpater? = CountryAdpater(resources.getStringArray(R.array.countries).toList(),this,
                country, position,
                CountryAdpater.OnItemClickedListener { view, country, position
                    ->

                    if(!checker){
                        val intent = Intent()
                        intent.putExtra(Util.COUNTRY_EXTRA, country)
                        intent.putExtra(Util.POSITION_COUNTRY_EXTRA, position)
                        setResult(Activity.RESULT_OK, intent)
                        onBackPressed()
                    }else{
                        val shared_pref = getSharedPreferences(Util.SHARED_KEY, Context.MODE_PRIVATE)
                        val editor = shared_pref.edit()
                        editor.putString(Util.COUNTRY_SHARED_PREFERENCE, country)
                        editor.putInt(Util.POSITION_COUNTRY_EXTRA, position)
                        editor.commit()
                        editor.apply()
                        finish()
                    }

                })
        Log.v(TAG, "The Postion is $position")
        Log.v(TAG, "The Country is $country")




        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        recycler_view.layoutManager = llm
        recycler_view.adapter =adapter;
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
