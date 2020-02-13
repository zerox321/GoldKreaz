package com.eslam.goldkreaz.binding

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.eslam.goldkreaz.R

@BindingAdapter("bindingPostUrl")
fun bindingPostUrl(imageView: ImageView, path: String?) {
  path?.let {
    Glide.with(imageView.context)
      .load(it)
      .error(ContextCompat.getDrawable(imageView.context, R.mipmap.ic_launcher))
      .into(imageView)
  }
}




