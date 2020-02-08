package com.example.pickeat

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pickeat.R
import kotlinx.android.synthetic.main.activity_rest_list.*


class ZomatoList : AppCompatActivity(){

    private lateinit var zomatoViewModel: ZomatoViewModel


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest_list)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val input: String? = intent.getStringExtra("Input")

        var cuisine: String? = intent.getStringExtra("Cuisine")

        when(cuisine){
            "N/A" -> cuisine = ""
            "American" -> cuisine = "1"
            "Pizza" -> cuisine = "82"
            "Chinese" -> cuisine = "25"
            "Sandwich" -> cuisine = "304"
            "Italian" -> cuisine = "55"
            "Fast Food" -> cuisine = "40"
            "Bar Food" -> cuisine = "227"
            "Desserts" -> cuisine = "100"
            "Mexican" -> cuisine = "73"
            "Japanese" -> cuisine = "60"
            "Asian" -> cuisine = "3"
        }


        if (input != null && cuisine!=null) {

            supportActionBar?.title = "Best Restaurant for $input"

            zomatoViewModel = ViewModelProviders.of(this).get(ZomatoViewModel::class.java)

            zomatoViewModel.attemptToGet(cuisine)




            zomatoViewModel.zomatoResponse.observe(this, Observer { zomato ->

                progressBar.visibility= View.INVISIBLE
                text_view_link.visibility=View.VISIBLE
                text_view_rest.visibility=View.VISIBLE

                val random = (0..(zomato.results_shown - 1)).shuffled().first()

                text_view_rest.text = zomato.restaurants[random].restaurant.name

                var link = zomato.restaurants[random].restaurant.url

                text_view_link.setOnClickListener{
                    val openURL = Intent(Intent.ACTION_VIEW)
                    openURL.data = Uri.parse("$link")
                    startActivity(openURL)
                }
            })

            zomatoViewModel.error.observe(this, Observer { error ->
                if (error == true) {
                    Toast.makeText(this, "Error getting Restaurants", Toast.LENGTH_LONG).show()
                    zomatoViewModel.error.value = false
                }
            })
        }
    }

}