package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.example.movieapp.databinding.ActivityDetailBinding


class Detail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var movieName: String
    private lateinit var movieGenre: String
    private lateinit var movieRating: String
    private var position: Int = 0
    private var movieLiked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.movieNameDetail.text = intent.getStringExtra("movieName")
        this.movieName = intent.getStringExtra("movieName")!!
        binding.movieDescriptionDetail.text = intent.getStringExtra("movieDescription")
        binding.movieImageDetail.setImageResource(intent.getIntExtra("imageId", R.drawable.about_icon))
        binding.movieGenreDetail.text = intent.getStringExtra("movieGenre")
        this.movieGenre = intent.getStringExtra("movieGenre")!!
        binding.movieRatingDetail.text = intent.getStringExtra("movieRating")
        this.movieRating = intent.getStringExtra("movieRating")!!
        this.movieLiked = intent.getBooleanExtra("movieLiked", false)

        if(this.movieLiked){
            binding.movieLikedDetail.text = "Unlike"
        }
        this.position = intent.getIntExtra("position", 0)
    }

    fun shareMovie(view: View){
        val txt = "Title: " + this.movieName + ". Genre: " + this.movieGenre + ". Rating: " + movieRating
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle("Share this movie with: ")
            .setText(txt)
            .startChooser()
    }

    fun likeOrUnlikeMovie(view: View){
        MainActivity.movieLikes[this.position] = !this.movieLiked
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}