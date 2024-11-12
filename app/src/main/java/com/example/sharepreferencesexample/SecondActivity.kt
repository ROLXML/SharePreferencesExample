package com.example.sharepreferencesexample

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharepreferencesexample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    @SuppressLint("SetTextI18n")
    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding . inflate (layoutInflater)
        setContentView (binding.root)
        binding . btnLoad . setOnClickListener {
            val filename = "$packageName-$ {MainActivity.RPL}"
            val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)
            val firstName = pref.getString("firstName", "")
            val lastName =
                pref.getString("lastName", "")
            binding . tvOutput . text = "$firstName $lastName "
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        binding . tvOutput . text = "Click Button Load Data"
    }
}