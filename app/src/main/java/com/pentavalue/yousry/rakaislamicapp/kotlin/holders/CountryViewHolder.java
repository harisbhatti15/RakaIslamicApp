package com.pentavalue.yousry.rakaislamicapp.kotlin.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pentavalue.yousry.rakaislamicapp.R;


/**
 * Created by yousry on 9/10/2017.
 */

public class CountryViewHolder extends RecyclerView.ViewHolder {

    public static final String TAG = CountryViewHolder.class.getSimpleName();
    public LinearLayout layout;
    public ImageView photo;
    private Context context;
    private View view;
    private TextView name;


    public CountryViewHolder(View itemView) {
        super(itemView);
        view = itemView;
    }

    public void bind(final String nameOfCountry, final Context context) {
        this.context = context;
        name = (TextView) view.findViewById(R.id.name);
        name.setText(nameOfCountry);
        photo = (ImageView) view.findViewById(R.id.image);
        photo.setVisibility(View.INVISIBLE);
        layout = (LinearLayout) view.findViewById(R.id.root);


    }

}
