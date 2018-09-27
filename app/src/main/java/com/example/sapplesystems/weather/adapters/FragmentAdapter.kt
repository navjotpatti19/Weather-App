package com.example.sapplesystems.weather.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.example.sapplesystems.weather.fragments.CurrentWeatherFragment

/**
 * Created by Sapple Systems on 3/21/2018.
 */
class FragmentAdapter(fm: FragmentManager, var cityList: ArrayList<String>): FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        val frag = CurrentWeatherFragment()
        frag.count = position
        return frag
    }

    //returns the size of view pager
    override fun getCount(): Int {
        return cityList.size
    }

    override fun getItemPosition(`object`: Any?): Int {
        val index = cityList.indexOf(`object`)
        return if(index == -1) {
            PagerAdapter.POSITION_NONE
        } else {
            index
        }
    }
}