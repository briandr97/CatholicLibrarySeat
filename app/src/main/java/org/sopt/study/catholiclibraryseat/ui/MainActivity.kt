package org.sopt.study.catholiclibraryseat.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import org.sopt.study.catholiclibraryseat.R
import org.sopt.study.catholiclibraryseat.data.entity.SeatData
import org.sopt.study.catholiclibraryseat.databinding.ActivityMainBinding
import org.sopt.study.catholiclibraryseat.util.ContextExt.shortToast

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var notebook : Boolean = false
    private var normal : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainLog", "메인 액티비티 온크리에이트 진입")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MainLog", "메인 액티비티 바인딩 및 인플레이트 완료")
        binding.tvSeatNotebook.text = "37"
        binding.tvSeatNormal.text="120"
        Log.d("MainLog2", "데이터 삽입 완료")

        binding.btnNotebookApply.setOnClickListener{
            when(notebook){
                false->this.shortToast("노트북좌석 알림신청 되었습니다")
                true->this.shortToast("이미 알림신청 상태입니다")
            }
            notebook=true
        }
        binding.btnNotebookCancle.setOnClickListener{
            when(notebook){
                true->this.shortToast("노트북좌석 알림해제 되었습니다")
                false->this.shortToast("이미 알림해제 상태입니다")
            }
            notebook=false
        }
        binding.btnNormalApply.setOnClickListener{
            when(normal){
                false->this.shortToast("칸막이좌석 알림신청 되었습니다")
                true->this.shortToast("이미 알림신청 상태입니다")
            }
            normal=true
        }
        binding.btnNormalCancle.setOnClickListener{
            when(normal){
                true->this.shortToast("칸막이좌석 알림해제 되었습니다")
                false->this.shortToast("이미 알림해제 상태입니다")
            }
            normal=false
        }
    }
}