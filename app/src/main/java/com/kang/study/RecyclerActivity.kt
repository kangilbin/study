package com.kang.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val profileList = arrayListOf(
            //리스트 형태긔 객체들을 넣어 준다.
            Profiles(R.drawable.man, "강일빈", 29, "안드로이드 앱 개발자"),
            Profiles(R.drawable.woman, "강이빈", 28, "웹 앱 개발자"),
            Profiles(R.drawable.man, "강삼빈", 27, "자바 앱 개발자"),
            Profiles(R.drawable.woman, "강사빈", 26, "앱웹 앱 개발자"),
            Profiles(R.drawable.man, "강오빈", 25, "코틀린 앱 개발자"),
            Profiles(R.drawable.woman, "강육빈", 24, "만능 앱 개발자"),
            Profiles(R.drawable.man, "강칠빈", 23, "쩌는 앱 개발자"),
            Profiles(R.drawable.woman, "강팔빈", 22, "개쩌는 앱 개발자"),
            Profiles(R.drawable.man, "강구빈", 21, "헤헤 앱 개발자"),
            Profiles(R.drawable.woman, "강십빈", 29, "호호 앱 개발자")
            )
            //레이아웃을 연결 RecyclerView에서 필수
            // VERTICAL -> 세로 방향 리스트, HORIZONTAL -> 가로 방향 리스트
        rv_profile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_profile.setHasFixedSize(true) // 리사이클 뷰의 성능 개선
        rv_profile.adapter = ProfileAdapter(profileList) // 위에서 선언한 리스트를 줌, 어댑터 연결 필수
    }
}