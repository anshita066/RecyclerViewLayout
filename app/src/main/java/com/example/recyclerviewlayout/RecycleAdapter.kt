package com.example.recyclerviewlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter: RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {

    private var title = arrayOf("Himachal Pradesh","Rajasthan","Gangtok","Sikkim","Gujarat","Bengal","Goa","Kerala")

    private var details = arrayOf("5days 4nights package","5days 4nights package","6days 5nights package","7days 6nights package",
        "6days 5nights package","5days 4nights package","7days 6nights package","8days 7nights package")

    private var price = arrayOf("Rs 10,000","Rs 7,000","Rs 18,000","Rs 20000","Rs 12,000","Rs 10,000","Rs 30,000","Rs 50,000")

    private var images = intArrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
        R.drawable.pic6, R.drawable.pic7, R.drawable.pic8)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return title.size
    }

    override fun onBindViewHolder(holder: RecycleAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDetail.text = details[position]
        holder.itemPrice.text = price[position]
        holder.itemImage.setImageResource(images[position])

    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var itemPrice: TextView
        var ratingBar: RatingBar

        init{
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
            itemPrice = itemView.findViewById(R.id.item_price)
            ratingBar = itemView.findViewById(R.id.ratingBar1)
        }
    }
}