package com.ali.holyprays.adapters

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ali.holyprays.R
import com.ali.holyprays.databinding.PrayTextRecyclerItemBinding
import com.ali.holyprays.provider.CustomTypeFace
import com.ali.holyprays.provider.PrayCategories

class PrayTextRecyclerAdapter(
    private val arabicTextList: List<String>,
    private val persianTextList: List<String>,
    private val category: PrayCategories?
) : Adapter<PrayTextRecyclerAdapter.PrayTextViewHolder>() {

    inner class PrayTextViewHolder(private val binding: PrayTextRecyclerItemBinding) :
        ViewHolder(binding.root) {

        private val persianTypeFace =
            ResourcesCompat.getFont(binding.root.context, R.font.iran_sans_regular)!!

        private fun parsePersianSegmentInArabicText(raw: String): SpannableStringBuilder {
            // 1. Split on the marker (drops the marker itself)
            val parts = raw.split("--PERSIAN--")
            val spannableStringBuilder = SpannableStringBuilder()
            var cursor = 0
            for (i in parts.indices) {
                val segment = parts[i]
                if (segment.isEmpty()) continue
                // 2. Append this chunk
                spannableStringBuilder.append(segment)
                // 3. If i is odd, that means it followed a marker → apply Persian font
                if (i % 2 == 1) {
                    spannableStringBuilder.setSpan(
                        CustomTypeFace(persianTypeFace),
                        cursor,
                        cursor + segment.length,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
                // 4. Move our cursor forward
                cursor += segment.length
            }

            return spannableStringBuilder
        }

        fun bindPrayTextWithPersianSegments(arabicText: String, persianText: String) {
            binding.txtPrayArabic.text = parsePersianSegmentInArabicText(arabicText)
            if (persianText.isEmpty() || persianText.isBlank())
                binding.txtPrayTranslationPersian.visibility = View.GONE
            else
                binding.txtPrayTranslationPersian.text = persianText
        }

        fun bindOtherPraysText(arabicText: String, persianText: String) {
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
        bindFull(holder, position)
    }

    private fun bindFull(holder: PrayTextViewHolder, position: Int) {
        if (category == PrayCategories.GHADR_NIGHTS
            || category == PrayCategories.ZIARAT
            || category == PrayCategories.NAMAZ
        ) {
            val persianText = persianTextList.getOrNull(position) ?: ""
            holder.bindPrayTextWithPersianSegments(arabicTextList[position], persianText)
        } else {
            holder.bindOtherPraysText(arabicTextList[position], persianTextList[position])
        }
    }

}