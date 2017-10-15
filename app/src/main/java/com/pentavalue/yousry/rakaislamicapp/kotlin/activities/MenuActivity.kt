package com.pentavalue.yousry.rakaislamicapp.kotlin.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.marcinorlowski.fonty.Fonty
import com.pentavalue.yousry.rakaislamicapp.R
import com.pentavalue.yousry.rakaislamicapp.Util.Util
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    val COUNTRY_REQUEST: Int = 1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_menu)
        Fonty.setFonts(this)
        setSupportActionBar(my_toolbar)
        val sharedPref =getSharedPreferences(Util.SHARED_KEY, Context.MODE_PRIVATE)

        text_location.text =sharedPref.getString(Util.COUNTRY_SHARED_PREFERENCE, resources.getString(R.string.makka))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)
        country_item.setOnClickListener(View.OnClickListener { view->
            startActivityForResult(Intent(this,CountryActivity::class.java),COUNTRY_REQUEST)
        })
        friday_prayer_item.setOnClickListener(View.OnClickListener { view->
            startActivity(Intent(this,PrayerActivity::class.java))
        })
        funeral_prayer_item.setOnClickListener(View.OnClickListener { view->
            //startActivity(Intent(this,PrayerActivity::class.java))
            Toast.makeText(this,getString(R.string.no_data_found), Toast.LENGTH_LONG).show()
        })
        eid_prayer_item.setOnClickListener(View.OnClickListener { view->
            //startActivity(Intent(this,PrayerActivity::class.java))
            Toast.makeText(this,getString(R.string.no_data_found), Toast.LENGTH_LONG).show()

        })
        taraweeh_prayer_item.setOnClickListener(View.OnClickListener { view->
            //startActivity(Intent(this,PrayerActivity::class.java))
            Toast.makeText(this,getString(R.string.no_data_found), Toast.LENGTH_LONG).show()

        })

        about_item.setOnClickListener(View.OnClickListener { view->
            startActivity(Intent(this,AboutActivity::class.java))
        })


    }




    @SuppressLint("ApplySharedPref")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Check which request we're responding to
        if (requestCode == COUNTRY_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                val country = data!!.getStringExtra(Util.COUNTRY_EXTRA)
                val position = data.getIntExtra(Util.POSITION_COUNTRY_EXTRA, -1);
                if(!country.isNullOrEmpty()&& position != -1){
                    val shared_pref = getSharedPreferences(Util.SHARED_KEY, Context.MODE_PRIVATE)
                    val editor = shared_pref.edit()
                    editor.putString(Util.COUNTRY_SHARED_PREFERENCE, country)
                    editor.putInt(Util.POSITION_COUNTRY_EXTRA, position)
                    editor.commit()
                    editor.apply()
                    text_location.text =shared_pref.getString(Util.COUNTRY_SHARED_PREFERENCE, resources.getString(R.string.makka))
                }

            }
        }

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
