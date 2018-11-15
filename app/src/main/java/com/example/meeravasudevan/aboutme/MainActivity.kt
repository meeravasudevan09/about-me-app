package com.example.meeravasudevan.aboutme

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import com.example.meeravasudevan.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var editNickname: TextView
    lateinit var nickname: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doneButton: Button = findViewById(R.id.done_button)
        doneButton.setOnClickListener {
            displayNickname(it)
        }

        editNickname = findViewById(R.id.nickname_edit)
        nickname = findViewById(R.id.nickname_text)
    }

    private fun displayNickname(view: View) {
        nickname.text = editNickname.text

        nickname.visibility = View.VISIBLE
        editNickname.visibility = View.GONE
        view.visibility = View.GONE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
