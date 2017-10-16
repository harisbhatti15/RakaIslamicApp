package com.pentavalue.yousry.rakaislamicapp.java.models;


import org.apache.commons.lang3.builder.ToStringBuilder;

public class Detail {


    private String title;
    private String details;

    /**
     * No args constructor for use in serialization
     */
    public Detail() {
        title = "";
        details = "";
    }

    /**
     * @param title
     * @param details
     */
    public Detail(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("title", title).append("details", details).toString();
    }

}