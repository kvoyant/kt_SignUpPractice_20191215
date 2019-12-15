package com.yhkim.kt_signuppractice_20191215

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_sign_up.*

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

//        pwEdt.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                Log.d("입력된값", s.toString())
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                Log.d("입력된값", s.toString())
//            }
//        })

        birthDayTxt.setOnClickListener {
            Toast.makeText(mContext, "생일 지정 텍스트뷰 클릭", Toast.LENGTH_SHORT).show()
        }

        pwEdt.addTextChangedListener {

            Log.d("입력된값", it.toString())
            //결과가 it으로 들어온다
            val inputStr = it.toString()

            if(inputStr.length == 0) {
                pwStatusTxt.text = "비밀번호가 입력되지 않았습니다."
                pwStatusTxt.setTextColor(Color.RED)
            }
            else if (inputStr.length < 8) {
                pwStatusTxt.text = "입력된 비번이 너무 짧습니다."
                pwStatusTxt.setTextColor(Color.parseColor("#FDA0EF"))
            }
            else {
                pwStatusTxt.text = "사용해도 좋은 비밀번호 입니다."
                pwStatusTxt.setTextColor(Color.GREEN)
            }
        }
    }

    override fun setValues() {
    }

}
