package com.example.moneytrack.recycle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneytrack.R
import com.example.moneytrack.data.ModelDB

class MyAdapter(val context: Context,val list: List<ModelDB>,val onClick: OnClick)
    : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return (MyViewHolder(view))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var modelDB=list.get(position)
        holder.setData(modelDB)
        holder.imageView.setOnClickListener(View.OnClickListener {
            onClick.edit(modelDB)
        })
        holder.imageView2.setOnClickListener(View.OnClickListener {
            onClick.delete(modelDB)
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
