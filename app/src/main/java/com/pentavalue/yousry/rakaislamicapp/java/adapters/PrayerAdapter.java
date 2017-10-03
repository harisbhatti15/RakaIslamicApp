package com.pentavalue.yousry.rakaislamicapp.java.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pentavalue.yousry.rakaislamicapp.R;
import com.pentavalue.yousry.rakaislamicapp.kotlin.holders.PrayerViewHolder;
import com.pentavalue.yousry.rakaislamicapp.java.models.Prayer;

import java.util.List;

/**
 * Created by yousry on 10/2/2017.
 */

public class PrayerAdapter extends RecyclerView.Adapter<PrayerViewHolder>{

    Context context;
    List<Prayer> prayers;

    public PrayerAdapter(Context context, List<Prayer> prayers, OnItemClickedListener listener) {
        this.listener =listener;
        this.context = context;
        this.prayers = prayers;
    }

    @Override
    public PrayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prayer_home, parent, false);

        return new PrayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PrayerViewHolder holder, final int position) {
        holder.bind(prayers.get(position), context);
        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(view, prayers.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return prayers.size();
    }

    private OnItemClickedListener listener;
    public interface OnItemClickedListener{
        void onItemClicked(View view, Prayer prayer);
    }
}
