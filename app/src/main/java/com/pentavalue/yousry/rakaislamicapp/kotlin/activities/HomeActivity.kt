package com.pentavalue.yousry.rakaislamicapp.kotlin.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import com.marcinorlowski.fonty.Fonty
import com.pentavalue.yousry.rakaislamicapp.R
import com.pentavalue.yousry.rakaislamicapp.Util.Util
import com.pentavalue.yousry.rakaislamicapp.java.adapters.DetailsAdapter
import com.pentavalue.yousry.rakaislamicapp.java.adapters.PrayerAdapter
import com.pentavalue.yousry.rakaislamicapp.java.adapters.RakaatAdapter
import com.pentavalue.yousry.rakaislamicapp.java.dialogs.CustomDialog
import com.pentavalue.yousry.rakaislamicapp.java.models.Detail
import com.pentavalue.yousry.rakaislamicapp.java.models.Prayer
import com.pentavalue.yousry.rakaislamicapp.java.models.Rakaat
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {
    var adapterRakaat: RakaatAdapter? = null
    private var prayers: List<Prayer>? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Fonty.setFonts(this);
        setSupportActionBar(my_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)
        prayers = getPrayers()
        val sharedPref: SharedPreferences = getSharedPreferences(Util.SHARED_KEY, Context.MODE_PRIVATE)

        if (!sharedPref!!.getBoolean(Util.CHECK_LOACTION, false)) {
            // Shared Pref contain False Value for loaction
            val dialog = CustomDialog(this)
            Log.v("tag", "shared is false")
            dialog.show()
        } else {
            // Close Dialog
            if (intent.hasExtra("location")) {
                if (!intent.getBooleanExtra("location", false)) {
                    val dialog = CustomDialog(this)
                    Log.v("tag", "intent is false")
                    dialog.show()
                }
            }
            country_prayers_view.text = getString(R.string.text_view_home_city) + " " + sharedPref.getString(Util.COUNTRY_SHARED_PREFERENCE, resources.getString(R.string.makka))
        }


        bindView()

    }


    override fun onSupportNavigateUp(): Boolean {
        startActivity(Intent(this, MenuActivity::class.java))
        return true
    }


    fun bindView() {


        title = resources.getString(R.string.five_prayers_toolbar)


        // Configure the refreshing colors
        /*swipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        swipeLayout.setOnRefreshListener {
            drawRecyclurViewPrayers()
            swipeLayout.isRefreshing = false
        }*/

        drawRecyclurViewPrayers()


        //recyclurPrayer.setOnFlingListener(snapHelperStart)
        adapterRakaat = RakaatAdapter(prayers!!.get(0).rakaat, this,
                RakaatAdapter.OnItemClickedListener { view, rakaat, oldView ->
                    Toast.makeText(this, rakaat.title, Toast.LENGTH_LONG).show()
                    val adapterDetails = DetailsAdapter(rakaat.details, this);
                    recyclurDetails.setLayoutManager(LinearLayoutManager(this,
                            LinearLayoutManager.VERTICAL, true))
                    recyclurDetails.adapter = adapterDetails

                })
        recyclurRakaat.setLayoutManager(LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false))

        recyclurRakaat.adapter = adapterRakaat


        val adapterDetails = DetailsAdapter(prayers!!.get(0).rakaat.get(0).details, this);
        recyclurDetails.setLayoutManager(LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, true))
        recyclurDetails.adapter = adapterDetails
    }


    fun getPrayers(): List<Prayer> {
        val prayers = ArrayList<Prayer>()
        val prayer1 = Prayer()
        prayer1.color = R.color.Onyx;
        prayer1.drawable = resources.getDrawable(R.drawable.card_bg_elfagr)
        prayer1.time = "4:30"
        prayer1.title = resources.getString(R.string.ElfgrPrayer)
        val prayer2 = Prayer()
        prayer2.color = R.color.PersianPlum
        prayer2.drawable = resources.getDrawable(R.drawable.card_bg_eldoher)
        prayer2.time = "12:30"
        prayer2.title = resources.getString(R.string.ElTohrPrayer)
        val prayer3 = Prayer()
        prayer3.color = R.color.Teal_blue
        prayer3.drawable = resources.getDrawable(R.drawable.card_bg_elasr)
        prayer3.time = "4:10"
        prayer3.title = resources.getString(R.string.ElAsrPrayer)
        val prayer4 = Prayer()
        prayer4.color = R.color.SealBrown
        prayer4.drawable = resources.getDrawable(R.drawable.card_bg_elmagrb)
        prayer4.time = "6:30"
        prayer4.title = resources.getString(R.string.ElMagrbPrayer)
        val prayer5 = Prayer()
        prayer5.color = R.color.MediumJungleGreen
        prayer5.drawable = resources.getDrawable(R.drawable.card_bg_elhasha)
        prayer5.time = "8:30"
        prayer5.title = resources.getString(R.string.ElHashaPrayer)


        val details1 = Detail(resources.getString(R.string.detailHanfi), resources.getString(R.string.detailBody))
        val details2 = Detail(resources.getString(R.string.detailMalki), resources.getString(R.string.detailBody))
        val details3 = Detail(resources.getString(R.string.detailShaf3y), resources.getString(R.string.detailBody))
        // el dohr
        val rakaat1 = Rakaat()
        rakaat1.details.add(details1)
        rakaat1.details.add(details2)
        rakaat1.details.add(details3)
        rakaat1.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaat1.selectedDrawable = resources.getDrawable(R.drawable.raka_color)

        rakaat1.title = resources.getString(R.string.raka_name) + "1"
        prayer2.rakaat.add(rakaat1)
        val rakaat2 = Rakaat()
        rakaat2.details.add(details1)
        rakaat2.details.add(details2)
        rakaat2.details.add(details3)
        rakaat2.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaat2.selectedDrawable = resources.getDrawable(R.drawable.raka_color)
        rakaat2.title = resources.getString(R.string.raka_name) + "2"
        prayer2.rakaat.add(rakaat2)
        val rakaat3 = Rakaat()
        rakaat3.details.add(details1)
        rakaat3.details.add(details2)
        rakaat3.details.add(details3)
        rakaat3.drawable = resources.getDrawable(R.drawable.tashud_black)
        rakaat3.selectedDrawable = resources.getDrawable(R.drawable.tashud_color)
        rakaat3.title = resources.getString(R.string.tashud_name)
        prayer2.rakaat.add(rakaat3)
        val rakaat4 = Rakaat()
        rakaat4.details.add(details1)
        rakaat4.details.add(details2)
        rakaat4.details.add(details3)
        rakaat4.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaat4.selectedDrawable = resources.getDrawable(R.drawable.raka_color)
        rakaat4.title = resources.getString(R.string.raka_name) + "3"
        prayer2.rakaat.add(rakaat4)
        val rakaat5 = Rakaat()
        rakaat5.details.add(details1)
        rakaat5.details.add(details2)
        rakaat5.details.add(details3)
        rakaat5.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaat5.selectedDrawable = resources.getDrawable(R.drawable.raka_color)
        rakaat5.title = resources.getString(R.string.raka_name) + "4"
        prayer2.rakaat.add(rakaat5)
        val rakaat6 = Rakaat()
        rakaat6.details.add(details1)
        rakaat6.details.add(details2)
        rakaat6.details.add(details3)
        rakaat6.drawable = resources.getDrawable(R.drawable.tashud_black)
        rakaat6.selectedDrawable = resources.getDrawable(R.drawable.tashud_color)
        rakaat6.title = resources.getString(R.string.tashud_name)
        prayer2.rakaat.add(rakaat6)


        // el 3sr
        val rakaatEl3sr1 = Rakaat()
        rakaatEl3sr1.details.add(details1)
        rakaatEl3sr1.details.add(details2)
        rakaatEl3sr1.details.add(details3)
        rakaatEl3sr1.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaatEl3sr1.selectedDrawable = resources.getDrawable(R.drawable.raka_color)

        rakaatEl3sr1.title = resources.getString(R.string.raka_name) + "1"
        prayer3.rakaat.add(rakaatEl3sr1)
        val rakaatEl3sr2 = Rakaat()
        rakaatEl3sr2.details.add(details1)
        rakaatEl3sr2.details.add(details2)
        rakaatEl3sr2.details.add(details3)
        rakaatEl3sr2.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaatEl3sr2.selectedDrawable = resources.getDrawable(R.drawable.raka_color)

        rakaatEl3sr2.title = resources.getString(R.string.raka_name) + "2"
        prayer3.rakaat.add(rakaatEl3sr2)
        val rakaatEl3sr3 = Rakaat()
        rakaatEl3sr3.details.add(details1)
        rakaatEl3sr3.details.add(details2)
        rakaatEl3sr3.details.add(details3)
        rakaatEl3sr3.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaatEl3sr3.selectedDrawable = resources.getDrawable(R.drawable.raka_color)

        rakaatEl3sr3.title = resources.getString(R.string.tashud_name)
        prayer3.rakaat.add(rakaatEl3sr3)
        val rakaatEl3sr4 = Rakaat()
        rakaatEl3sr4.details.add(details1)
        rakaatEl3sr4.details.add(details2)
        rakaatEl3sr4.details.add(details3)
        rakaatEl3sr4.drawable = resources.getDrawable(R.drawable.tashud_black)
        rakaatEl3sr4.selectedDrawable = resources.getDrawable(R.drawable.tashud_color)

        rakaatEl3sr4.title = resources.getString(R.string.raka_name) + "3"
        prayer3.rakaat.add(rakaatEl3sr4)
        val rakaatEl3sr5 = Rakaat()
        rakaatEl3sr5.details.add(details1)
        rakaatEl3sr5.details.add(details2)
        rakaatEl3sr5.details.add(details3)
        rakaatEl3sr5.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaatEl3sr5.selectedDrawable = resources.getDrawable(R.drawable.raka_color)

        rakaatEl3sr5.title = resources.getString(R.string.raka_name) + "4"
        prayer3.rakaat.add(rakaatEl3sr5)
        val rakaatEl3sr6 = Rakaat()
        rakaatEl3sr6.details.add(details1)
        rakaatEl3sr6.details.add(details2)
        rakaatEl3sr6.details.add(details3)
        rakaatEl3sr6.drawable = resources.getDrawable(R.drawable.tashud_black)
        rakaatEl3sr6.selectedDrawable = resources.getDrawable(R.drawable.tashud_color)

        rakaatEl3sr6.title = resources.getString(R.string.tashud_name)
        prayer3.rakaat.add(rakaatEl3sr6)


        // el m8rb
        val rakaatm8rb1 = Rakaat()
        rakaatm8rb1.details.add(details1)
        rakaatm8rb1.details.add(details2)
        rakaatm8rb1.details.add(details3)
        rakaatm8rb1.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaatm8rb1.selectedDrawable = resources.getDrawable(R.drawable.raka_color)

        rakaatm8rb1.title = resources.getString(R.string.raka_name) + "1"
        prayer4.rakaat.add(rakaatm8rb1)
        val rakaatm8rb2 = Rakaat()
        rakaatm8rb2.details.add(details1)
        rakaatm8rb2.details.add(details2)
        rakaatm8rb2.details.add(details3)
        rakaatm8rb2.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaatm8rb2.selectedDrawable = resources.getDrawable(R.drawable.raka_color)

        rakaatm8rb2.title = resources.getString(R.string.raka_name) + "2"
        prayer4.rakaat.add(rakaatm8rb2)
        val rakaatm8rb3 = Rakaat()
        rakaatm8rb3.details.add(details1)
        rakaatm8rb3.details.add(details2)
        rakaatm8rb3.details.add(details3)
        rakaatm8rb3.drawable = resources.getDrawable(R.drawable.tashud_black)
        rakaatm8rb3.selectedDrawable = resources.getDrawable(R.drawable.tashud_color)

        rakaatm8rb3.title = resources.getString(R.string.tashud_name)
        prayer4.rakaat.add(rakaatm8rb3)
        val rakaatm8rb4 = Rakaat()
        rakaatm8rb4.details.add(details1)
        rakaatm8rb4.details.add(details2)
        rakaatm8rb4.details.add(details3)
        rakaatm8rb4.drawable = resources.getDrawable(R.drawable.tashud_black)
        rakaatm8rb4.selectedDrawable = resources.getDrawable(R.drawable.tashud_color)

        rakaatm8rb4.title = resources.getString(R.string.tashud_name)
        prayer4.rakaat.add(rakaatm8rb4)


        //
        //el 3asha2
        val rakaat3asha21 = Rakaat()
        rakaat3asha21.details.add(details1)
        rakaat3asha21.details.add(details2)
        rakaat3asha21.details.add(details3)
        rakaat3asha21.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaat3asha21.selectedDrawable = resources.getDrawable(R.drawable.raka_color)

        rakaat3asha21.title = resources.getString(R.string.raka_name) + "1"
        prayer5.rakaat.add(rakaat3asha21)
        val rakaat3asha22 = Rakaat()
        rakaat3asha22.details.add(details1)
        rakaat3asha22.details.add(details2)
        rakaat3asha22.details.add(details3)
        rakaat3asha22.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaat3asha22.selectedDrawable = resources.getDrawable(R.drawable.raka_color)

        rakaat3asha22.title = resources.getString(R.string.raka_name) + "2"
        prayer5.rakaat.add(rakaat3asha22)
        val rakaat3asha23 = Rakaat()
        rakaat3asha23.details.add(details1)
        rakaat3asha23.details.add(details2)
        rakaat3asha23.details.add(details3)
        rakaat3asha23.drawable = resources.getDrawable(R.drawable.tashud_black)
        rakaat3asha23.selectedDrawable = resources.getDrawable(R.drawable.tashud_color)

        rakaat3asha23.title = resources.getString(R.string.tashud_name)
        prayer5.rakaat.add(rakaat3asha23)
        val rakaat3asha24 = Rakaat()
        rakaat3asha24.details.add(details1)
        rakaat3asha24.details.add(details2)
        rakaat3asha24.details.add(details3)
        rakaat3asha24.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaat3asha24.selectedDrawable = resources.getDrawable(R.drawable.raka_color)

        rakaat3asha24.title = resources.getString(R.string.raka_name) + "3"
        prayer5.rakaat.add(rakaat3asha24)
        val rakaat3asha25 = Rakaat()
        rakaat3asha25.details.add(details1)
        rakaat3asha25.details.add(details2)
        rakaat3asha25.details.add(details3)
        rakaat3asha25.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaat3asha25.selectedDrawable = resources.getDrawable(R.drawable.raka_color)

        rakaat3asha25.title = resources.getString(R.string.raka_name) + "4"
        prayer5.rakaat.add(rakaat3asha25)
        val rakaat3asha26 = Rakaat()
        rakaat3asha26.details.add(details1)
        rakaat3asha26.details.add(details2)
        rakaat3asha26.details.add(details3)
        rakaat3asha26.drawable = resources.getDrawable(R.drawable.tashud_black)
        rakaat3asha26.selectedDrawable = resources.getDrawable(R.drawable.tashud_color)

        rakaat3asha26.title = resources.getString(R.string.tashud_name)
        prayer5.rakaat.add(rakaat3asha26)

        // el fgr
        val rakaatfgr1 = Rakaat()
        rakaatfgr1.details.add(details1)
        rakaatfgr1.details.add(details2)
        rakaatfgr1.details.add(details3)
        rakaatfgr1.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaatfgr1.selectedDrawable = resources.getDrawable(R.drawable.raka_color)

        rakaatfgr1.title = resources.getString(R.string.raka_name) + "1"
        prayer1.rakaat.add(rakaatfgr1)
        val rakaatfgr2 = Rakaat()
        rakaatfgr2.details.add(details1)
        rakaatfgr2.details.add(details2)
        rakaatfgr2.details.add(details3)
        rakaatfgr2.details.add(details1)
        rakaatfgr2.details.add(details2)
        rakaatfgr2.details.add(details3)
        rakaatfgr2.drawable = resources.getDrawable(R.drawable.raka_black)
        rakaatfgr2.selectedDrawable = resources.getDrawable(R.drawable.raka_color)
        rakaatfgr2.title = resources.getString(R.string.raka_name) + "2"
        prayer1.rakaat.add(rakaatfgr2)
        val rakaatfgr3 = Rakaat()
        rakaatfgr3.details.add(details1)
        rakaatfgr3.details.add(details2)
        rakaatfgr3.details.add(details3)
        rakaatfgr3.drawable = resources.getDrawable(R.drawable.tashud_black)
        rakaatfgr3.selectedDrawable = resources.getDrawable(R.drawable.tashud_color)

        rakaatfgr3.title = resources.getString(R.string.tashud_name)
        prayer1.rakaat.add(rakaatfgr3)



        prayers.add(prayer1)
        prayers.add(prayer2)
        prayers.add(prayer3)
        prayers.add(prayer4)
        prayers.add(prayer5)


        return prayers
    }

    fun drawRecyclurViewPrayers() {

        val llm = LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false)

        llm.stackFromEnd = false
        val adapter = PrayerAdapter(this, prayers,
                PrayerAdapter.OnItemClickedListener { view, prayer, position ->
                    Toast.makeText(this, prayer.title, Toast.LENGTH_LONG).show()
                    //adapterRakaat!!.rakaats.clear()
                    adapterRakaat = RakaatAdapter(prayer.rakaat, this,
                            RakaatAdapter.OnItemClickedListener { view, rakaat, oldView ->
                                Toast.makeText(this, rakaat.title, Toast.LENGTH_LONG).show()

                            })
                    recyclurPrayer.scrollToPosition(position)
                    recyclurRakaat.adapter = adapterRakaat

                })
        recyclurPrayer.setLayoutManager(llm)

        val snapHelperStart = GravitySnapHelper(Gravity.START)
        snapHelperStart.attachToRecyclerView(recyclurPrayer)
        recyclurPrayer.adapter = adapter
    }


}
