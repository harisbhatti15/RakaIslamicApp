package com.pentavalue.yousry.rakaislamicapp.java.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.pentavalue.yousry.rakaislamicapp.R;
import com.pentavalue.yousry.rakaislamicapp.kotlin.holders.CountryViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yousry on 9/26/2017.
 */

public class CountryAdpater extends RecyclerView.Adapter<CountryViewHolder> {

    List<String> countries;
    List<CountryViewHolder> holderList;
    Context context;

    static CountryViewHolder lastViewHolder;
    static int lastPosition;
    static String selectedItem;

    public CountryAdpater(List<String> countries, Context context) {
        this.context = context;
        this.countries = countries;
        holderList =new ArrayList<>();
        lastPosition =0;
        selectedItem =countries.get(0);
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_countries_menu_list, parent,false);
        CountryViewHolder  countryViewHolder=new CountryViewHolder(view);

        return countryViewHolder;
    }

    @Override
    public void onBindViewHolder(final CountryViewHolder holder, final int position) {
        final String item = countries.get(position);
        holder.bind(item, context);

        holderList.add(holder);
        //lastViewHolder.photo.setVisibility(View.VISIBLE);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show();
                //lastViewHolder.photo.setVisibility(View.INVISIBLE);
                //holder.photo.setVisibility(View.VISIBLE);
                holderList.get(lastPosition).photo.setVisibility(View.INVISIBLE);
                lastPosition = position;
                holderList.get(lastPosition).photo.setVisibility(View.VISIBLE);
                selectedItem =countries.get(lastPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.countries.size();
    }

}
