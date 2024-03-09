package com.example.unit2_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = ShoppingItemAdapter(mutableListOf<ShoppingItem>())

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)


        // add a divider to separate items
        val  dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)


        val itemNameTextView = findViewById<EditText>(R.id.item_name)
        val itemPriceTextView = findViewById<EditText>(R.id.item_price)
        val itemLinkTextView = findViewById<EditText>(R.id.item_link)
        val submitButton = findViewById<Button>(R.id.submit)

        submitButton.setOnClickListener{
            val itemName = itemNameTextView.text.toString()
            val itemPrice = itemPriceTextView.text.toString()
            val itemLink = itemLinkTextView.text.toString()
            if (itemName.isNotEmpty() and itemPrice.isNotEmpty() and itemLink.isNotEmpty()){
//                TODO("Add then to the recycler view and update the list")
                val newItem = ShoppingItem(itemName, itemPrice.toDouble(), itemLink)
                adapter.addToShoppingList(newItem)
                itemNameTextView.setText("")
                itemPriceTextView.setText("")
                itemLinkTextView.setText("")

            } else{
                Toast.makeText(this, "Fields can't be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}