package com.example.sourcetreeexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        print("something stupid")
        print("and something stupid from branch 1")
        print("something stupid from main branch")
        print("and something stupid from branch 1")
    }
}