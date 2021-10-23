package com.kang.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sub.*

class MainActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1 // 카메라 사진 촬영 요청 코드, 신호 값을 확인하기 위해 임의로 설정
    lateinit var  cuPhotoPath: String // 문자열 형태의 사진 정보 값
    //lateinit 은 초기 값을 null로 하고 싶을 때
    var UserList = arrayListOf<User>(
        User(R.drawable.android, "제이콥이네","29","안녕하세요."),
        User(R.drawable.android, "콥일까?","28","안녕하세요."),
        User(R.drawable.android, "콥이군","27","안녕하세요."),
        User(R.drawable.android, "콥이라니!","26","안녕하세요.")
    )
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
        btn_web.setOnClickListener {
            var intent = Intent(this, webActivity::class.java)
            startActivity(intent)
        }
        btn_toast.setOnClickListener {
            Toast.makeText(this@MainActivity, "버튼이 클릭 되었습니다.", Toast.LENGTH_SHORT).show()
            iv_list_profile.setImageResource(R.drawable.ic_launcher_foreground)  // 이미지 뷰에 새로운 이미지 등록
        }
        var item = arrayOf("사과","배","딸기","키위") // String 형태의 배열 선언
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,item)  // 리스트 뷰는 어댑터가 항상 연결되어있어야 사용 가능
        //context란 한 액티비티의 모든 정보를 담고있다.
        //simple_list_item_1이라는 레이아웃에 item 배열을 넣어 준다.
        val Adapter = UserAdapter(this,UserList)
        listView.adapter = Adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User //클릭한 인덱스 번호의 부모 객체
            //as User로 만들어 줬기 때문에 User model에 있는 인자를 불러올 수 있다.
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()

        }
        //저장된 데이터 로드
        loadData()


    }
    // edit text 저장된 값 불러오기
    private fun loadData() {
        val pref = getSharedPreferences("pref",0)
        et_id.setText(pref.getString("name",""))
    }

    override fun onDestroy() { // 앱이 종료되는 시점이 다가올 때 흐름
        super.onDestroy()

        saveData()
    }
    //edit text 저장
    private fun saveData() {
        val pref = getSharedPreferences("pref",0)
        val edit = pref.edit()  //수정 모드
        edit.putString("name", et_id.text.toString()) //첫 번째 인자에는 key값, 두 번재 인자에는 value
        edit.apply() // 저장
    }
}