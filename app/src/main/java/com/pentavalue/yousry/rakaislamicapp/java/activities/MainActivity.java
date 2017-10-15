package com.pentavalue.yousry.rakaislamicapp.java.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.pentavalue.yousry.rakaislamicapp.R;
import com.pentavalue.yousry.rakaislamicapp.Util.Util;
import com.pentavalue.yousry.rakaislamicapp.java.interfaces.MuslimSalatAPIService;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    final Integer x = 0;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String mUrl ="http://muslimsalat.com/";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =findViewById(R.id.textView);

        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl(mUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MuslimSalatAPIService apiService = retrofit2.create(MuslimSalatAPIService.class);
        Call<JsonObject> jsonCall =apiService.readJsonFromApiUri(Util.MuslimAPI);
        jsonCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                try {
                    String jsonString = response.body().toString();

                    if(jsonString.isEmpty()){
                        Log.v(TAG, "Json String is Null or Empty");
                    }else {
                        Log.v(TAG, "Json String is "+ jsonString);
                        Gson gson =new Gson();
                        //Type listType = new TypeToken<ArrayList<Items>>(){}.getType();
                        Example myExample = gson.fromJson(jsonString, Example.class);
                        //ArrayList<Items> item = gson.fromJson(jsonString, listType);
                        Log.i(TAG, String.valueOf(myExample.getItems().get(0).toString()));
                        textView.setText(myExample.getItems().get(0).toString());
                    }
                }catch (NullPointerException e){
                    Log.e(TAG, e.getMessage());
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });


    }
    class MyExample{
        int status_code;
        List<Items> Items;
    }
    class Items {


        private String dateFor;

        private String fajr;

        private String shurooq;

        private String dhuhr;

        private String asr;

        private String maghrib;

        private String isha;

        @Override
        public String toString() {
            return "Items{" +
                    "dateFor='" + dateFor + '\'' +
                    ", fajr='" + fajr + '\'' +
                    ", shurooq='" + shurooq + '\'' +
                    ", dhuhr='" + dhuhr + '\'' +
                    ", asr='" + asr + '\'' +
                    ", maghrib='" + maghrib + '\'' +
                    ", isha='" + isha + '\'' +
                    '}';
        }

        public String getDateFor() {
            return dateFor;
        }

        public void setDateFor(String dateFor) {
            this.dateFor = dateFor;
        }

        public String getFajr() {
            return fajr;
        }

        public void setFajr(String fajr) {
            this.fajr = fajr;
        }

        public String getShurooq() {
            return shurooq;
        }

        public void setShurooq(String shurooq) {
            this.shurooq = shurooq;
        }

        public String getDhuhr() {
            return dhuhr;
        }

        public void setDhuhr(String dhuhr) {
            this.dhuhr = dhuhr;
        }

        public String getAsr() {
            return asr;
        }

        public void setAsr(String asr) {
            this.asr = asr;
        }

        public String getMaghrib() {
            return maghrib;
        }

        public void setMaghrib(String maghrib) {
            this.maghrib = maghrib;
        }

        public String getIsha() {
            return isha;
        }

        public void setIsha(String isha) {
            this.isha = isha;
        }

    }
}

