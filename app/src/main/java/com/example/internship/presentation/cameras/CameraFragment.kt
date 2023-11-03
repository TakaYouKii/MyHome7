package com.example.internship.presentation.cameras

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.internship.R
import com.example.internship.databinding.FragmentCameraBinding
import com.example.internship.models.Camera
import com.example.internship.models.Door
import com.example.internship.presentation.doors.DoorAdapter
import com.example.myapplication.utils.SwipeItem


class CameraFragment : Fragment() {

    private val camerasList = arrayListOf<Camera>(
        Camera("Camera 1",  R.drawable.doors),
        Camera("Camera 2",  R.drawable.doors),
        Camera("Camera 3",  R.drawable.doors),
        Camera("Camera 4",  R.drawable.doors),
        Camera("Camera 5",  R.drawable.doors),
    )
    private var adapter = CameraAdapter(camerasList)
    private lateinit var binding: FragmentCameraBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCameraBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCameras.adapter = adapter

        binding.swipeRefreshLayout.setOnRefreshListener {
            Handler().postDelayed({
                binding.swipeRefreshLayout.isRefreshing = false
            }, 2000)
        }
        val itemTouchHelper = ItemTouchHelper(object : SwipeItem(binding.rvCameras) {
            override fun instantiateUnderlayButton(position: Int): List<Button> {
                val favoritesButton = favoritesButton()

                return listOf(favoritesButton)
            }
        })
        itemTouchHelper.attachToRecyclerView(binding.rvCameras)
    }


    private fun favoritesButton(): SwipeItem.Button {
        return SwipeItem.Button(
            requireContext(),
            "Fav",
            20f,
            R.drawable.ic_star,
        )
    }

}