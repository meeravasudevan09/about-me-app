package com.example.meeravasudevan.aboutme

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var editNickname: TextView
    lateinit var nickname: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val doneButton: Button = findViewById(R.id.done_button)
        editNickname = findViewById(R.id.nickname_edit)
        nickname = findViewById(R.id.nickname_text)

        doneButton.setOnClickListener {
            displayNickname(it)
        }
    }

    private fun displayNickname(view: View) {
        nickname.text = editNickname.text

        nickname.visibility = View.VISIBLE
        editNickname.visibility = View.GONE
        view.visibility = View.GONE
    }
}
