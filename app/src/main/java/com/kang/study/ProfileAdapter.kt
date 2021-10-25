package com.kang.study

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(val profileList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        //연결될 화면을 가져옴
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view).apply {
            //itemView는 CustomViewHolder 에 있는 인자를 의미한다.
            itemView.setOnClickListener {
                // adapterPosition : 클릭된 어댑터의 포지션(인덱스)
                val cusPos : Int =  adapterPosition
                val profile : Profiles = profileList.get(cusPos) // 객체 형태로 가져온다.
                Toast.makeText(parent.context, "이름 : ${profile.name} 나이 : ${profile.age}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        //실제적인 연결, 스크롤을 하거나 불러올 때 매칭을 시켜준다.
        holder.gender.setImageResource(profileList.get(position).gender)
        holder.name.text = profileList.get(position).name
        holder.age.text = profileList.get(position).age.toString() // 결과 값이 int이기 때문에 형변환
        holder.job.text = profileList.get(position).job
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        // findViewById -> 특정 xml에서 id값들을 찾아 올 수 있다.
        // findViewById< 가져올 id가있는 태그 >( 가져올 id)
        val gender = itemView.findViewById<ImageView>(R.id.iv_list_profile)
        val name = itemView.findViewById<TextView>(R.id.tv_prfile_name)
        val age = itemView.findViewById<TextView>(R.id.tv_prfile_age)
        val job = itemView.findViewById<TextView>(R.id.tv_prfile_job)

    }
}