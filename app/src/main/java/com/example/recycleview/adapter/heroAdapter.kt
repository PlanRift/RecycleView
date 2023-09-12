package com.example.recycleview.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycleview.DetailHeroActivity
import com.example.recycleview.databinding.ItemViewBinding
import com.example.recycleview.model.dataHeroes

class heroAdapter(val listHero: ArrayList<dataHeroes>) :
    RecyclerView.Adapter<heroAdapter.ListViewHolder>() {

    class ListViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]

        Glide.with(holder.itemView.context)
            .load(hero.image)
            .into(holder.binding.imageProfile)

        holder.binding.tvName.text = hero.name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailHeroActivity::class.java)
            intent.putExtra("DATA", hero)
            holder.itemView.context.startActivity(intent)
        }


    }
}