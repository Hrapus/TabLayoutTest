package com.example.tablayouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tablayouttest.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private var fragList = listOf(
        Fragment1.newInstance(),
        Fragment2.newInstance(),
        Fragment3.newInstance()
    )

    private var fragListTitles = listOf(
        "Item 1",
        "Item 2",
        "Item 3"
    )
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = VpAdapter(this, fragList)
        binding.vp2.adapter = adapter

        TabLayoutMediator(binding.tb, binding.vp2){
            tab, pos ->tab.text = fragListTitles[pos]
        }.attach()
    }
}