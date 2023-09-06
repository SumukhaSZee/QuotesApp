package com.example.quotesapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.R
import com.example.quotesapp.models.QuoteResponseItem

class QuoteAdapter(private val quotes: ArrayList<QuoteResponseItem>):RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.quote_item, parent, false)
        return QuoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val quote = quotes[position]
        holder.apply {

            quotetext.text = quote.text
            author.text = quote.author



            itemView.setOnClickListener{
                var bundle = Bundle()
                bundle.putString("Quote",quote.text)
                bundle.putString("Author",quote.author)
                it.findNavController().navigate(R.id.action_quoteListFragment_to_quoteDetailsFragment,bundle)
            }
        }

    }

    override fun getItemCount(): Int {
            return quotes.size
    }

    class QuoteViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
            val quotetext:TextView = itemView.findViewById(R.id.Quoteofitemview)
            val author:TextView  = itemView.findViewById(R.id.Authorofitemview)
    }

}