package com.ali.holyprays.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ali.holyprays.databinding.PrayTextRecyclerItemBinding

class PrayTextRecyclerAdapter(
    private val arabicTextList: List<String>,
    private val persianTextList: List<String>,
) : Adapter<PrayTextRecyclerAdapter.PrayTextViewHolder>() {

    inner class PrayTextViewHolder(private val binding: PrayTextRecyclerItemBinding) :
        ViewHolder(binding.root) {

        fun setData(arabicText: String, persianText: String) {
            binding.txtPrayArabic.text = arabicText
            binding.txtPrayTranslationPersian.text = persianText
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayTextViewHolder =
        PrayTextViewHolder(
            PrayTextRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = arabicTextList.size

    override fun onBindViewHolder(holder: PrayTextViewHolder, position: Int) {
        holder.setData(arabicTextList[position], persianTextList[position])
    }

}