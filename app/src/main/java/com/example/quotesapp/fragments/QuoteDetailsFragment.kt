package com.example.quotesapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.quotesapp.R
import com.example.quotesapp.databinding.FragmentQuoteDetailsBinding
import com.example.quotesapp.databinding.FragmentWelcomeBinding

class QuoteDetailsFragment : Fragment() {

    private lateinit var binding : FragmentQuoteDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuoteDetailsBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val author = arguments?.getString("Author")
        val quote = arguments?.getString("Quote")

        val textViewAuthor = view.findViewById<TextView>(R.id.Quote)
        val textViewQuote = view.findViewById<TextView>(R.id.Author)

        textViewQuote.setText(quote)
        textViewAuthor.setText(author)
    }
}