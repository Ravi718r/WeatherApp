package com.example.weatherappjc

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") city :String,
        @Query("appid") apikey :String,
        @Query("units") units : String ="metric"
    ):WeatherResponse

    companion object{
        private const val BASR_URL ="https://api.openweathermap.org/data/2.5/"

        fun create() : WeatherAPI{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASR_URL)
                .build()
            return retrofit.create(WeatherAPI::class.java)
        }

    }

}