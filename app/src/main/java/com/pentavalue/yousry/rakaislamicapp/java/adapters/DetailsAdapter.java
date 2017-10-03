package com.pentavalue.yousry.rakaislamicapp.java.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pentavalue.yousry.rakaislamicapp.R;
import com.pentavalue.yousry.rakaislamicapp.java.models.Prayer;
import com.pentavalue.yousry.rakaislamicapp.kotlin.holders.DetailViewHolder;
import com.pentavalue.yousry.rakaislamicapp.java.models.Detail;

import java.util.List;

/**
 * Created by yousry on 10/3/2017.
 */

public class DetailsAdapter extends RecyclerView.Adapter<DetailViewHolder> {
    List<Detail> details ;
    Context context;

    public DetailsAdapter(List<Detail> details, Context context) {
        this.details = details;
        this.context = context;
        new PrayerAdapter(null,null,new PrayerAdapter.OnItemClickedListener(){
            @Override
            public void onItemClicked(View view, Prayer prayer) {

            }
        });
    }

    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details_home,parent,false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, int position) {
        holder.bind(details.get(position));
    }

    @Override
    public int getItemCount() {
        return details.size();
    }
}
