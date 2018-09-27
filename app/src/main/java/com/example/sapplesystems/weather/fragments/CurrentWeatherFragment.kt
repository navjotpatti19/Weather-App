package com.example.sapplesystems.weather.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

import com.example.sapplesystems.weather.R
import com.example.sapplesystems.weather.activities.CurrentWeatherActivity
import com.example.sapplesystems.weather.activities.MainActivity
import com.example.sapplesystems.weather.interfaces.CurrentWeatherInterface
import com.example.sapplesystems.weather.models.CurrentWeatherRootObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CurrentWeatherFragment : Fragment() {

    lateinit var tv_weatherType: TextView
    lateinit var tv_tempInDegree: TextView
    lateinit var tv_pressureValue: TextView
    lateinit var tv_cityName: TextView
    lateinit var tv_degreeCelcius: TextView
    lateinit var tv_windSpeed: TextView
    lateinit var humidityValue: TextView
    lateinit var tv_fiveDayForecast: TextView
    lateinit var iv_currentWeather: ImageView

    var cont:Context? = null

    var count: Int = 0

    private var compositeDisposable: CompositeDisposable? = null
    private var rootObj: CurrentWeatherRootObject? = null

    companion object {
        val API_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" //put your API key from open weather API
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        cont = context
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_current_weather, container, false)

        initViews(view)
        compositeDisposable = CompositeDisposable()

        //method calling to fetch data from service using retrofit
        loadJson()

        return view
    }

    //initialize all the xml views
    private fun initViews(view: View) {
        tv_weatherType = view.findViewById(R.id.tv_weatherType)
        tv_tempInDegree = view.findViewById(R.id.tv_tempInDegree)
        tv_pressureValue = view.findViewById(R.id.tv_pressureValue)
        tv_windSpeed = view.findViewById(R.id.tv_windSpeed)
        tv_cityName = view.findViewById(R.id.tv_cityName)
        tv_degreeCelcius = view.findViewById(R.id.tv_degreeCelcius)
        humidityValue = view.findViewById(R.id.humidityValue)
        tv_fiveDayForecast = view.findViewById(R.id.tv_fiveDayForecast)
        iv_currentWeather = view.findViewById(R.id.iv_currentWeather)

        tv_fiveDayForecast.setOnClickListener {
            val i = Intent(activity, MainActivity::class.java)
            i.putExtra("CITY_NAME", rootObj!!.name)
            startActivity(i)
        }
    }

    private fun loadJson() {
        val requestInterface = Retrofit.Builder()
                .baseUrl(MainActivity.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(CurrentWeatherInterface::class.java)

        if(isAdded) {
            compositeDisposable?.add(requestInterface.getData((cont as CurrentWeatherActivity).city_arrayList[count], "metric", API_KEY)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(this::handleResponse, this::handleError))
        }
    }

    //method calling if response is successful
    private fun handleResponse(rootObject: CurrentWeatherRootObject) {
        rootObj = rootObject
        bindData()
    }

    //method calling if reponse is failure
    private fun handleError(error: Throwable) {
        Toast.makeText(activity, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
    }

    //binding data with the view
    @SuppressLint("SetTextI18n")
    private fun bindData() {
        tv_cityName.text = rootObj!!.name
        tv_degreeCelcius.text = "${rootObj!!.main.temp} ${0x00B0.toChar()} C"
        tv_weatherType.text = rootObj!!.weather[0].main
        tv_tempInDegree.text = "${rootObj!!.main.temp} ${0x00B0.toChar()} C"
        tv_pressureValue.text = rootObj!!.main.pressure + " hPa"
        tv_windSpeed.text = rootObj!!.wind.speed + resources.getString(R.string.wind_speed)
        humidityValue.text = rootObj!!.main.humidity + " %"

        val url: String = "http://openweathermap.org/img/w/" + rootObj!!.weather[0].icon + ".png"
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(iv_currentWeather)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }
}
