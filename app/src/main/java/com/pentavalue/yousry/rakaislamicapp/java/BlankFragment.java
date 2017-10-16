package com.pentavalue.yousry.rakaislamicapp.java;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pentavalue.yousry.rakaislamicapp.R;
import com.pentavalue.yousry.rakaislamicapp.kotlin.activities.CountryActivity;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.test, container, false);

        Button button = view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Locale.getDefault().getDisplayLanguage().equals("English") ||
                        Locale.getDefault().getDisplayLanguage().equals("english") ||
                        Locale.getDefault().getDisplayLanguage().equals("en")) {

                    startActivity(new Intent(getContext(), CountryActivity.class));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(BlankFragment.this).commit();

                } else {
                    getActivity().getSupportFragmentManager().beginTransaction().remove(BlankFragment.this).commit();

                }

            }
        });
        Button button1 = view.findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Locale.getDefault().getDisplayLanguage().equals("English") ||
                        Locale.getDefault().getDisplayLanguage().equals("english") ||
                        Locale.getDefault().getDisplayLanguage().equals("en")) {
                    getActivity().getSupportFragmentManager().beginTransaction().remove(BlankFragment.this).commit();

                } else {
                    startActivity(new Intent(getContext(), CountryActivity.class));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(BlankFragment.this).commit();
                }
            }
        });

        return view;
    }

}
