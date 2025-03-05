package com.example.quetek.util
import android.app.Activity
import android.widget.Toast

fun Activity.toast(msg: String): Unit {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}