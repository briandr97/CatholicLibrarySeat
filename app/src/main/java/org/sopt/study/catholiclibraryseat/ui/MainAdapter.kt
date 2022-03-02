package org.sopt.study.catholiclibraryseat.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.sopt.study.catholiclibraryseat.R
import org.sopt.study.catholiclibraryseat.data.entity.SeatData
import org.sopt.study.catholiclibraryseat.databinding.ItemMainBinding

class MainAdapter:RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    val libSeat = mutableListOf<SeatData>()

    class MainViewHolder(val binding:ItemMainBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data:SeatData){
            binding.seatModel = data
            itemView.setOnClickListener{
                when(binding.ivOn.visibility){
                    View.GONE->binding.ivOn.visibility=View.VISIBLE
                    View.VISIBLE->binding.ivOn.visibility=View.GONE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
//        val binding : ItemMainBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_main, parent, false)
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(libSeat[position])
    }

    override fun getItemCount(): Int {
        return libSeat.size
    }
}