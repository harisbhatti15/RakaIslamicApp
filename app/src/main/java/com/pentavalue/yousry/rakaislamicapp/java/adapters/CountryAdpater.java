package com.pentavalue.yousry.rakaislamicapp.java.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.marcinorlowski.fonty.Fonty;
import com.pentavalue.yousry.rakaislamicapp.R;
import com.pentavalue.yousry.rakaislamicapp.kotlin.holders.CountryViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yousry on 9/26/2017.
 */

public class CountryAdpater extends RecyclerView.Adapter<CountryViewHolder> {

    static CountryViewHolder lastViewHolder;
    static int lastPosition;
    static String selectedItem;
    List<String> countries;
    List<CountryViewHolder> holderList;
    Context context;
    private OnItemClickedListener listener;

    public CountryAdpater(List<String> countries, Context context, String country, int position, OnItemClickedListener listener) {
        this.context = context;
        this.countries = countries;
        holderList = new ArrayList<>();
        this.listener = listener;

        if (!country.isEmpty() && position > -1) {
            lastPosition = position;
            selectedItem = country;
        } else {
            lastPosition = 0;
            selectedItem = countries.get(0);
        }


    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_countries_menu_list, parent, false);
        CountryViewHolder countryViewHolder = new CountryViewHolder(view);
        Fonty.setFonts((ViewGroup) view);
        return countryViewHolder;
    }

    @Override
    public void onBindViewHolder(final CountryViewHolder holder, final int position) {
        final String item = countries.get(position);
        holder.bind(item, context);

        holderList.add(holder);
        if (lastPosition == position) {
            setSelectedItem(position);
        }

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
                selectedItem = countries.get(lastPosition);

                listener.onItemClicked(view, countries.get(position), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.countries.size();
    }

    public void setSelectedItem(int position) {
        holderList.get(position).photo.setVisibility(View.VISIBLE);
        lastPosition = position;
        selectedItem = countries.get(position);
    }

    public void setSelectedItem() {
        holderList.get(0).photo.setVisibility(View.VISIBLE);
        lastPosition = 0;
        selectedItem = countries.get(0);
    }

    public interface OnItemClickedListener {
        void onItemClicked(View view, String country, int position);
    }

}
