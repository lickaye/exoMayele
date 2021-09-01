package com.massane.mayele2021;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoursApi {

    @GET("cours-shool")
    Call<List<ModelCours>> getApi(@Query("limit") int limit);
}
