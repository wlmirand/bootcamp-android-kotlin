package br.org.venturus.venturusbootcamp.core.databinding

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

class BindingHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
