package com.example.unit2_project

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import java.text.ParsePosition


class ShoppingItemAdapter(private val shoppingList: MutableList<ShoppingItem>):
    Adapter<ShoppingItemAdapter.ViewHolder>() {
    private var totalItems = 0


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemNameTextView: TextView
        val itemPriceTextView: TextView
        val itemLinkTextView: TextView
        init {
            itemNameTextView = itemView.findViewById<TextView>(R.id.itemNameTextView)
            itemPriceTextView = itemView.findViewById<TextView>(R.id.itemPriceTextView)
            itemLinkTextView = itemView.findViewById<TextView>(R.id.itemLinkTextView)
        }

    }

    public fun addToShoppingList(entry: ShoppingItem){
        shoppingList.add(totalItems, entry)
        totalItems ++
        Log.d("shopping items", shoppingList.toString())
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.shopping_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return totalItems
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoppingItem = shoppingList[position]
        holder.itemNameTextView.text = shoppingItem.name
        holder.itemPriceTextView.text = "$" + shoppingItem.price.toString()
        holder.itemLinkTextView.text = shoppingItem.link
    }

}