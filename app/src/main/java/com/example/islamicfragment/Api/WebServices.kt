package com.example.islamicfragment.Api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface WebServices {

    @GET("radios/radio_arabic.json")
    fun getRadioChannels():Call<RadioResponse>

}