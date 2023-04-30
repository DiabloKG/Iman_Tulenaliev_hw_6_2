package com.example.iman_tulenaliev_hw_6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.iman_tulenaliev_hw_6_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var selectedAdapter: SelectedAdapter
    private var selectedImage = arrayListOf<ImageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        initViews()
    }

    private fun getData() {
        selectedImage = intent.getParcelableArrayListExtra(EditActivity.AppConstant.SELECTED_LIST)!!
    }

    private fun initViews() {
        selectedAdapter = SelectedAdapter(selectedImage)
        binding.rvMain.layoutManager = GridLayoutManager(this, 3)
        binding.rvMain.adapter = selectedAdapter
    }
}