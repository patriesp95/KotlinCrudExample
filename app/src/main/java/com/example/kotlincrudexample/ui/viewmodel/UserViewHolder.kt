package com.example.kotlincrudexample.ui.viewmodel

import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincrudexample.data.model.User
import com.example.kotlincrudexample.databinding.ItemRvUsuarioBinding

class UserViewHolder(private val binding: ItemRvUsuarioBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(user: User){
        binding.tvIdUsuario.text = user.id.toString()
        binding.tvNombre.text = user.name
        binding.tvEmail.text = user.email
    }
}