package com.example.myapplication.Adapter.ViewHolder

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Common.Parser
import com.example.myapplication.Interface.ItemClickListener
import com.example.myapplication.NewsDetail
import com.example.myapplication.R
import com.example.myapplication.model.Article
import com.squareup.picasso.Picasso
import java.text.ParseException
import java.util.*

class ListNewsAdapter(val articleList: MutableList<Article>,private val context: Context):RecyclerView.Adapter<ListNewsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNewsViewHolder {
       val inflater = LayoutInflater.from(parent!!.context)
       val itemView = inflater.inflate(R.layout.news_layout,parent,false)
       return ListNewsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return articleList.size
    }

    override fun onBindViewHolder(holder: ListNewsViewHolder, position: Int) {
       //load Image
        Picasso.with(context)
            .load(articleList[position].urlToImage)
            .into(holder.article_image)


        if (articleList[position].title!!.length > 65)
        {
            holder.article_title.text = articleList[position].title!!.substring(0,65)+"..."
        }
        else{
            holder.article_title.text = articleList[position].title!!
        }
        if(articleList[position].publishedAt != null)
        {
            var date: Date?=null
            try{
                date = Parser.parse(articleList[position].publishedAt!!)
            }catch(ex:ParseException)
            {
                ex.printStackTrace()
            }
            date?.let {
                holder.article_time.setReferenceTime(it.time)

            }
        }
        //Set event click
        holder.setItemClickListener(object : ItemClickListener{
            override fun onClick(view: View, position: Int) {

                val detail = Intent(context,NewsDetail::class.java)
                detail.putExtra("webUrl",articleList[position].url)
                context.startActivity(detail)
            }

        })
    }

}