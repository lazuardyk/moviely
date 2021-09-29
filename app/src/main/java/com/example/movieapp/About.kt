package com.example.movieapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    fun openFacebook(view: View){
        openWebsite("https://facebook.com/lazuardyk")
    }

    fun openTwitter(view: View){
        openWebsite("https://twitter.com/lazuardyk")
    }

    fun openGithub(view: View){
        openWebsite("https://github.com/lazuardyk")
    }

    fun openLinkedin(view: View){
        openWebsite("https://www.linkedin.com/in/lazuardyk/")
    }

    fun openWebsite(url: String){
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent);
    }
}