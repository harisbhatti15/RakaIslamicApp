package com.pentavalue.yousry.rakaislamicapp.kotlin.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.pentavalue.yousry.rakaislamicapp.R
import com.pentavalue.yousry.rakaislamicapp.java.models.Rakaat

/**
 * Created by yousry on 10/3/2017.
 */

class RakaaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    public var view: View? = null
    public var imageView: ImageView
    public var title: TextView
    public var indicator : View

    init {
        imageView = itemView.findViewById(R.id.image)
        title = itemView.findViewById(R.id.title)
        indicator =itemView.findViewById(R.id.indicatorView)

    }

    fun bind(rakaat: Rakaat) {
        imageView.setImageDrawable(rakaat.drawable)
        title.text = rakaat.title
    }
}
