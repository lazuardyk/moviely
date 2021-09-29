package com.example.movieapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListViewAdapter (private val context: Activity, private val arrayList: ArrayList<Movie>) : ArrayAdapter<Movie>(context, R.layout.list_movie, arrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_movie, null)

        val movieImage: ImageView = view.findViewById(R.id.movie_image)
        val movieName: TextView = view.findViewById(R.id.movie_name)
        val movieGenre: TextView = view.findViewById(R.id.movie_genre)
        val movieRating: TextView = view.findViewById(R.id.movie_rating)
        val movieLiked: ImageView = view.findViewById(R.id.movie_liked)

        movieImage.setImageResource(arrayList[position].imageId)
        movieName.text = arrayList[position].name
        movieGenre.text = arrayList[position].genre
        movieRating.text = arrayList[position].rating

        if(arrayList[position].liked){
            movieLiked.setImageResource(R.drawable.heart_icon)
        }

        return view
    }
}