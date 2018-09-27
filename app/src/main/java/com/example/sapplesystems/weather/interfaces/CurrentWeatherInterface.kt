package com.example.sapplesystems.weather.interfaces

import com.example.sapplesystems.weather.models.CurrentWeatherRootObject
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sapple Systems on 3/21/2018.
 */
interface CurrentWeatherInterface {

    @GET("/data/2.5/weather/")
    fun getData(@Query("q") city: String, @Query("units") units: String, @Query("appid") apiKey: String): Observable<CurrentWeatherRootObject>

}