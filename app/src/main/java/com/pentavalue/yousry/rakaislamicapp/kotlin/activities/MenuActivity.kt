package com.pentavalue.yousry.rakaislamicapp.kotlin.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pentavalue.yousry.rakaislamicapp.R
import com.pentavalue.yousry.rakaislamicapp.Util.Util
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(my_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)
        country_item.setOnClickListener(View.OnClickListener { view->
            startActivity(Intent(this,CountryActivity::class.java))
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
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
