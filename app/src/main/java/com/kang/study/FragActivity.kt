package com.kang.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_frag.*

class FragActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag)

        setFrag(0) //최초의 프레그먼트 실행
        btn_fragment1.setOnClickListener {
            setFrag(0)
        }
        btn_fragment2.setOnClickListener {
            setFrag(1)
        }
        btn_fragment3.setOnClickListener {
            setFrag(2)
        }
    }

    private fun setFrag(fragNum : Int) {
        //프레그먼트 교체
        val ft = supportFragmentManager.beginTransaction()
        when(fragNum)
        {
            0 -> {
                ft.replace(R.id.main_frag, Fragment1()).commit() //프레그먼트 조각들이 교체, 교체할 영역 불러온다.
            }
            1 -> {
                ft.replace(R.id.main_frag, Fragment2()).commit()
            }
            2 -> {
                ft.replace(R.id.main_frag, Fragment3()).commit()
            }
        }
    }
}