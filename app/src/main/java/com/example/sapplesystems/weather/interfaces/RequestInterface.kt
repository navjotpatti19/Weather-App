package com.example.sapplesystems.weather.interfaces

import com.example.sapplesystems.weather.models.RootObject
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sapple Systems on 3/14/2018.
 */
interface RequestInterface {

    @GET("/data/2.5/forecast/")
    fun getData(@Query("q") city: String, @Query("units") units: String, @Query("appid") apiKey: String): Observable<RootObject>
}
