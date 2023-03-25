package com.example.kotlincrudexample.ui.viewmodel

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincrudexample.data.model.User
import com.example.kotlincrudexample.databinding.ItemRvUsuarioBinding

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    var users = mutableListOf<User>()

    @SuppressLint("NotifyDataSetChanged")
    fun setUserList(users: List<User>) {
        this.users = users.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemRvUsuarioBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

}