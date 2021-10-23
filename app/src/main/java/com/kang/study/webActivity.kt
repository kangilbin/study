package com.kang.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class webActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //웹 이랑 앱은 다르기 때문에 셋팅이 필요
        //웹뷰 안에서 자바스크립트를 사용하면 허용
        webView.settings.javaScriptEnabled = true // 자바스크립트 허용
        /**
         * 웹뷰에서 새 창이 뜨지 않도록 방지
         */
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        /////// 2개는 거의 필수///

        webView.loadUrl("https://www.naver.com") // 링크 주소 laod







    }
    // back 버튼 이벤튼
    override fun onBackPressed() {
        if(webView.canGoBack()){
            //웹사이트에서 뒤로갈 페이지가 존재 한다면 수행
            webView.goBack() // 웹사이트 뒤로가기

        } else {
            super.onBackPressed() // 본래의 백버튼 수행(안드로이드)
        }
    }
}