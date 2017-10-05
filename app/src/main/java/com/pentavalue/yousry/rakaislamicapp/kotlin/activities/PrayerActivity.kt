package com.pentavalue.yousry.rakaislamicapp.kotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.marcinorlowski.fonty.Fonty
import com.pentavalue.yousry.rakaislamicapp.R
import com.pentavalue.yousry.rakaislamicapp.java.adapters.DetailsAdapter
import com.pentavalue.yousry.rakaislamicapp.java.adapters.RakaatAdapter
import com.pentavalue.yousry.rakaislamicapp.java.models.Detail
import com.pentavalue.yousry.rakaislamicapp.java.models.Prayer
import com.pentavalue.yousry.rakaislamicapp.java.models.Rakaat
import kotlinx.android.synthetic.main.activity_prayer.*

class PrayerActivity : AppCompatActivity() {

    var adapterRakaat : RakaatAdapter? = null
    private var prayer: Prayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prayer)
        Fonty.setFonts(this)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)

        prayer =getPrayer()


        adapterRakaat = RakaatAdapter(prayer!!.rakaat, this,
                RakaatAdapter.OnItemClickedListener{view, rakaat, oldView ->
                    Toast.makeText(this,rakaat.title, Toast.LENGTH_LONG).show()

                    val adapter = DetailsAdapter(rakaat.details, this);
                    recyclurDetails.setLayoutManager(LinearLayoutManager(this,
                            LinearLayoutManager.VERTICAL, true))
                    recyclurDetails.adapter =adapter
                })
        recyclurRakaat.setLayoutManager(LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false))

        recyclurRakaat.adapter =adapterRakaat


        val adapterDetails = DetailsAdapter(prayer!!.rakaat.get(0).details, this);
        recyclurDetails.setLayoutManager(LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, true))
        recyclurDetails.adapter =adapterDetails
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun getPrayer(): Prayer{
        val prayer =Prayer()
        prayer.drawable =resources.getDrawable(R.drawable.card_bg_eldoher)
        prayer.time ="12:30"
        prayer.title =resources.getString(R.string.Gom3aPrayer)

        val details1 = Detail(resources.getString(R.string.detailHanfi),resources.getString(R.string.detailBody))
        val details2 = Detail(resources.getString(R.string.detailMalki),resources.getString(R.string.detailBody))
        val details3 = Detail(resources.getString(R.string.detailShaf3y),resources.getString(R.string.detailBody))

        // el fgr
        val rakaatfgr1 = Rakaat()
        rakaatfgr1.details.add(details1)
        rakaatfgr1.details.add(details2)
        rakaatfgr1.details.add(details3)
        rakaatfgr1.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaatfgr1.selectedDrawable = resources.getDrawable(R.drawable.raka_color)
        rakaatfgr1.title =resources.getString(R.string.raka_name) +"1"
        prayer.rakaat.add(rakaatfgr1)

        val rakaatfgr2 = Rakaat()
        rakaatfgr2.details.add(details2)
        rakaatfgr2.details.add(details3)
        rakaatfgr2.details.add(details1)
        rakaatfgr2.details.add(details3)
        rakaatfgr2.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaatfgr2.selectedDrawable = resources.getDrawable(R.drawable.raka_color)
        rakaatfgr2.title =resources.getString(R.string.raka_name) +"2"
        prayer.rakaat.add(rakaatfgr2)

        val rakaatfgr3 = Rakaat()
        rakaatfgr3.details.add(details1)
        rakaatfgr3.details.add(details2)
        rakaatfgr3.details.add(details3)
        rakaatfgr3.details.add(details1)
        rakaatfgr3.details.add(details2)
        rakaatfgr3.details.add(details3)
        rakaatfgr3.drawable = resources.getDrawable(R.drawable.tashud_black)
        rakaatfgr3.selectedDrawable = resources.getDrawable(R.drawable.tashud_color)

        rakaatfgr3.title =resources.getString(R.string.tashud_name)
        prayer.rakaat.add(rakaatfgr3)

        return prayer
    }
}
