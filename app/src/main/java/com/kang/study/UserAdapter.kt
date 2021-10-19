package com.kang.study

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UserAdapter(val context: Context, val UserList: ArrayList<User>) : BaseAdapter(){
    override fun getCount(): Int {
        return UserList.size
    }
    override fun getItem(position: Int): Any {
        return UserList[position]   //Array안에 있는 위치 만큼 getItem 가져오기
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, converView: View?, parent: ViewGroup?): View {
    //listView에서 view를 가지고왔을 때 어떻게 뿌려 줄거냐
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user, null)
        //LayoutInflater는 view를 붙 일 때 사용
        //list의 한 컬럼 당 item은 list_item_user 형식을 한다.

        val profile = view.findViewById<ImageView>(R.id.iv_list_profile)
        // view안의 ImageView 형식의 id가 iv_list_profile인 것을 찾는다
        val name = view.findViewById<TextView>(R.id.tv_name)
        val age = view.findViewById<TextView>(R.id.tv_age)
        val greet = view.findViewById<TextView>(R.id.tv_greet)

        val user = UserList[position]  //getView는 리스트 호출시 실행되며 posion은 현재 위치를 말한다 index 순서
        profile.setImageResource(user.profile) //User 클래스 profile 인자에 연결
        name.text = user.name
        age.text = user.age
        greet.text =user.greet

        return view
    }

}