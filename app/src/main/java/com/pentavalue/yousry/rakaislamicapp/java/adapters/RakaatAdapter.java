package com.pentavalue.yousry.rakaislamicapp.java.adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.marcinorlowski.fonty.Fonty;
import com.pentavalue.yousry.rakaislamicapp.R;
import com.pentavalue.yousry.rakaislamicapp.java.models.Prayer;
import com.pentavalue.yousry.rakaislamicapp.kotlin.holders.RakaaViewHolder;
import com.pentavalue.yousry.rakaislamicapp.java.models.Rakaat;

import org.intellij.lang.annotations.Language;

import java.util.List;
import java.util.Locale;

/**
 * Created by yousry on 10/3/2017.
 */

public class RakaatAdapter extends RecyclerView.Adapter<RakaaViewHolder> {
    List<Rakaat> rakaats;
    Context context;

    long delayAnimate =500;
    RakaaViewHolder lastView;
    Rakaat lastItemModel =new Rakaat();

    private int lastPosition = -1;
    public RakaatAdapter(List<Rakaat> rakaats, Context context) {
        this.rakaats = rakaats;
        this.context = context;
        this.listener =null;
    }

    public RakaatAdapter(List<Rakaat> rakaats, Context context, OnItemClickedListener listener) {
        this.listener =listener;
        this.rakaats = rakaats;
        this.context = context;
    }

    @Override
    public RakaaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rakaa_home,parent, false);

        if (Locale.getDefault().getDisplayLanguage().equals("English") ||
                Locale.getDefault().getDisplayLanguage().equals("english") ||
                Locale.getDefault().getDisplayLanguage().equals("en")){
        }else{
            Fonty.setFonts((ViewGroup) view);
        }

        return new RakaaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RakaaViewHolder holder, final int position) {
        holder.bind(rakaats.get(position));
        if(lastView == null){
            lastView = holder;
            lastItemModel = rakaats.get(position);
            lastView.getIndicator().setBackgroundColor(context.getResources().getColor(R.color.colorPaleBrown));
            lastView.getImageView().setImageDrawable(rakaats.get(position).getSelectedDrawable());

        }
        holder.itemView.setVisibility(View.INVISIBLE);

        if (Locale.getDefault().getDisplayLanguage().equals("English") ||
                Locale.getDefault().getDisplayLanguage().equals("english") ||
                Locale.getDefault().getDisplayLanguage().equals("en")){
            // Here you apply the animation when the view is bound
            setAnimation(holder.itemView, position, R.anim.anim_slide_in_left);
        }else{
            // Here you apply the animation when the view is bound
            setAnimation(holder.itemView, position, R.anim.anim_slide_in_right);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastView.getImageView().setImageDrawable(lastItemModel.getDrawable());
                lastView.getIndicator().setBackgroundColor(context.getResources().getColor(R.color.colorPlatinum));
                lastView =holder;
                lastItemModel =rakaats.get(position);
                lastView.getIndicator().setBackgroundColor(context.getResources().getColor(R.color.colorPaleBrown));
                lastView.getImageView().setImageDrawable(rakaats.get(position).getSelectedDrawable());
                listener.onItemClicked(view,rakaats.get(position), lastView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rakaats.size();
    }

    private OnItemClickedListener listener;
    public interface OnItemClickedListener{
        void onItemClicked(View view, Rakaat rakaat, RakaaViewHolder oldView);
    }

    public List<Rakaat> getRakaats() {
        return rakaats;
    }

    public void setRakaats(List<Rakaat> rakaats) {
        this.rakaats = rakaats;
        lastView.getImageView().setImageDrawable(lastItemModel.getDrawable());
        lastView.getIndicator().setBackgroundColor(context.getResources().getColor(R.color.colorPlatinum));

        lastView =null;
        lastItemModel =this.rakaats.get(0);
        notifyDataSetChanged();
    }
    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(final View viewToAnimate, int position, final int id)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    Animation animation = AnimationUtils.loadAnimation(context, id);
                    if(viewToAnimate!=null){
                        viewToAnimate.startAnimation(animation);
                        viewToAnimate.setVisibility(View.VISIBLE);
                    }
                }
            }, delayAnimate);
            delayAnimate +=300;
            /*viewToAnimate.setVisibility(View.VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(context, id);
            animation.setDuration(delayAnimate);

            viewToAnimate.startAnimation(animation);
            //viewToAnimate.animate().setStartDelay(delayAnimate).setDuration(delayAnimate).start();
            lastPosition = position;
            delayAnimate +=5000;*/
        }
    }
    @Override
    public void onViewDetachedFromWindow(RakaaViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.clearAnimation();
    }
}
