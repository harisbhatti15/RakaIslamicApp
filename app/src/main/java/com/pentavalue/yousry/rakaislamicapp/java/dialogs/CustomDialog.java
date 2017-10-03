package com.pentavalue.yousry.rakaislamicapp.java.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.pentavalue.yousry.rakaislamicapp.R;
import com.pentavalue.yousry.rakaislamicapp.kotlin.activities.HomeActivity;


/**
 * Created by yousry on 10/2/2017.
 */

public class CustomDialog extends Dialog {
    Context context;
    private static final String TAG =CustomDialog.class.getSimpleName();

    Button cancelButton;
    Button changeButton;

    public CustomDialog(@NonNull Context context) {
        super(context);
        this.context =context;
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context =context;
    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context =context;
    }
    static int x =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_cusotm_layout);
        cancelButton =findViewById(R.id.button_cancel);
        changeButton =findViewById(R.id.button_change);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //context.startActivity(new Intent(context, CountriesActivity.class).putExtra("TAG","dialog"));
                Intent intent =new Intent(context, HomeActivity.class);
            }
        });


    }


}