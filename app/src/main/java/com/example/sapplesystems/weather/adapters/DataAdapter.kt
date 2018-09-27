package com.example.sapplesystems.weather.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.sapplesystems.weather.R
import com.example.sapplesystems.weather.models.ListData
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Sapple Systems on 3/14/2018.
 */
class DataAdapter (private val dataList: List<ListData>, val context: Context)
    : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    var temp: Boolean = true

    //inflate the layout
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.listitem_rows, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        viewCreation(holder, position)
    }

    // returns the number of items in recycler view
    override fun getItemCount(): Int = dataList.count()

    //creating the UI
    private fun viewCreation(holder: ViewHolder, position: Int) {

        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
        val date: Date = sdf.parse(dataList[position].dt_txt)
        val time: String = DateFormat.format("hh:mm a", date).toString()
        val day: String = DateFormat.format("EEEE", date).toString()

        var p = position
        if(position > 0) {
            temp = false
            p = position - 1
        } else {
            temp = true
        }

        val oldView = sdf.parse(dataList[p].dt_txt)

        val newTime = DateFormat.format("dd",date).toString()
        val oldTime = DateFormat.format("dd",oldView).toString()

        if (newTime == oldTime) {
            if(temp) {
                holder.tv_dayName.visibility = View.VISIBLE
            } else {
                holder.tv_dayName.visibility = View.GONE
            }
        } else {
            holder.tv_dayName.visibility = View.VISIBLE
        }

        holder.tv_dayName.text = day
        holder.tv_time.text = time
        holder.tv_weatherType.text = dataList[position].weather[0].main.trim()
        holder.tv_tempInDegree.text = "${dataList[position].main.temp.trim()} ${0x00B0.toChar()} C"
        holder.tv_pressureValue.text = dataList[position].main.pressure.trim() + " hPa"
        holder.humidityValue.text = dataList[position].main.humidity.trim() + " %"

        val url: String = "http://openweathermap.org/img/w/" + dataList[position].weather[0].icon + ".png"
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img_currentWeather)
    }

    //initializing the views
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var tv_time: TextView = view.findViewById(R.id.tv_time)
        var tv_weatherType: TextView = view.findViewById(R.id.tv_weatherType)
        var tv_tempInDegree: TextView = view.findViewById(R.id.tv_tempInDegree)
        var tv_pressureValue: TextView = view.findViewById(R.id.tv_pressureValue)
        var humidityValue: TextView = view.findViewById(R.id.humidityValue)
        var tv_dayName: TextView = view.findViewById(R.id.tv_dayName)

        var img_currentWeather: ImageView = view.findViewById(R.id.img_currentWeather)
    }
}