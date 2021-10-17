package com.kang.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // onCreate 앱이 최초 실행되면 수행
        super.onCreate(savedInstanceState)
        //R은 res를 의미  res > layout > activity_main 을 불러와 연결
        setContentView(R.layout.activity_main)

        tv_title.setText("강일빈 입니다") //텍스트 값 변경

    }
}