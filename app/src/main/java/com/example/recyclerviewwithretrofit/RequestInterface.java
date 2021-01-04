package com.example.recyclerviewwithretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("cars_list.json")
    Call<List<CarsModel>> getCarsJason();
}
