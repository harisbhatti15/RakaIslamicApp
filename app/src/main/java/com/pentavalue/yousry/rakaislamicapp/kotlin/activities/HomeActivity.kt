package com.pentavalue.yousry.rakaislamicapp.kotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pentavalue.yousry.rakaislamicapp.R
import com.pentavalue.yousry.rakaislamicapp.java.adapters.PrayerAdapter
import com.pentavalue.yousry.rakaislamicapp.java.models.Prayer
import com.pentavalue.yousry.rakaislamicapp.java.models.Rakaat
import kotlinx.android.synthetic.main.activity_home.*
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import android.support.v7.widget.SnapHelper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.pentavalue.yousry.rakaislamicapp.java.adapters.DetailsAdapter
import com.pentavalue.yousry.rakaislamicapp.java.adapters.RakaatAdapter
import com.pentavalue.yousry.rakaislamicapp.java.models.Detail


class HomeActivity : AppCompatActivity() {


    var adapterRakaat : RakaatAdapter? = null
    private var prayers: List<Prayer>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(my_toolbar)
        prayers = getPrayers()

        val llm = LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false)

        llm.stackFromEnd =true

        val adapter = PrayerAdapter(this, prayers,
                PrayerAdapter.OnItemClickedListener { view, prayer ->
                    Toast.makeText(this, prayer.title, Toast.LENGTH_LONG).show()
                    adapterRakaat!!.rakaats =prayer.rakaat


        })
        recyclurPrayer.setLayoutManager(llm)
        recyclurPrayer.adapter =adapter


        val snapHelperStart = GravitySnapHelper(Gravity.START)
        snapHelperStart.attachToRecyclerView(recyclurPrayer)



        adapterRakaat = RakaatAdapter(prayers!!.get(0).rakaat, this,
                RakaatAdapter.OnItemClickedListener{view, rakaat, oldView ->
                    Toast.makeText(this,rakaat.title, Toast.LENGTH_LONG).show()


        })
        recyclurRakaat.setLayoutManager(LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false))

        recyclurRakaat.adapter =adapterRakaat


        val adapterDetails = DetailsAdapter(prayers!!.get(0).rakaat.get(0).details, this);
        recyclurDetails.setLayoutManager(LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, true))
        recyclurDetails.adapter =adapterDetails

    }


    fun getPrayers (): List<Prayer>{
        val prayers = ArrayList<Prayer>()
        val prayer1 =Prayer()
        prayer1.drawable =resources.getDrawable(R.drawable.card_bg_elfagr)
        prayer1.time ="4:30"
        prayer1.title =resources.getString(R.string.ElfgrPrayer)
        val prayer2 =Prayer()
        prayer2.drawable =resources.getDrawable(R.drawable.card_bg_eldoher)
        prayer2.time ="12:30"
        prayer2.title =resources.getString(R.string.ElTohrPrayer)
        val prayer3 =Prayer()
        prayer3.drawable =resources.getDrawable(R.drawable.card_bg_elasr)
        prayer3.time ="4:10"
        prayer3.title =resources.getString(R.string.ElAsrPrayer)
        val prayer4 =Prayer()
        prayer4.drawable =resources.getDrawable(R.drawable.card_bg_elmagrb)
        prayer4.time ="6:30"
        prayer4.title =resources.getString(R.string.ElMagrbPrayer)
        val prayer5 =Prayer()
        prayer5.drawable =resources.getDrawable(R.drawable.card_bg_elhasha)
        prayer5.time ="8:30"
        prayer5.title =resources.getString(R.string.ElHashaPrayer)


        val details1 = Detail(resources.getString(R.string.detailHanfi),resources.getString(R.string.detailBody))
        val details2 = Detail(resources.getString(R.string.detailMalki),resources.getString(R.string.detailBody))
        val details3 = Detail(resources.getString(R.string.detailShaf3y),resources.getString(R.string.detailBody))
        // el dohr
        val rakaat1 =Rakaat()
        rakaat1.details.add(details1)
        rakaat1.details.add(details2)
        rakaat1.details.add(details3)
        rakaat1.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaat1.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)

        rakaat1.title ="الركعة 1";
        prayer2.rakaat.add(rakaat1)
        val rakaat2 =Rakaat()
        rakaat2.details.add(details1)
        rakaat2.details.add(details2)
        rakaat2.details.add(details3)
        rakaat2.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaat2.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)
        rakaat2.title ="الركعة 2";
        prayer2.rakaat.add(rakaat2)
        val rakaat3 =Rakaat()
        rakaat3.details.add(details1)
        rakaat3.details.add(details2)
        rakaat3.details.add(details3)
        rakaat3.drawable = resources.getDrawable(R.drawable.icon_tashahod)
        rakaat3.selectedDrawable = resources.getDrawable(R.drawable.icon_tashahod_selected)
        rakaat3.title ="التشهد";
        prayer2.rakaat.add(rakaat3)
        val rakaat4 =Rakaat()
        rakaat4.details.add(details1)
        rakaat4.details.add(details2)
        rakaat4.details.add(details3)
        rakaat4.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaat4.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)
        rakaat4.title ="الركعة 3";
        prayer2.rakaat.add(rakaat4)
        val rakaat5 =Rakaat()
        rakaat5.details.add(details1)
        rakaat5.details.add(details2)
        rakaat5.details.add(details3)
        rakaat5.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaat5.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)
        rakaat5.title ="الركعة 4";
        prayer2.rakaat.add(rakaat5)
        val rakaat6 =Rakaat()
        rakaat6.details.add(details1)
        rakaat6.details.add(details2)
        rakaat6.details.add(details3)
        rakaat6.drawable = resources.getDrawable(R.drawable.icon_tashahod)
        rakaat6.selectedDrawable = resources.getDrawable(R.drawable.icon_tashahod_selected)
        rakaat6.title ="التشهد";
        prayer2.rakaat.add(rakaat6)



        // el 3sr
        val rakaatEl3sr1 =Rakaat()
        rakaatEl3sr1.details.add(details1)
        rakaatEl3sr1.details.add(details2)
        rakaatEl3sr1.details.add(details3)
        rakaatEl3sr1.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaatEl3sr1.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)

        rakaatEl3sr1.title ="الركعة 1";
        prayer3.rakaat.add(rakaatEl3sr1)
        val rakaatEl3sr2 =Rakaat()
        rakaatEl3sr2.details.add(details1)
        rakaatEl3sr2.details.add(details2)
        rakaatEl3sr2.details.add(details3)
        rakaatEl3sr2.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaatEl3sr2.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)

        rakaatEl3sr2.title ="الركعة 2";
        prayer3.rakaat.add(rakaatEl3sr2)
        val rakaatEl3sr3 =Rakaat()
        rakaatEl3sr3.details.add(details1)
        rakaatEl3sr3.details.add(details2)
        rakaatEl3sr3.details.add(details3)
        rakaatEl3sr3.drawable = resources.getDrawable(R.drawable.icon_tashahod)
        rakaatEl3sr3.selectedDrawable = resources.getDrawable(R.drawable.icon_tashahod_selected)

        rakaatEl3sr3.title ="التشهد";
        prayer3.rakaat.add(rakaatEl3sr3)
        val rakaatEl3sr4 =Rakaat()
        rakaatEl3sr4.details.add(details1)
        rakaatEl3sr4.details.add(details2)
        rakaatEl3sr4.details.add(details3)
        rakaatEl3sr4.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaatEl3sr4.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)

        rakaatEl3sr4.title ="الركعة 3";
        prayer3.rakaat.add(rakaatEl3sr4)
        val rakaatEl3sr5 =Rakaat()
        rakaatEl3sr5.details.add(details1)
        rakaatEl3sr5.details.add(details2)
        rakaatEl3sr5.details.add(details3)
        rakaatEl3sr5.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaatEl3sr5.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)

        rakaatEl3sr5.title ="الركعة 4";
        prayer3.rakaat.add(rakaatEl3sr5)
        val rakaatEl3sr6 =Rakaat()
        rakaatEl3sr6.details.add(details1)
        rakaatEl3sr6.details.add(details2)
        rakaatEl3sr6.details.add(details3)
        rakaatEl3sr6.drawable = resources.getDrawable(R.drawable.icon_tashahod)
        rakaatEl3sr6.selectedDrawable = resources.getDrawable(R.drawable.icon_tashahod_selected)

        rakaatEl3sr6.title ="التشهد";
        prayer3.rakaat.add(rakaatEl3sr6)


        // el m8rb
        val rakaatm8rb1 =Rakaat()
        rakaatm8rb1.details.add(details1)
        rakaatm8rb1.details.add(details2)
        rakaatm8rb1.details.add(details3)
        rakaatm8rb1.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaatm8rb1.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)

        rakaatm8rb1.title ="الركعة 1";
        prayer4.rakaat.add(rakaatm8rb1)
        val rakaatm8rb2 =Rakaat()
        rakaatm8rb2.details.add(details1)
        rakaatm8rb2.details.add(details2)
        rakaatm8rb2.details.add(details3)
        rakaatm8rb2.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaatm8rb2.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)

        rakaatm8rb2.title ="الركعة 2";
        prayer4.rakaat.add(rakaatm8rb2)
        val rakaatm8rb3 =Rakaat()
        rakaatm8rb3.details.add(details1)
        rakaatm8rb3.details.add(details2)
        rakaatm8rb3.details.add(details3)
        rakaatm8rb3.drawable = resources.getDrawable(R.drawable.icon_tashahod)
        rakaatm8rb3.selectedDrawable = resources.getDrawable(R.drawable.icon_tashahod_selected)

        rakaatm8rb3.title ="التشهد";
        prayer4.rakaat.add(rakaatm8rb3)
        val rakaatm8rb4 =Rakaat()
        rakaatm8rb4.details.add(details1)
        rakaatm8rb4.details.add(details2)
        rakaatm8rb4.details.add(details3)
        rakaatm8rb4.drawable = resources.getDrawable(R.drawable.icon_tashahod)
        rakaatm8rb4.selectedDrawable = resources.getDrawable(R.drawable.icon_tashahod_selected)

        rakaatm8rb4.title ="التشهد";
        prayer4.rakaat.add(rakaatm8rb4)


        //
        //el 3asha2
        val rakaat3asha21 =Rakaat()
        rakaat3asha21.details.add(details1)
        rakaat3asha21.details.add(details2)
        rakaat3asha21.details.add(details3)
        rakaat3asha21.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaat3asha21.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)

        rakaat3asha21.title ="الركعة 1";
        prayer5.rakaat.add(rakaat3asha21)
        val rakaat3asha22 =Rakaat()
        rakaat3asha22.details.add(details1)
        rakaat3asha22.details.add(details2)
        rakaat3asha22.details.add(details3)
        rakaat3asha22.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaat3asha22.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)

        rakaat3asha22.title ="الركعة 2";
        prayer5.rakaat.add(rakaat3asha22)
        val rakaat3asha23 =Rakaat()
        rakaat3asha23.details.add(details1)
        rakaat3asha23.details.add(details2)
        rakaat3asha23.details.add(details3)
        rakaat3asha23.drawable = resources.getDrawable(R.drawable.icon_tashahod)
        rakaat3asha23.selectedDrawable = resources.getDrawable(R.drawable.icon_tashahod_selected)

        rakaat3asha23.title ="التشهد";
        prayer5.rakaat.add(rakaat3asha23)
        val rakaat3asha24 =Rakaat()
        rakaat3asha24.details.add(details1)
        rakaat3asha24.details.add(details2)
        rakaat3asha24.details.add(details3)
        rakaat3asha24.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaat3asha24.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)

        rakaat3asha24.title ="الركعة 3";
        prayer5.rakaat.add(rakaat3asha24)
        val rakaat3asha25 =Rakaat()
        rakaat3asha25.details.add(details1)
        rakaat3asha25.details.add(details2)
        rakaat3asha25.details.add(details3)
        rakaat3asha25.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaat3asha25.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)

        rakaat3asha25.title ="الركعة 4";
        prayer5.rakaat.add(rakaat3asha25)
        val rakaat3asha26 =Rakaat()
        rakaat3asha26.details.add(details1)
        rakaat3asha26.details.add(details2)
        rakaat3asha26.details.add(details3)
        rakaat3asha26.drawable = resources.getDrawable(R.drawable.icon_tashahod)
        rakaat3asha26.selectedDrawable = resources.getDrawable(R.drawable.icon_tashahod_selected)

        rakaat3asha26.title ="التشهد";
        prayer5.rakaat.add(rakaat3asha26)

        // el fgr
        val rakaatfgr1 =Rakaat()
        rakaatfgr1.details.add(details1)
        rakaatfgr1.details.add(details2)
        rakaatfgr1.details.add(details3)
        rakaatfgr1.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaatfgr1.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)

        rakaatfgr1.title ="الركعة 1";
        prayer1.rakaat.add(rakaatfgr1)
        val rakaatfgr2 =Rakaat()
        rakaatfgr2.details.add(details1)
        rakaatfgr2.details.add(details2)
        rakaatfgr2.details.add(details3)
        rakaatfgr2.drawable = resources.getDrawable(R.drawable.icon_rakaa)
        rakaatfgr2.selectedDrawable = resources.getDrawable(R.drawable.icon_rakaa_selected)
        rakaatfgr2.title ="الركعة 2";
        prayer1.rakaat.add(rakaatfgr2)
        val rakaatfgr3 =Rakaat()
        rakaatfgr3.details.add(details1)
        rakaatfgr3.details.add(details2)
        rakaatfgr3.details.add(details3)
        rakaatfgr3.drawable = resources.getDrawable(R.drawable.icon_tashahod)
        rakaatfgr3.selectedDrawable = resources.getDrawable(R.drawable.icon_tashahod_selected)

        rakaatfgr3.title ="التشهد";
        prayer1.rakaat.add(rakaatfgr3)



        prayers.add(prayer1)
        prayers.add(prayer2)
        prayers.add(prayer3)
        prayers.add(prayer4)
        prayers.add(prayer5)


        return prayers
    }

}
