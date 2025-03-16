package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
    private val fruitList : List<Fruit>,
    private val clickListener : (Fruit) -> Unit
    ) : RecyclerView.Adapter<MyViewHolder>() {
//    private val fruitList = listOf<String>("Mango", "Guava", "Lemon", "Orange", "Pear", "Coconut", "Banana", "Apple", "SweetLime")

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
//        holder.myTextView.text = fruit.name + ", " + fruit.supplier
        holder.bind(fruit, clickListener)
    }
}

class MyViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
    fun bind(fruit : Fruit, clickListener: (Fruit) -> Unit) {
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = fruit.name + ", " + fruit.supplier

        // Adding an onClickListener
        view.setOnClickListener {
            clickListener(fruit)
//            Toast.makeText(view.context, "Selected fruit is ${fruit.name}", Toast.LENGTH_SHORT).show()
        }
    }

}