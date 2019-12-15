package com.yhkim.kt_signuppractice_20191215

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.text.SimpleDateFormat
import java.util.*

//SignUpActivity 로 이름 변경 shift + F6 (mac shift + fn + F6)
class SignUpActivity : BaseActivity() {

    var lastBack01 = 0L//변수도 리팩토링 가능 (shift + F6 (mac shift + fn + F6))

    var selectedBirthDay:Calendar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)//activity_sign_up 로 이름 변경 shift + F6 (mac shift + fn + F6)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        jobSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?
                ,view: View?
                ,position: Int
                ,id: Long
            ) {
                if(position != 0) {
                    Toast.makeText(mContext, jobSpinner.selectedItem.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }


        birthTimeTxt.setOnClickListener {
            val timePickerDialog = TimePickerDialog(mContext, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->

                selectedBirthDay?.set(Calendar.HOUR_OF_DAY, hourOfDay)
                selectedBirthDay?.set(Calendar.MINUTE, minute)

//                캘린더에 저장된 값을 SimpleDateFormat 이용해 화면출력
                val sdf = SimpleDateFormat("a h:mm")//H:mm(24시간 단위)
                birthTimeTxt.text = sdf.format(selectedBirthDay?.time)

            }, 20, 5, false)//true
            timePickerDialog.show()
        }

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
//            Toast.makeText(mContext, "생일 지정 텍스트뷰 클릭", Toast.LENGTH_SHORT).show()
            val datePickerDialog = DatePickerDialog(mContext, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

//                자바에서는 월을 0 ~ 11월로 사용함. 생각하는것보다 1 작은 숫자를 월로 넣어 줘야 함
//                Calendar 클래스의 변수를 활용해서 월을 입력하면 보기에 직관적.

                val selectedDateStr = "${year} / ${month} / ${dayOfMonth}"
                birthDayTxt.text = selectedDateStr

                selectedBirthDay?.let {
                    //null 이 아니
                    Log.d("생년월일선택", "이미 선택된 값을 수정 - 다시 선택")
                }.let {
                    //null 이면
                    Log.d("생년월일선택", "이미 선택된 값이 새로 생김 - 처음 선택")
                    selectedBirthDay = Calendar.getInstance()
//                    Q.selectedBirthDay에 담긴 날짜는 몇월 몇일? 2019년 12월 15일
//                    이 담긴 날짜를 => 선택한 년/월/일로 대입.
                }

                selectedBirthDay?.set(Calendar.YEAR, year)//? null 이 아닐때 세팅
                selectedBirthDay?.set(Calendar.MONTH, month)
                selectedBirthDay?.set(Calendar.DAY_OF_MONTH, dayOfMonth)

//                selectedBirthDay?.set(year, month, dayOfMonth) //한줄로 다 실행

//                저장된 생년월일을 SimpleDateFormat을 이욯해 출력
                val sdf = SimpleDateFormat("yyyy년 MM월 d일 (E)") //E 요일
                birthDayTxt.text = sdf.format(selectedBirthDay?.time)


            }, 2019, Calendar.DECEMBER, 15)

            datePickerDialog.show()
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
