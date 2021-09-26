package com.example.bookthehsrp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.bookthehsrp.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class HomeFragment : Fragment() {
    var sampleImages = intArrayOf(
        R.drawable.auto,
        R.drawable.bike,
        R.drawable.car
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view =  inflater.inflate(R.layout.home_fragment, container, false)
        val carouselView = view.findViewById<CarouselView>(R.id.carouselView)
        carouselView.pageCount = sampleImages.size
        carouselView.setImageListener(imageListener)

        val button: Button = view.findViewById(R.id.button_apply)
        button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment2_to_registrationFragment)
        }
        return view
    }

    private var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            imageView.setImageResource(sampleImages[position])
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        }
    }
}