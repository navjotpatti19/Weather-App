package com.example.sapplesystems.weather.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.widget.ImageView
import com.example.sapplesystems.weather.R
import com.example.sapplesystems.weather.adapters.FragmentAdapter
import com.example.sapplesystems.weather.helper_classes.DBHelper

class CurrentWeatherActivity : AppCompatActivity() {

    lateinit var pagerAdapter: FragmentAdapter
    lateinit var viewPager: ViewPager
    private lateinit var iv_add: ImageView
    lateinit var cityname: String
    var city_arrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_weather)

        if(intent.extras != null) {
            cityname = intent.getStringExtra("CITY_NAME")
        }

        initViews()

        DBHelper.getInstance(this@CurrentWeatherActivity).insertCurrentCities(cityname)
        city_arrayList.clear()
        city_arrayList = DBHelper.getInstance(this@CurrentWeatherActivity).getCurrentCities()

        pagerAdapter = FragmentAdapter(supportFragmentManager, city_arrayList)
        viewPager.adapter = pagerAdapter
        pagerAdapter.notifyDataSetChanged()

        iv_add.setOnClickListener {
            finish()
        }
    }

    private fun initViews() {

        viewPager = findViewById(R.id.viewPager)
        iv_add = findViewById(R.id.iv_add)
    }
}
