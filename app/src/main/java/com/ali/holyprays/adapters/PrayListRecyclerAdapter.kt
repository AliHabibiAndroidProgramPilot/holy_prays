package com.ali.holyprays.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ali.holyprays.databinding.PrayListRecyclerItemBinding

class PrayListRecyclerAdapter(private val prayList: ArrayList<String>) :
    Adapter<PrayListRecyclerAdapter.PrayListViewHolder>() {

    inner class PrayListViewHolder(
        private val binding: PrayListRecyclerItemBinding
    ) : ViewHolder(binding.root) {

        fun setData(prayName: String) {
            binding.txtPrayTitle.text = prayName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayListViewHolder =
        PrayListViewHolder(
            PrayListRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = prayList.size

    override fun onBindViewHolder(holder: PrayListViewHolder, position: Int) {
        holder.setData(prayList[position])
    }

}