package com.pentavalue.yousry.rakaislamicapp.java.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marcinorlowski.fonty.Fonty;
import com.pentavalue.yousry.rakaislamicapp.R;
import com.pentavalue.yousry.rakaislamicapp.java.models.Prayer;
import com.pentavalue.yousry.rakaislamicapp.kotlin.holders.PrayerViewHolder;

import java.util.List;

/**
 * Created by yousry on 10/2/2017.
 */

public class PrayerAdapter extends RecyclerView.Adapter<PrayerViewHolder> {

    Context context;
    List<Prayer> prayers;
    private OnItemClickedListener listener;

    public PrayerAdapter(Context context, List<Prayer> prayers, OnItemClickedListener listener) {
        this.listener = listener;
        this.context = context;
        this.prayers = prayers;

    }

    @Override
    public PrayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prayer_home, parent, false);
        Fonty.setFonts((ViewGroup) view);
        return new PrayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PrayerViewHolder holder, final int position) {

        holder.bind(prayers.get(position), context);

        if (prayers.get(position).getRakaat().size() == 0) {

        } else {
            holder.getCardView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClicked(view, prayers.get(position), position);
                }
            });
            holder.getContainer().setBackgroundColor(context.getResources().getColor(prayers.get(position).getColor()));
        }


    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return prayers.size();
    }

    public interface OnItemClickedListener {
        void onItemClicked(View view, Prayer prayer, int position);
    }


}
