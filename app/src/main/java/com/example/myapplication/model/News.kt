package com.example.myapplication.model

import com.example.myapplication.model.Article


data class News(
    val articles: MutableList<Article>?=null,
    val status: String?=null,
    val totalResults: Int= 0
)