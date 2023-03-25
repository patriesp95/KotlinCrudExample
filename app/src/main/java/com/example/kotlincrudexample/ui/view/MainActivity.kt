package com.example.kotlincrudexample.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlincrudexample.data.model.User
import com.example.kotlincrudexample.data.model.UserProvider
import com.example.kotlincrudexample.databinding.ActivityMainBinding
import com.example.kotlincrudexample.databinding.ItemRvUsuarioBinding
import com.example.kotlincrudexample.ui.viewmodel.UserAdapter
import com.example.kotlincrudexample.ui.viewmodel.UserViewHolder
import com.example.kotlincrudexample.ui.viewmodel.UserViewModel
import com.example.kotlincrudexample.utils.visible

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val userViewModel : UserViewModel by viewModels()

    private val adapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        userViewModel.state.observe(this, ::updateUI)

    }

    private fun initRecyclerView(){
        val recyclerView = binding.rvUsuarios
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun updateUI(state: UserViewModel.UiState){
        binding.progress.visible = state.loading
        state.users?.let {
            adapter.setUserList(it)
        }
    }

}