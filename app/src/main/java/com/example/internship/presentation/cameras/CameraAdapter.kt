package com.example.internship.presentation.cameras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.internship.databinding.ItemsCameraBinding
import com.example.internship.models.Camera
import com.example.internship.models.Door

class CameraAdapter(private val cameraList: ArrayList<Camera>) :
    RecyclerView.Adapter<CameraAdapter.CameraViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
        return CameraViewHolder(
            ItemsCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return cameraList.size
    }

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.bind(cameraList[position])
    }

    inner class CameraViewHolder(private val binding: ItemsCameraBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(camera: Camera) {
            binding.tvCameraNumber.text = camera.title
            binding.imgCamera.load(camera.image)

        }
    }
}