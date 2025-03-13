package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val fruitList = listOf<String>("Mango", "Guava", "Lemon", "Orange", "Pear", "Coconut", "Banana", "Apple", "SweetLime")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return fruitList.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // This is used to display the data on the list item
        val fruit = fruitList[position]
        holder.myTextView.text = fruit
    }
}

class MyViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
    val myTextView = view.findViewById<TextView>(R.id.tvName)
}