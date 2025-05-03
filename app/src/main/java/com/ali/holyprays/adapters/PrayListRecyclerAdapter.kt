package com.ali.holyprays.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ali.holyprays.databinding.PrayListRecyclerItemBinding
import com.ali.holyprays.provider.PrayDataModel

class PrayListRecyclerAdapter(private val prayList: List<PrayDataModel>) :
    Adapter<PrayListRecyclerAdapter.PrayListViewHolder>() {

    inner class PrayListViewHolder(
        private val binding: PrayListRecyclerItemBinding
    ) : ViewHolder(binding.root) {

        fun setData(pray: PrayDataModel) {
            binding.txtPrayTitle.text = pray.prayName
            if (pray.prayDetail != null) {
                binding.txtPrayDetail.visibility = View.VISIBLE
                binding.txtPrayDetail.text = pray.prayDetail
            }
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