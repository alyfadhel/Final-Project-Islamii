package com.example.islamicfragment.Api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiManager {

    companion object{
        private var retrofit: Retrofit?=null

        private fun getRetrofitInstance():Retrofit{
            if (retrofit==null){
                val interceptor = HttpLoggingInterceptor { message -> Log.e("Api", message) }
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
                retrofit = Retrofit.Builder()
                    .client(client)
                    .baseUrl("http://api.mp3quran.net/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

        fun getApis():WebServices{
            return getRetrofitInstance().create(WebServices::class.java)
        }
    }
}