package com.example.pickeat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*keyword_edit_text.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                go_button.isEnabled = !(s?.isEmpty()?:false)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })*/

        val cuisines = resources.getStringArray(R.array.Cuisines)

        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, cuisines
            )
            spinner.adapter = adapter
        }

        go_button.setOnClickListener{
            //if(keyword_edit_text.text.isNotEmpty()) {
                //val input = keyword_edit_text.text.toString()

                val cuisine = spinner.selectedItem.toString()

                val intent = Intent(this@MainActivity, ZomatoList::class.java)
                //intent.putExtra("Input",input)
                intent.putExtra("Cuisine", cuisine)
                startActivity(intent)
           // }
        }
    }
}
