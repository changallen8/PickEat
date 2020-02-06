package com.example.pickeat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        keyword_edit_text.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                go_button.isEnabled = !(s?.isEmpty()?:false)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

        go_button.setOnClickListener{
            if(keyword_edit_text.text.isNotEmpty()) {
                val input = keyword_edit_text.text.toString()
                val intent = Intent(this@MainActivity, ZomatoList::class.java)
                intent.putExtra("Input",input)
                startActivity(intent)
            }
        }
    }
}
