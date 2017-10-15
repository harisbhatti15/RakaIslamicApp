package com.pentavalue.yousry.rakaislamicapp.java.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pentavalue.yousry.rakaislamicapp.R;
import com.pentavalue.yousry.rakaislamicapp.java.models.Detail;
import com.pentavalue.yousry.rakaislamicapp.java.models.Rakaat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yousry on 10/9/2017.
 */

public class TestActivity extends AppCompatActivity {
    private static final String TAG = TestActivity.class.getSimpleName();

    // Access a Cloud Firestore instance from your Activity

    /*Map<String, Object> prayer = new HashMap<>();
    final List<Rakaat> rakaats =new ArrayList<>();
    List<Detail> details =new ArrayList<>();
    FirebaseFirestore db = FirebaseFirestore.getInstance();*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);



    }

   /* public void onAddCollectionClick(View view) {
        // Create a new user with a first and last name

        for (int i=0; i<3; i++){
            details.add(new Detail("Test_Title","Test_Body"));
        }
        for(int i=0;i<2;i++){
            Rakaat rakaat =new Rakaat("Rak'a "+ i, details);
            rakaats.add(rakaat);
        }

        prayer.put("title", "ElFgr");
        prayer.put("time", "4:10");
        //prayer.put("rakaat", rakaats);


        // Add a new document with a generated ID
        db.collection("prayers")
                .add(prayer)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        Map map =new HashMap<String, List<Rakaat>>();
                        map.put("0", rakaats);
                        documentReference.collection("rakaats").add(rakaats);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }*/
}
