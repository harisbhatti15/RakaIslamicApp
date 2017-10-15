package com.pentavalue.yousry.rakaislamicapp.java;

import android.app.Application;

import com.marcinorlowski.fonty.Fonty;


/**
 * Created by yousry on 10/5/2017.
 */

public class AppBaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fonty.context(this)
                .regularTypeface("ghla.ttf")
                .boldTypeface("ghla_bold.ttf")
                .done();
    }
}
