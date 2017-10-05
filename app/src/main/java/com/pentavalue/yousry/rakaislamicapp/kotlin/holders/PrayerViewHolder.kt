package com.pentavalue.yousry.rakaislamicapp.kotlin.holders

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.pentavalue.yousry.rakaislamicapp.R
import com.pentavalue.yousry.rakaislamicapp.java.models.Prayer



/**
 * Created by yousry on 10/2/2017.
 */

class PrayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    public var cardView: CardView
    internal var nameView: TextView
    internal var timeView: TextView
    internal var root: RelativeLayout
    public var container :LinearLayout

    init {
        cardView = itemView.findViewById(R.id.card_view_item)
        root = itemView.findViewById(R.id.list_container_bg)
        nameView = itemView.findViewById(R.id.nameView)
        timeView = itemView.findViewById(R.id.timeView)
        container = itemView.findViewById(R.id.container)
    }
    fun bind(prayer: Prayer, context: Context) {
        nameView.text = prayer.title
        timeView.text = prayer.time
        root.setBackgroundDrawable(prayer.drawable)


    }
}
