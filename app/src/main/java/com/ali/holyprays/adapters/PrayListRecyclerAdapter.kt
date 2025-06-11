package com.ali.holyprays.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ali.holyprays.databinding.PrayListRecyclerItemBinding
import com.ali.holyprays.databinding.PrayListRecyclerItemSecondBinding
import com.ali.holyprays.provider.PrayDataModel
import com.ali.holyprays.ui.PrayTextActivity

class PrayListRecyclerAdapter(
    private val prayList: List<PrayDataModel>,
    private val context: Context
) :
    Adapter<PrayListRecyclerAdapter.PrayListViewHolder>() {

    inner class PrayListViewHolder(
        private val binding: PrayListRecyclerItemSecondBinding
    ) : ViewHolder(binding.root) {

        fun setData(pray: PrayDataModel) {
            binding.txtPrayTitle.text = pray.prayName
            val intent = Intent(context, PrayTextActivity::class.java).apply {
                putExtra("PRAY_EXTRA", pray)
            }
            val clickListener = View.OnClickListener {
                context.startActivity(intent)
            }
            binding.mainBack.setOnClickListener(clickListener)
            binding.txtPrayTitle.setOnClickListener(clickListener)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayListViewHolder =
        /*PrayListViewHolder(
            PrayListRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )*/
        PrayListViewHolder(
            PrayListRecyclerItemSecondBinding.inflate(
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