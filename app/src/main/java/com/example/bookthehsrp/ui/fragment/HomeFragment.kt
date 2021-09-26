package com.example.bookthehsrp.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.bookthehsrp.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class HomeFragment : Fragment(R.layout.home_fragment) {
    var sampleImages = intArrayOf(
        R.drawable.auto,
        R.drawable.bike,
        R.drawable.car
    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val carouselView = view.findViewById<CarouselView>(R.id.carouselView)
        carouselView.pageCount = sampleImages.size
        carouselView.setImageListener(imageListener)
    }

    private var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            imageView.setImageResource(sampleImages[position])
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        }
    }
}