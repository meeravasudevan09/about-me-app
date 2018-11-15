package com.example.meeravasudevan.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.meeravasudevan.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener {
            displayNickname(it)
        }
    }

    private fun displayNickname(view: View) {
        binding.apply {
            nicknameText.text = nicknameEdit.text

            nickname_text.visibility = View.VISIBLE
            nickname_edit.visibility = View.GONE
            done_button.visibility = View.GONE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
