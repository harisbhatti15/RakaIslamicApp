package com.pentavalue.yousry.rakaislamicapp.java.interfaces;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yousry on 10/11/2017.
 */

public interface MuslimSalatAPIService {
    @GET("/cairo.json")
    Call<JsonObject> readJsonFromApiUri(@Query("key") String apiKey);
}
