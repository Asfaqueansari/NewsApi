package com.example.myapplication.Common

import com.example.myapplication.Interface.NewsService
import com.example.myapplication.Retrofit.RetrofitClient
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

object Common{
    val BASE_URL="https://newsapi.org/"
    val API_KEY="521d7618790540bba3a999a4de232111"


    val newsService:NewsService
    get() = RetrofitClient.getClient(BASE_URL).create(NewsService::class.java)

    fun getNewsAPI(source: String):String{
        val apiUrl = StringBuilder("https://newsapi.org/v2/top-headlines?sources=")
            .append(source)
            .append("&apikey=")
            .append(API_KEY)
            .toString()
        return apiUrl
    }
}