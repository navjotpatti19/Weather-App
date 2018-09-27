package com.example.sapplesystems.weather.models

/**
 * Created by Sapple Systems on 3/21/2018.
 */
data class CurrentWeatherRootObject(val name: String, val weather: List<Weather>, val wind: Wind, val main: Main)