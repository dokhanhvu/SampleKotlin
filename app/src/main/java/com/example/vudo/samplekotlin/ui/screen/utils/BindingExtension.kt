package com.example.vudo.samplekotlin.ui.screen.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by vu.do on 4/24/2018.
 */
@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String) {
    val context = this.context
    Glide.with(context).load(url).into(this)
}