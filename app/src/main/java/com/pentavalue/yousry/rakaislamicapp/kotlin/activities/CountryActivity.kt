package com.pentavalue.yousry.rakaislamicapp.kotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.marcinorlowski.fonty.Fonty
import com.pentavalue.yousry.rakaislamicapp.R
import com.pentavalue.yousry.rakaislamicapp.java.adapters.CountryAdpater
import kotlinx.android.synthetic.main.activity_country.*

class CountryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)
        Fonty.setFonts(this)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)

        val adapter : CountryAdpater? = CountryAdpater(resources.getStringArray(R.array.countries).toList(),this)

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
