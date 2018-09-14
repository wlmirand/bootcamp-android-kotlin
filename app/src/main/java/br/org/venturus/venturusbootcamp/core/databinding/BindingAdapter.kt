package br.org.venturus.venturusbootcamp.core.databinding

import android.databinding.BindingAdapter
import android.widget.ImageView
import br.org.venturus.venturusbootcamp.core.view.GlideApp
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("src")
fun setPictureUrl(imageView: ImageView, urlString: String?) = urlString?.let {
    GlideApp.with(imageView.context)
        .load(it)
        .apply(RequestOptions.circleCropTransform())
        .into(imageView)
}

@BindingAdapter("src")
fun setResourceId(imageView: ImageView, resourceId: Int?) =
    resourceId?.let { imageView.setImageResource(it) }
