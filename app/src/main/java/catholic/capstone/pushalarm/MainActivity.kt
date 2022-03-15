package catholic.capstone.pushalarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import catholic.capstone.pushalarm.MyFirebaseMessagingService.Companion.getDeviceToken
import catholic.capstone.pushalarm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : SeatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initAdapter()
        binding.layoutTop.setOnClickListener{
            Log.d("touchlog", "클릭됐다")
            getDeviceToken()
        }
        setContentView(binding.root)
    }

    fun initAdapter(){
        adapter = SeatAdapter()
        binding.rvMain.adapter = adapter
        binding.rvMain.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        adapter.libSeat.addAll(
            listOf(
                SeatData("자유열람실A 노트북", 80, 37),
                SeatData("자유열람실A 칸막이", 80, 40),
                SeatData("자유열람실B 노트북", 75, 12),
                SeatData("자유열람실B 칸막이", 75, 30),
                SeatData("자유열람실C 노트북", 80, 22),
                SeatData("자유열람실C 칸막이", 80, 37)
            )
        )
    }
}