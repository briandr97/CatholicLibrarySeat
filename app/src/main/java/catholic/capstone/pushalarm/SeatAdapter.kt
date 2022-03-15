package catholic.capstone.pushalarm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import catholic.capstone.pushalarm.ContextExt.shortToast
import catholic.capstone.pushalarm.databinding.ItemSeatBinding


class SeatAdapter: RecyclerView.Adapter<SeatAdapter.MainViewHolder>() {

    val libSeat = mutableListOf<SeatData>()

    class MainViewHolder(val binding: ItemSeatBinding, val myContext: Context): RecyclerView.ViewHolder(binding.root){
        fun bind(data:SeatData){
            binding.seatModel = data
            itemView.setOnClickListener{
                if(binding.ivOn.visibility== View.GONE){
                    binding.ivOn.visibility= View.VISIBLE
                    myContext.shortToast("알림이 신청되었습니다.")
                }
                else{
                    binding.ivOn.visibility= View.GONE
                    myContext.shortToast("알림이 취소되었습니다. ")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
//        val binding : ItemMainBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_main, parent, false)
        val binding = ItemSeatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(libSeat[position])
    }

    override fun getItemCount(): Int {
        return libSeat.size
    }
}