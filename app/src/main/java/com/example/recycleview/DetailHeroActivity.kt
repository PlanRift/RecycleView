package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.recycleview.databinding.ActivityDetailHeroBinding
import com.example.recycleview.model.dataHeroes

class DetailHeroActivity : AppCompatActivity() {


    private lateinit var binding: ActivityDetailHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hero)
        binding = ActivityDetailHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<dataHeroes>("DATA")
        Glide.with(this)
            .load(data?.image)
            .into(binding.imgProfile)

        binding.tvName.text = data?.name
        binding.tvDesc.text = data?.description
    }
}