package com.example.giphlab.ui.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("gifUrl")
fun loadGifToImageView(imageView: ImageView, url: String){
    Glide.with(imageView.context)
        .load(url)
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
        .into(imageView)
}

@BindingAdapter("visibleGone")
fun visibleOrGone(view: View, visible: Boolean?){
    visible ?: return
    view.isVisible = visible
}