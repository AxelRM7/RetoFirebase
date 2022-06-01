package com.example.cartelera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.cartelera.databinding.ItemMovieBinding
import org.json.JSONArray
import org.json.JSONObject
import java.text.FieldPosition

class MainAdapter(private val movies: JSONArray): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int){
        if(movies[position].toString()!="null") {
            holder.render(movies[position] as JSONObject)
        }
    }

    override fun getItemCount(): Int = movies.length()
    class MainHolder(val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root){
        fun render(movie: JSONObject){
            binding.TVTitle.setText(movie.getString("title"))
            binding.TVYear.setText(movie.getString("year"))
        }
    }
}