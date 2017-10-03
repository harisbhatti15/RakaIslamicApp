package com.pentavalue.yousry.rakaislamicapp.kotlin.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

import com.pentavalue.yousry.rakaislamicapp.R
import com.pentavalue.yousry.rakaislamicapp.java.models.Detail

/**
 * Created by yousry on 10/3/2017.
 */

class DetailViewHolder(internal var view: View) : RecyclerView.ViewHolder(view) {

    internal var titleView: TextView
    internal var bodyView: TextView

    init {
        this.titleView = view.findViewById(R.id.detailTitle)
        this.bodyView = view.findViewById(R.id.detailBody)

    }

    fun bind(detail: Detail) {
        titleView.text = detail.title
        bodyView.text = detail.details
    }
}
