package com.example.internship.presentation.doors// Импортируемый необходимый в зависимости от
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.internship.R
import com.example.internship.databinding.FragmentDoorBinding
import com.example.internship.models.Door
import com.example.myapplication.utils.SwipeItem


class DoorFragment : Fragment() {

    private val doorList = arrayListOf<Door>(
        Door("Подьезд 1", R.drawable.doors),
        Door("Вход на пожарную лестницу", R.drawable.doors),
        Door("Подьезд 2", R.drawable.doors),
        Door("Домофон", R.drawable.doors),
    )
    private var adapter = DoorAdapter(doorList)

    private lateinit var binding: FragmentDoorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoorBinding.inflate(layoutInflater)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvDoors.adapter = adapter
        binding.swipeRefreshLayout.setOnRefreshListener {
            Handler().postDelayed({
                binding.swipeRefreshLayout.isRefreshing = false
            }, 2000)
        }
        val itemTouchHelper = ItemTouchHelper(object : SwipeItem(binding.rvDoors) {
            override fun instantiateUnderlayButton(position: Int): List<Button> {
                val favoritesButton = favoritesButton()
                val editButton = editButton()
                return listOf(editButton, favoritesButton)
            }
        })
        itemTouchHelper.attachToRecyclerView(binding.rvDoors)
    }

    private fun favoritesButton(): SwipeItem.Button {
        return SwipeItem.Button(
            requireContext(),
            "Fav",
            20f,
            R.drawable.ic_star,
        )
    }


    private fun editButton(): SwipeItem.Button {
        return SwipeItem.Button(
            requireContext(),
            "Fav",
            20f,
            R.drawable.ic_edit,
        )
    }



}
