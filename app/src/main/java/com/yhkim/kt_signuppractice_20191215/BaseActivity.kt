package com.yhkim.kt_signuppractice_20191215

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    val mContext = this

    abstract fun setupEvents()
    abstract fun setValues()
}