package com.example.wake_lockapp.Base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun <T> showtoast(text: T){
        Toast.makeText(this,text.toString(),Toast.LENGTH_SHORT).show()
    }

}