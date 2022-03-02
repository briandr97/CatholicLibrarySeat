package org.sopt.study.catholiclibraryseat.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.sopt.study.catholiclibraryseat.data.entity.SeatData
import org.sopt.study.catholiclibraryseat.databinding.ActivityMain2Binding
import org.sopt.study.catholiclibraryseat.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        initAdapter()
        setContentView(binding.root)
    }

    fun initAdapter(){
        adapter = MainAdapter()
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