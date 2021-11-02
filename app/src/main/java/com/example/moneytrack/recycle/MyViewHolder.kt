package com.example.moneytrack.recycle

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moneytrack.data.ModelDB
import kotlinx.android.synthetic.main.item.view.*

class MyViewHolder(itemview:View):RecyclerView.ViewHolder (itemview){
    var imageView=itemView.edit
    var imageView2=itemView.delete
    fun setData(modelDB: ModelDB)
    {
        itemView.desc.text=modelDB.desc
        itemView.amount.text=modelDB.amount.toString()
    }
}