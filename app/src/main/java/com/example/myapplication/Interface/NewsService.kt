package com.example.myapplication.Interface

import com.example.myapplication.model.News
import com.example.myapplication.model.WebSite
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsService {
    @get:GET("v2/sources?apiKey=521d7618790540bba3a999a4de232111")
    val sources: Call<WebSite>

    @GET
    fun getNewsFromSource(@Url url:String):Call<News>
}