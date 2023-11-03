package com.example.internship.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.internship.databinding.ActivityMainBinding
import com.example.internship.presentation.cameras.CameraFragment
import com.example.internship.presentation.doors.DoorFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val fragmentList = listOf<Fragment>(
        CameraFragment(),
        DoorFragment()
    )

    private val fragmentListTitle = listOf<String>(
        "Камеры",
        "Двери"
    )

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vpAdapter = VPAdapter(this, fragmentList)
        binding.viewPager.adapter = vpAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){
            tab, pos -> tab.text = fragmentListTitle[pos]
        }.attach()

    }
}