package com.example.internship.presentation.doors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.internship.R
import com.example.internship.databinding.ItemsDoorBinding
import com.example.internship.models.Door

class DoorAdapter(private val doorList: ArrayList<Door> ): RecyclerView.Adapter<DoorAdapter.DoorViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorViewHolder {
        return DoorViewHolder(ItemsDoorBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return doorList.size
    }

    override fun onBindViewHolder(holder: DoorViewHolder, position: Int) {
        holder.bind(doorList[position])
    }

    inner class DoorViewHolder(private val binding: ItemsDoorBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(door: Door){
            binding.tvTitle.text = door.title
            binding.imgDoor.load(door.image)
            itemView.setOnClickListener {
                if(binding.imgDoor.visibility== View.GONE){
                    binding.imgDoor.visibility=View.VISIBLE
                }
                else{
                    binding.imgDoor.visibility=View.GONE
                }
            }
        }
    }
}