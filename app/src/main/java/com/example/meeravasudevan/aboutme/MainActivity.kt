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

    // Binding object for MainActivity.
    // Name of the object is derived from the name of the activity or fragment.
    private lateinit var binding: ActivityMainBinding

    //    Instatiate data class
    private val name: AllNames = AllNames("Doctor Who")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setting the content view using DataBindingUtil creates an instance of
        // ActivityMainBinding from the supplied activity and the supplied layout. This object
        // contains mappings between the activity and layout,
        // and functionality to interact with them.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Set the value of the allNames variable that is declared and used in the layout file.
        binding.allNames = name

        // Click listener for the Done button
        binding.doneButton.setOnClickListener {
            displayNickname(it)
        }
    }

    /**
     * Click handler for the Done button.
     * Demonstrates how data binding can be used to make code much more readable
     * by eliminating calls to findViewById and changing data in the binding object.
     */
    private fun displayNickname(view: View) {
        binding.apply {
            allNames?.nickname = nickname_edit.text.toString()
            // Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()

            nickname_text.visibility = View.VISIBLE
            nickname_edit.visibility = View.GONE
            done_button.visibility = View.GONE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
