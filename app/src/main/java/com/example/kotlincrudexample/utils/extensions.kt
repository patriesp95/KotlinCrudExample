package com.example.kotlincrudexample.utils

import android.view.View
import androidx.recyclerview.widget.DiffUtil

var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }