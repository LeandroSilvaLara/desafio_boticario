package com.leandro.desafio_boticario.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.leandro.desafio_boticario.R
import com.leandro.desafio_boticario.data.formatDate
import com.leandro.desafio_boticario.models.NewsBoticario
import de.hdodenhof.circleimageview.CircleImageView

class NewsBoticarioAdapter (private val newsBoticario: ArrayList<NewsBoticario>, private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return newsBoticario.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_boticario_item, parent, false)
        return NewsBoticarioViewHolder(view)
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsBoticarioViewHolder).bindView(newsBoticario[position], context)
    }

    class NewsBoticarioViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindView(new: NewsBoticario, context: Context){

            val author = itemView.findViewById<TextView>(R.id.txt_author_news_boticario)
            val image = itemView.findViewById<CircleImageView>(R.id.img_news_boticario)
            val date = itemView.findViewById<TextView>(R.id.txt_date_news_boticario)
            val message = itemView.findViewById<TextView>(R.id.txt_message_news_boticario)

            author.text = new.user?.name

            Glide
                .with(context)
                .load(new.user?.profile_picture)
                .placeholder(R.drawable.logo_oboticario)
                .into(image)

            message.text = new.message?.content
            date.text = new.message?.created_at?.formatDate()

        }
    }
}