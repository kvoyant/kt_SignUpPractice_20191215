package com.yhkim.kt_signuppractice_20191215

import android.os.Bundle

//SignUpActivity 로 이름 변경 shift + F6 (mac shift + fn + F6)
class SignUpActivity : BaseActivity() {

    var lastBack01 = 0L//변수도 리팩토링 가능 (shift + F6 (mac shift + fn + F6))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)//activity_sign_up 로 이름 변경 shift + F6 (mac shift + fn + F6)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        lastBack01 = 10L
    }

    override fun setValues() {
        lastBack01 = 20L
    }

}
