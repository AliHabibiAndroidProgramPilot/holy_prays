package com.ali.holyprays.provider

// TODO(Can Change To Class?)
object PrayRepository {

    fun providePrayByCategory(category: PrayCategories): List<PrayDataModel> {
        return when (category) {
            PrayCategories.PRAYS -> {
                emptyList()
            }

            PrayCategories.RAMADAN_PRAY -> {
                emptyList()
            }

            PrayCategories.ZIARAT -> {
                emptyList()
            }

            PrayCategories.SORE -> {
                listOf(
                    PrayDataModel(1, "یس", null, null, null),
                    PrayDataModel(2, "الرحمن", null, null, null),
                    PrayDataModel(3, "واقعه", null, null, null),
                    PrayDataModel(4, "جمعه", null, null, null),
                    PrayDataModel(5, "تیارک(ملک)", null, null, null),
                    PrayDataModel(6, "نبا", null, null, null),
                    PrayDataModel(7, "اعلی", null, null, null),
                    PrayDataModel(8, "شمس", null, null, null),
                    PrayDataModel(9, "قدر", null, null, null),
                    PrayDataModel(10, "زلزال", null, null, null),
                    PrayDataModel(11, "عادیات", null, null, null),
                    PrayDataModel(12, "کافرون", null, null, null),
                    PrayDataModel(13, "نصر", null, null, null),
                    PrayDataModel(14, "توحید", null, null, null),
                    PrayDataModel(15, "عصر", null, null, null),
                    PrayDataModel(16, "فلق", null, null, null),
                    PrayDataModel(17, "ناس", null, null, null)
                )
            }

            PrayCategories.NAMAZ_TAGHIBAT -> {
                emptyList()
            }

            PrayCategories.WEEK_ZIARAT -> {
                emptyList()
            }

            PrayCategories.NAMAZ -> {
                emptyList()
            }
        }
    }

}