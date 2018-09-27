package com.example.sapplesystems.weather.helper_classes

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by Sapple Systems on 3/23/2018.
 */
class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERISION) {

    companion object {
        val DATABASE_NAME = "WeatherAppDB"
        val DATABASE_VERISION = 1
        private var instance: DBHelper? = null

        //table name and column name identifier
        val CITY_TABLE_NAME = "session"
        val CITY_COLUMN_NAME = "cityColumnName"

        val CURRENT_CITIES_TABLE_NAME = "cities"
        val CURRENT_CITIES_COLUMN_NAME = "currentCitiesColumnName"

        @Synchronized
        fun getInstance(context: Context): DBHelper {
            if(instance == null) {
                instance = DBHelper(context)
            }
            return instance as DBHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("create table $CITY_TABLE_NAME(primaryid integer primary key, cityColumnName text)")
        db.execSQL("create table $CURRENT_CITIES_TABLE_NAME(primaryid integer primary key, currentCitiesColumnName text)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insertCurrentCities(city: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(CURRENT_CITIES_COLUMN_NAME, city.trim())
        db.insert(CURRENT_CITIES_TABLE_NAME, null, contentValues)
        return true
    }

    fun getCurrentCities(): ArrayList<String> {
        val db = this.readableDatabase
        val aList = ArrayList<String>()
        val res = db.query(CURRENT_CITIES_TABLE_NAME, null, null, null, null, null, null)
        res.moveToFirst()

        while (!res.isAfterLast) {
            aList.add(res.getString(res.getColumnIndex(CURRENT_CITIES_COLUMN_NAME)))
            res.moveToNext()
        }
        res.close()
        return aList
    }

    fun deleteCity() {
        val db = this.writableDatabase
        db.execSQL("delete from " + CITY_TABLE_NAME)
    }
}