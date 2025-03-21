package com.example.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.ui.theme.RecyclerViewTheme

class MainActivity : AppCompatActivity() {
    private val fruitList = listOf<Fruit>(
        Fruit("Mango", "Joe"),
        Fruit("Guava", "Stephen"),
        Fruit("Lemon", "Root"),
        Fruit("Orange", "Fedex"),
        Fruit("Pear", "FirstCry"),
        Fruit("Coconut", "SnapDeal"),
        Fruit("Banana","Meesho"),
        Fruit("Apple", "Flipkart"),
        Fruit("SweetLime", "Amazon"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(fruitList, {
            selectedItem : Fruit -> listItemClicked(selectedItem)
        })
    }

    private fun listItemClicked(fruit: Fruit)  {
        Toast.makeText(this@MainActivity, "Supplier is ${fruit.supplier}", Toast.LENGTH_SHORT).show()
    }
}