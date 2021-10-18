package com.kang.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sub.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // Aictivity가 최초 실행되면 수행
        super.onCreate(savedInstanceState)
        //R은 res를 의미  res > layout > activity_main 을 불러와 연결
        setContentView(R.layout.activity_main)

        btn_getText.setOnClickListener {    // 에딧 텍스트 값 가져와 뿌려주기
            var resultTest = et_id.text.toString() // 에딧 텍스으 값
            tv_title.setText(resultTest) //텍스트 값 변경
        }
        btn_a.setOnClickListener {
            // var : 값이 변경 가능
            // val : final 변수

            //다음 화면으로 이동하기 위한 intent 객체 생성
            var intent = Intent(this, SubActivity::class.java) //두번째 인자에 이동하과 싶은 activity
            intent.putExtra("msg", tv_title.text.toString()) //key : value 형식으로 intent에 정보를 담을 수 있다.
            //첫번째 인자가 key 두번째 인자가 실제로 넘겨 받는 value이다.

            startActivity(intent) // intent에 저장되어있는 액티비티로 이동
            finish()        //액티비티 파괴 뒤로가기해도 돌아올 수 없음 앱이 나가진다.
        }

        btn_toast.setOnClickListener {
            Toast.makeText(this@MainActivity, "버튼이 클릭 되었습니다.", Toast.LENGTH_SHORT).show()
            iv_profile.setImageResource(R.drawable.ic_launcher_foreground)  // 이미지 뷰에 새로운 이미지 등록
        }

    }
}