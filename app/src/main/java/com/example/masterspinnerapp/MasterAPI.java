package com.example.masterspinnerapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MasterAPI {

    @GET("countryUsers")
    Call<List<CountryModel>> getCountryDetails();


    @GET("stateUsers")
    Call<List<StateModel>> getStateDetails();

    @GET("district_master/all")
    Call<List<DistrictModel>> getDistrictDetails();

    @GET("loginUser")
    Call<List<UserModel>> getUserDetails();

    @POST("registerUser")
    Call<UserModel> createUserPost(@Body UserModel userModel);


}
