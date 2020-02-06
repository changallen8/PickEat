package com.example.pickeat

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

        if (input != null) {

            supportActionBar?.title = "Search results for $input"

            zomatoViewModel = ViewModelProviders.of(this).get(ZomatoViewModel::class.java)

            zomatoViewModel.attemptToGet(input)

            recycler_view.setHasFixedSize(true)
            recycler_view.layoutManager = GridLayoutManager(this, 1)

            val zomatoAdapter = ZomatoAdapter(listOf())

            recycler_view.adapter = zomatoAdapter

            zomatoViewModel.zomatoResponse.observe(this, Observer { zomato ->
                progressBar.visibility= View.INVISIBLE
                recycler_view.visibility= View.VISIBLE
                zomatoAdapter.loadNewData(zomato.restaurants)
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