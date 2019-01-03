package com.example.kathishan.accessendpointdata

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface PopulationService {
    @GET("{population/{country}/{age}")

    fun getPopDetails(@Path("country") country: String,
                      @Path("age") age: Int) : Call<Response>
}