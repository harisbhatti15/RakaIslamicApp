package com.pentavalue.yousry.rakaislamicapp.java.models;

import android.graphics.drawable.Drawable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Prayer {

    private String title;
    private String time;
    private Drawable drawable;
    private int color;
    private List<Rakaat> rakaat = new ArrayList<Rakaat>();

    /**
     * No args constructor for use in serialization
     */
    public Prayer() {
        this.title = "";
        this.time = "";
        this.drawable = null;
        color = 0;
    }

    /**
     * @param rakaat
     * @param time
     * @param title
     */
    public Prayer(String title, String time, List<Rakaat> rakaat) {
        this.title = title;
        this.time = time;
        this.drawable = null;
        this.rakaat = rakaat;
        this.color = 0;
    }


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Rakaat> getRakaat() {
        return rakaat;
    }

    public void setRakaat(List<Rakaat> rakaat) {
        this.rakaat = rakaat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("title", title).append("time", time).append("rakaat", rakaat).toString();
    }

}