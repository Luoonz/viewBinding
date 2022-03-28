package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

//class MainActivity : AppCompatActivity() {
//// 전역 변수로 바인딩 객체 선언
//    private var mBinding: ActivityMainBinding? = null
//    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
//    private val binding get() = mBinding!!
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        // 기존 setContentView 를 제거해주시고..
//        // setContentView(R.layout.activity_main)
//        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
//        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
//        mBinding = ActivityMainBinding.inflate(layoutInflater)
//        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의 // 인스턴스를 활용하여 생성된 뷰를 액티비티에 표시 합니다.
//        setContentView(binding.root)
//        // 이제부터 binding 바인딩 변수를 활용하여 마음 껏 xml 파일 내의 뷰 id 접근이 가능해집니다.
//        // 뷰 id도 파스칼케이스 + 카멜케이스의 네이밍규칙 적용으로 인해서 tv_message -> tvMessage 로 자동 변환 되었습니다.
//        binding.tvMessage.setText("안녕하세요 반갑습니다.")
//        binding.tvv.setText("가즈아아아아아")
//    }
//
//    // 액티비티가 파괴될 때..
//    override fun onDestroy() {
//    // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
//        mBinding = null
//        super.onDestroy()
//    }
//}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //자동 생성됨 (뷰바인딩 사용하면 이렇게됨)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //첫화면 표시
        binding = ActivityMainBinding.inflate(layoutInflater) //클래스 객체화
        val view = binding.root //객체화한 뷰
        setContentView(view) // 뷰를 메모리상으로 올림(화면 표시)

        binding.btnMain.setOnClickListener{ //클릭 이벤트 리스너
            var intent= Intent(this, SecondActivity::class.java) //인텐트 정의 (현재, 목적지)
            intent.putExtra("data",binding.edtMain.text.toString()) //인텐트에 데이터를 저장 (키-값 쌍)
            startActivity(intent) //목적지 액티비티에 인텐트 전달
        }
    }

}

