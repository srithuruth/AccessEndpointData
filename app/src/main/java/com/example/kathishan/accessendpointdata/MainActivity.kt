package com.example.kathishan.accessendpointdata

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_pass.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL_POP)
            .addConverterFactory(GsonConverterFactory.create())

        val retrofit = retrofitBuilder
            .client(okHttpClient)
            .build()

        val populationClient = retrofit.create(PopulationService::class.java)
btnSubmit.setOnClickListener {
    populationClient.getUserDetails(etCountry.text.toString()).enqueue(object : Callback<PopulationData> {
        override fun onFailure(call: Call<PopulationData>, throwable: Throwable) {
            throwable.printStackTrace()
}

         override fun onResponse(call: call<>, response: Response<PopulationData>) {
             if (response.isSuccessful) {
                 val PopulationData = response.body()
                 tvCountry.text = PopulationData?.country
                 tvAge.text = PopulationData?.age
             }
         }
     })
 }

    }
}
