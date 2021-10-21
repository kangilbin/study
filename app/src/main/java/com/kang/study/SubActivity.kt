package com.kang.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        if(intent.hasExtra("msg")){
            tv_getMsg.text = intent.getStringExtra("msg")
        }

        btn_navi.setOnClickListener {
            layout_drawer.openDrawer(GravityCompat.START) // STRAT -> LEFT, END -> RIGHT
        }
        naviView.setNavigationItemSelectedListener(this) // 네비게이션 메뉴 아이템에 클릭 속성 부여
        //이게 있어야 onNavigationItemSelected 함수가 실행 가능
    }
    //네이게이션 메뉴 아이템 클릭 시 수행
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId)  //레이아웃에서 선언한 아이템의 id
        {
            R.id.access -> Toast.makeText(applicationContext, "접근성", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext, "이메일", Toast.LENGTH_SHORT).show()
            R.id.message -> Toast.makeText(applicationContext, "메세지", Toast.LENGTH_SHORT).show()
        }
        layout_drawer.closeDrawers() //네비게이션 뷰 닫기
        return false
    }

    override fun onBackPressed() { //  back 버튼 클릭 이벤트
        if(layout_drawer.isDrawerOpen(GravityCompat.START)){
            layout_drawer.closeDrawers()
        } else {
            super.onBackPressed()   //앱 닫기
        }

    }
}