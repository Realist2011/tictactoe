package com.example.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val name = intent.getStringExtra(key1)
        val age = intent.getIntExtra(key2,0)
        val isStudent = intent.getBooleanExtra(key3,false)
        //textview.text = "$name $age $isStudent"
    }
}