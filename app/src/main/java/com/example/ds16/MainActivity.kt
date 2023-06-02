package com.example.ds16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ds16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.pok_001,
        R.drawable.pok_002,
        R.drawable.pok_003,
        R.drawable.pok_004,
        R.drawable.pok_005,
        R.drawable.pok_006,
        R.drawable.pok_007
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager (this@MainActivity, 3)
            rcView.adapter = adapter
            btnAdd.setOnClickListener {
                if (index > 6) index = 0
                var plant = Plant(imageIdList[index], "Pokemon $index")
                adapter.addPlant(plant)
                index++
            }
        }
    }
}