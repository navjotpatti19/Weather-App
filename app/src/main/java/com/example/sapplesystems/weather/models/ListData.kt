package com.example.sapplesystems.weather.models

/**
 * Created by Sapple Systems on 3/14/2018.
 */
data class ListData (val dt: Int, val main: Main, val weather: List<Weather>, val wind: Wind, val dt_txt: String)