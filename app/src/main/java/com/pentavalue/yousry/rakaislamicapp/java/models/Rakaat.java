package com.pentavalue.yousry.rakaislamicapp.java.models;

import android.graphics.drawable.Drawable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Rakaat {


    private String title;
    private Drawable drawable;
    private Drawable selectedDrawable;
    private List<Detail> details = new ArrayList<Detail>();

    /**
     * No args constructor for use in serialization
     */
    public Rakaat() {
        title = "";
        drawable = null;
    }

    /**
     * @param title
     * @param details
     */
    public Rakaat(String title, List<Detail> details) {
        this.title = title;
        this.details = details;
        this.drawable = null;
        this.selectedDrawable =null;
    }

    public Drawable getSelectedDrawable() {
        return selectedDrawable;
    }

    public void setSelectedDrawable(Drawable selectedDrawable) {
        this.selectedDrawable = selectedDrawable;
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

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("title", title).append("details", details).toString();
    }

}