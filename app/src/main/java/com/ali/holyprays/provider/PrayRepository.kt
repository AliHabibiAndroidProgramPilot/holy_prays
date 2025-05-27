package com.ali.holyprays.provider

object PrayRepository {

    fun providePrayByCategory(category: PrayCategories): List<PrayDataModel> {
        return when (category) {
            PrayCategories.PRAYS -> {
                listOf(
                    PrayDataModel(
                        1,
                        PrayCategories.PRAYS,
                        "دعای صباح",
                        null,
                        "prays/sabah_pray.txt",
                        "prays/persian/sabah_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        2,
                        PrayCategories.PRAYS,
                        "دعای کمیل",
                        null,
                        "prays/komeil_pray.txt",
                        "prays/persian/komeil_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        3,
                        PrayCategories.PRAYS,
                        "دعای ندبه",
                        null,
                        "prays/nadabe_pray.txt",
                        "prays/persian/nadabe_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        4,
                        PrayCategories.PRAYS,
                        "دعای سمات",
                        null,
                        "prays/samat_pray.txt",
                        "prays/persian/samat_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        5,
                        PrayCategories.PRAYS,
                        "دعای مجیر",
                        null,
                        "prays/majir_pray.txt",
                        "prays/persian/majir_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        6,
                        PrayCategories.PRAYS,
                        "دعای جوشن کبیر",
                        null,
                        "prays/joshan_kabir_pray.txt",
                        "prays/persian/joshan_kabir_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        7,
                        PrayCategories.PRAYS,
                        "دعای توسل",
                        null,
                        "prays/tavasol_pray.txt",
                        "prays/persian/tavasol_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        8,
                        PrayCategories.PRAYS,
                        "دعای هر روز ماه رجب",
                        null,
                        "prays/rajab_everyday_pray.txt",
                        "prays/persian/rajab_everyday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        9,
                        PrayCategories.PRAYS,
                        "صلوات شعبانیه",
                        null,
                        "prays/salavat_shabanihe_pray.txt",
                        "prays/persian/salavat_shabanihe_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        10,
                        PrayCategories.PRAYS,
                        "مناجات شعبانیه",
                        null,
                        "prays/monajat_shabanihe_pray.txt",
                        "prays/persian/monajat_shabanihe_pray_p.txt",
                        null
                    )
                )
            }

            PrayCategories.RAMADAN_PRAY -> {
                listOf(
                    PrayDataModel(
                        1,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای وقت افطار",
                        null,
                        "ramadan_prays/iftar_time_pray.txt",
                        "ramadan_prays/persian/iftar_time_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        2,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای مشترک شب و روز ماه رمضان",
                        null,
                        "ramadan_prays/days_nights_ramadan_pray.txt",
                        "ramadan_prays/persian/days_nights_ramadan_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        3,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای افتتاح",
                        null,
                        "ramadan_prays/iftetah_pray.txt",
                        "ramadan_prays/persian/iftetah_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        4,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای سحر",
                        null,
                        "ramadan_prays/sahar_pray.txt",
                        "ramadan_prays/persian/sahar_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        5,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز اول ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_one.txt",
                        "ramadan_prays/persian/ramadan_day_one_p.txt",
                        null
                    ),
                    PrayDataModel(
                        6,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز دوم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_two.txt",
                        "ramadan_prays/persian/ramadan_day_two_p.txt",
                        null
                    ),
                    PrayDataModel(
                        7,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز سوم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_three.txt",
                        "ramadan_prays/persian/ramadan_day_three_p.txt",
                        null
                    ),
                    PrayDataModel(
                        8,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز چهارم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_four.txt",
                        "ramadan_prays/persian/ramadan_day_four_p.txt",
                        null
                    ),
                    PrayDataModel(
                        9,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز پنجم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_five.txt",
                        "ramadan_prays/persian/ramadan_day_five_p.txt",
                        null
                    ),
                    PrayDataModel(
                        10,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز ششم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_six.txt",
                        "ramadan_prays/persian/ramadan_day_six_p.txt",
                        null
                    ),
                    PrayDataModel(
                        11,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز هفتم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_seven.txt",
                        "ramadan_prays/persian/ramadan_day_seven_p.txt",
                        null
                    ),
                    PrayDataModel(
                        12,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز هشتم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_eight.txt",
                        "ramadan_prays/persian/ramadan_day_eight_p.txt",
                        null
                    ),
                    PrayDataModel(
                        13,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز نهم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_nine.txt",
                        "ramadan_prays/persian/ramadan_day_nine_p.txt",
                        null
                    ),
                    PrayDataModel(
                        14,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز دهم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_ten.txt",
                        "ramadan_prays/persian/ramadan_day_ten_p.txt",
                        null
                    ),
                    PrayDataModel(
                        15,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز یازدهم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_eleven.txt",
                        "ramadan_prays/persian/ramadan_day_eleven_p.txt",
                        null
                    ),
                    PrayDataModel(
                        16,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز دوازدهم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_twelve.txt",
                        "ramadan_prays/persian/ramadan_day_twelve_p.txt",
                        null
                    ),
                    PrayDataModel(
                        17,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز سیزدهم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_thirteen.txt",
                        "ramadan_prays/persian/ramadan_day_thirteen_p.txt",
                        null
                    ),
                    PrayDataModel(
                        18,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز چهاردهم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_fourteen.txt",
                        "ramadan_prays/persian/ramadan_day_fourteen_p.txt",
                        null
                    ),
                    PrayDataModel(
                        19,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز پانزدهم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_fifteen.txt",
                        "ramadan_prays/persian/ramadan_day_fifteen_p.txt",
                        null
                    ),
                    PrayDataModel(
                        20,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز شانزدهم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_sixteen.txt",
                        "ramadan_prays/persian/ramadan_day_sixteen_p.txt",
                        null
                    ),
                    PrayDataModel(
                        21,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز هفدهم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_seventeen.txt",
                        "ramadan_prays/persian/ramadan_day_seventeen_p.txt",
                        null
                    ),
                    PrayDataModel(
                        22,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز هجدهم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_eighteen.txt",
                        "ramadan_prays/persian/ramadan_day_eighteen_p.txt",
                        null
                    ),
                    PrayDataModel(
                        23,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز نوزدهم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_nineteen.txt",
                        "ramadan_prays/persian/ramadan_day_nineteen_p.txt",
                        null
                    ),
                    PrayDataModel(
                        24,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز بیستم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_twenty.txt",
                        "ramadan_prays/persian/ramadan_day_twenty_p.txt",
                        null
                    ),
                    PrayDataModel(
                        25,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز بیست و یکم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_twenty_one.txt",
                        "ramadan_prays/persian/ramadan_day_twenty_one_p.txt",
                        null
                    ),
                    PrayDataModel(
                        26,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز بیست و دوم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_twenty_two.txt",
                        "ramadan_prays/persian/ramadan_day_twenty_two_p.txt",
                        null
                    ),
                    PrayDataModel(
                        27,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز بیست و سوم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_twenty_three.txt",
                        "ramadan_prays/persian/ramadan_day_twenty_three_p.txt",
                        null
                    ),
                    PrayDataModel(
                        28,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز بیست و چهارم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_twenty_four.txt",
                        "ramadan_prays/persian/ramadan_day_twenty_four_p.txt",
                        null
                    ),
                    PrayDataModel(
                        29,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز بیست و پنجم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_twenty_five.txt",
                        "ramadan_prays/persian/ramadan_day_twenty_five_p.txt",
                        null
                    ),
                    PrayDataModel(
                        30,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز بیست و ششم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_twenty_six.txt",
                        "ramadan_prays/persian/ramadan_day_twenty_six_p.txt",
                        null
                    ),
                    PrayDataModel(
                        31,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز بیست و هفتم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_twenty_seven.txt",
                        "ramadan_prays/persian/ramadan_day_twenty_seven_p.txt",
                        null
                    ),
                    PrayDataModel(
                        32,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز بیست و هشتم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_twenty_eight.txt",
                        "ramadan_prays/persian/ramadan_day_twenty_eight_p.txt",
                        null
                    ),
                    PrayDataModel(
                        33,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز بیست و نهم ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_twenty_nine.txt",
                        "ramadan_prays/persian/ramadan_day_twenty_nine_p.txt",
                        null
                    ),
                    PrayDataModel(
                        34,
                        PrayCategories.RAMADAN_PRAY,
                        "دعای روز سی ام ماه رمضان",
                        null,
                        "ramadan_prays/ramadan_day_thirty.txt",
                        "ramadan_prays/persian/ramadan_day_thirty_p.txt",
                        null
                    )
                )
            }

            PrayCategories.ZIARAT -> {
                listOf(
                    PrayDataModel(
                        1,
                        PrayCategories.ZIARAT,
                        "زیارت امین الله",
                        null,
                        "zirat/zirat_amin_allah.txt",
                        "zirat/persian/zirat_amin_allah_p.txt",
                        null
                    ),
                    PrayDataModel(
                        2,
                        PrayCategories.ZIARAT,
                        "زیارت وارث",
                        null,
                        "zirat/zirat_vares.txt",
                        "zirat/persian/zirat_vares_p.txt",
                        null
                    ),
                    PrayDataModel(
                        3,
                        PrayCategories.ZIARAT,
                        "زیارت عاشورا",
                        null,
                        "zirat/zirat_ashura.txt",
                        "zirat/persian/zirat_ashura_p.txt",
                        null
                    ),
                    PrayDataModel(
                        4,
                        PrayCategories.ZIARAT,
                        "دعای بعد از زیارت عاشورا",
                        "معروف به علقمه",
                        "zirat/after_ashura_pray.txt",
                        "zirat/persian/after_ashura_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        5,
                        PrayCategories.ZIARAT,
                        "زیارت اربعین",
                        null,
                        "zirat/zirat_arbaien.txt",
                        "zirat/persian/zirat_arbaien_p.txt",
                        null
                    ),
                    PrayDataModel(
                        6,
                        PrayCategories.ZIARAT,
                        " زیارت حضرت عباس",
                        null,
                        "zirat/zirat_hazrat_abas.txt",
                        "zirat/persian/zirat_hazrat_abas_p.txt",
                        null
                    ),
                    PrayDataModel(
                        7,
                        PrayCategories.ZIARAT,
                        "زیارت امام رضا",
                        null,
                        "zirat/zirat_imam_reza",
                        "zirat/persian/zirat_imam_reza_p.txt",
                        null
                    ),
                    PrayDataModel(
                        8,
                        PrayCategories.ZIARAT,
                        "دعای بعد از زیارت امام رضا",
                        null,
                        "zirat/after_imam_reza_zirat_pray.txt",
                        "zirat/persian/after_imam_reza_zirat_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        9,
                        PrayCategories.ZIARAT,
                        "زیارت وداع امام رضا",
                        null,
                        "zirat/zirat_veda_imam_reza.txt",
                        "zirat/persian/zirat_veda_imam_reza_p.txt",
                        null
                    ),
                    PrayDataModel(
                        10,
                        PrayCategories.ZIARAT,
                        "زیارت آل یاسین",
                        null,
                        "zirat/zirat_al_yasin.txt",
                        "zirat/persian/zirat_al_yasin_p.txt",
                        null
                    ),
                    PrayDataModel(
                        11,
                        PrayCategories.ZIARAT,
                        "زیارت امام زمان",
                        "بعد از نماز صبح",
                        "zirat/zirat_imam_zaman_after_morning_namaz.txt",
                        "zirat/persian/zirat_imam_zaman_after_morning_namaz_p.txt",
                        null
                    ),
                    PrayDataModel(
                        12,
                        PrayCategories.ZIARAT,
                        "دعای فرج",
                        null,
                        "zirat/faraj_pray.txt",
                        "zirat/persian/faraj_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        13,
                        PrayCategories.ZIARAT,
                        "دعای عهد",
                        null,
                        "zirat/ahd_pray.txt",
                        "zirat/persian/ahd_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        14,
                        PrayCategories.ZIARAT,
                        "زیارت جامعه کبیره",
                        null,
                        "zirat/zirat_jame_kabire.txt",
                        "zirat/persian/zirat_jame_kabire_p.txt",
                        null
                    ),
                    PrayDataModel(
                        15,
                        PrayCategories.ZIARAT,
                        "زیارت حضرت معصومه",
                        null,
                        "zirat/zirat_hazrat_masoume.txt",
                        "zirat/persian/zirat_hazrat_masoume_p.txt",
                        null
                    ),
                    PrayDataModel(
                        16,
                        PrayCategories.ZIARAT,
                        "زیارت حضرت عبدالعظیم",
                        null,
                        "zirat/zirat_hazrat_abdol_azim.txt",
                        "zirat/persian/zirat_hazrat_abdol_azim_p.txt",
                        null
                    ),
                    PrayDataModel(
                        17,
                        PrayCategories.ZIARAT,
                        "زیارت امامزادگان",
                        null,
                        "zirat/zirat_imam_zadegan.txt",
                        "zirat/persian/zirat_imam_zadegan_p.txt",
                        null
                    ),
                    PrayDataModel(
                        18,
                        PrayCategories.ZIARAT,
                        "حدیث شریف کساء",
                        null,
                        "zirat/hadis_kasa.txt",
                        "zirat/persian/hadis_kasa_p.txt",
                        null
                    ),
                    PrayDataModel(
                        19,
                        PrayCategories.ZIARAT,
                        "دعای نور",
                        null,
                        "zirat/noor_pray.txt",
                        "zirat/persian/noor_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        20,
                        PrayCategories.ZIARAT,
                        "دعای مکنون",
                        null,
                        "zirat/maknoon_pray.txt",
                        "zirat/persian/maknoon_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        21,
                        PrayCategories.ZIARAT,
                        "دعای طول عمر",
                        null,
                        "zirat/tool_omr_pray.txt",
                        "zirat/persian/tool_omr_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        22,
                        PrayCategories.ZIARAT,
                        "دعای ادای قرض",
                        null,
                        "zirat/adaye_gharz_pray.txt",
                        "zirat/persian/adaye_gharz_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        23,
                        PrayCategories.ZIARAT,
                        "دعای سریع الاجابه",
                        "دعای استجابت دعا",
                        "zirat/sari_ol_ejabe_pray.txt",
                        "zirat/persian/sari_ol_ejabe_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        24,
                        PrayCategories.ZIARAT,
                        "زیارت اهل قبور",
                        null,
                        "zirat/zirat_ahl_ghoboor.txt",
                        "zirat/persian/zirat_ahl_ghoboor_p.txt",
                        null
                    ),
                )
            }

            PrayCategories.SORE -> {
                listOf(
                    PrayDataModel(
                        1,
                        PrayCategories.SORE,
                        "سوره یس",
                        null,
                        "sore/yase.txt",
                        "sore/persian/yase_p.txt",
                        null
                    ),
                    PrayDataModel(
                        2,
                        PrayCategories.SORE,
                        "سوره الرحمن",
                        null,
                        "sore/al_rahman.txt",
                        "sore/persian/al_rahman_p.txt",
                        null
                    ),
                    PrayDataModel(
                        3,
                        PrayCategories.SORE,
                        "سوره واقعه",
                        null,
                        "sore/vaghe.txt",
                        "sore/persian/vaghe_p.txt",
                        null
                    ),
                    PrayDataModel(
                        4,
                        PrayCategories.SORE,
                        "سوره جمعه",
                        null,
                        "sore/jome.txt",
                        "sore/persian/jome_p.txt",
                        null
                    ),
                    PrayDataModel(
                        5,
                        PrayCategories.SORE,
                        "سوره تبارک(ملک)",
                        null,
                        "sore/tabarak_melk.txt",
                        "sore/persian/tabarak_melk_p.txt",
                        null
                    ),
                    PrayDataModel(
                        6,
                        PrayCategories.SORE,
                        "سوره نبا",
                        null,
                        "sore/naba.txt",
                        "sore/persian/naba_p.txt",
                        null
                    ),
                    PrayDataModel(
                        7,
                        PrayCategories.SORE,
                        "سوره اعلی",
                        null,
                        "sore/aali.txt",
                        "sore/persian/aali_p.txt",
                        null
                    ),
                    PrayDataModel(
                        8,
                        PrayCategories.SORE,
                        "شوره شمس",
                        null,
                        "sore/shams.txt",
                        "sore/persian/shams_p.txt",
                        null
                    ),
                    PrayDataModel(
                        9,
                        PrayCategories.SORE,
                        "سوره قدر",
                        null,
                        "sore/ghadr.txt",
                        "sore/persian/ghadr_p.txt",
                        null
                    ),
                    PrayDataModel(
                        10,
                        PrayCategories.SORE,
                        "سوره زلزال",
                        null,
                        "sore/zalzal.txt",
                        "sore/persian/zalzal_p.txt",
                        null
                    ),
                    PrayDataModel(
                        11,
                        PrayCategories.SORE,
                        "سوره عادیات",
                        null,
                        "sore/adiyat.txt",
                        "sore/persian/adiyat_p.txt",
                        null
                    ),
                    PrayDataModel(
                        12,
                        PrayCategories.SORE,
                        "سوره کافرون",
                        null,
                        "sore/kaferon.txt",
                        "sore/persian/kaferon_p.txt",
                        null
                    ),
                    PrayDataModel(
                        13,
                        PrayCategories.SORE,
                        "سوره نصر",
                        null,
                        "sore/nasr.txt",
                        "sore/persian/nasr_p.txt",
                        null
                    ),
                    PrayDataModel(
                        14,
                        PrayCategories.SORE,
                        "سوره توحید",
                        null,
                        "sore/towhid.txt",
                        "sore/persian/towhid_p.txt",
                        null
                    ),
                    PrayDataModel(
                        15,
                        PrayCategories.SORE,
                        "سوره عصر",
                        null,
                        "sore/asr.txt",
                        "sore/persian/asr_p.txt",
                        null
                    ),
                    PrayDataModel(
                        16,
                        PrayCategories.SORE,
                        "سوره فلق",
                        null,
                        "sore/falagh.txt",
                        "sore/persian/falagh_p.txt",
                        null
                    ),
                    PrayDataModel(
                        17,
                        PrayCategories.SORE,
                        "سوره ناس",
                        null,
                        "sore/naas.txt",
                        "sore/persian/naas_p.txt",
                        null
                    )
                )
            }

            PrayCategories.NAMAZ_TAGHIBAT -> {
                listOf(
                    PrayDataModel(
                        1,
                        PrayCategories.NAMAZ_TAGHIBAT,
                        "تعقیبات مشترکه",
                        null,
                        "namaz_taghibat/taghibat_moshtarake.txt",
                        "namaz_taghibat/persian/taghibat_moshtarake_p.txt",
                        null
                    ),
                    PrayDataModel(
                        2,
                        PrayCategories.NAMAZ_TAGHIBAT,
                        "تعقیبات نماز صبح",
                        null,
                        "namaz_taghibat/taghibat_namaz_sobh.txt",
                        "namaz_taghibat/persian/taghibat_namaz_sobh_p.txt",
                        null
                    ),
                    PrayDataModel(
                        3,
                        PrayCategories.NAMAZ_TAGHIBAT,
                        "تعقیبات نماز ظهر",
                        null,
                        "namaz_taghibat/taghibat_namaz_zohr.txt",
                        "namaz_taghibat/persian/taghibat_namaz_zohr_p.txt",
                        null
                    ),
                    PrayDataModel(
                        4,
                        PrayCategories.NAMAZ_TAGHIBAT,
                        "تعقیبات نماز عصر",
                        null,
                        "namaz_taghibat/taghibat_namaz_asr.txt",
                        "namaz_taghibat/persian/taghibat_namaz_asr_p.txt",
                        null
                    ),
                    PrayDataModel(
                        5,
                        PrayCategories.NAMAZ_TAGHIBAT,
                        "تعقیبات نماز مغرب",
                        null,
                        "namaz_taghibat/taghibat_namaz_maghreb.txt",
                        "namaz_taghibat/persian/taghibat_namaz_maghreb_p.txt",
                        null
                    ),
                    PrayDataModel(
                        6,
                        PrayCategories.NAMAZ_TAGHIBAT,
                        "نماز غفلیه",
                        null,
                        "namaz_taghibat/namaz_ghefliye.txt",
                        "namaz_taghibat/persian/namaz_ghefliye_p.txt",
                        null
                    ),
                    PrayDataModel(
                        7,
                        PrayCategories.NAMAZ_TAGHIBAT,
                        "تعقیبات نماز اعشا",
                        null,
                        "namaz_taghibat/taghibat_namaz_asha.txt",
                        "namaz_taghibat/persian/taghibat_namaz_asha_p.txt",
                        null
                    ),
                    PrayDataModel(
                        8,
                        PrayCategories.NAMAZ_TAGHIBAT,
                        "آمن الرسول",
                        null,
                        "namaz_taghibat/amen_al_rasoul.txt",
                        "namaz_taghibat/persian/amen_al_rasoul_p.txt",
                        null
                    ),
                    PrayDataModel(
                        9,
                        PrayCategories.NAMAZ_TAGHIBAT,
                        "وان یکاد",
                        "آیه حفظ از چشم زخم",
                        "namaz_taghibat/van_yakad.txt",
                        "namaz_taghibat/persian/van_yakad_p.txt",
                        null
                    )
                )
            }

            PrayCategories.WEEK_ZIARAT -> {
                listOf(
                    PrayDataModel(
                        1,
                        PrayCategories.WEEK_ZIARAT,
                        "دعای روز شنبه",
                        null,
                        "week_zirat/saturday_pray.txt",
                        "week_zirat/persian/saturday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        2,
                        PrayCategories.WEEK_ZIARAT,
                        "زیارت حضرت رسول (ص) در روز شنبه",
                        null,
                        "week_zirat/rasoul_saturday_pray.txt",
                        "week_zirat/persian/amir_al_momenin_sunday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        3,
                        PrayCategories.WEEK_ZIARAT,
                        "دعای روز یکشنبه",
                        null,
                        "week_zirat/saturday_pray.txt",
                        "week_zirat/persian/sunday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        4,
                        PrayCategories.WEEK_ZIARAT,
                        "زیارت حضرت امیرالمومنین در روز یکشنبه",
                        null,
                        "week_zirat/amir_al_momenin_sunday_pray.txt",
                        "week_zirat/persian/amir_al_momenin_sunday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        5,
                        PrayCategories.WEEK_ZIARAT,
                        "زیارت حضرت زهرا در روز یکشنبه",
                        null,
                        "week_zirat/hazrat_zahra_sunday_pray.txt",
                        "week_zirat/persian/hazrat_zahra_sunday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        6,
                        PrayCategories.WEEK_ZIARAT,
                        "دعای روز دوشنبه",
                        null,
                        "week_zirat/monday_pray.txt",
                        "week_zirat/persian/monday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        7,
                        PrayCategories.WEEK_ZIARAT,
                        "زیارت امام حسن در روز دوشنبه",
                        null,
                        "week_zirat/imam_hassan_monday_pray.txt",
                        "week_zirat/persian/imam_hassan_monday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        8,
                        PrayCategories.WEEK_ZIARAT,
                        "زیارت امام حسین در روز دوشنبه",
                        null,
                        "week_zirat/imam_hossein_monday_pray.txt",
                        "week_zirat/persian/imam_hossein_monday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        9,
                        PrayCategories.WEEK_ZIARAT,
                        "دعای روز سه شنبه",
                        null,
                        "week_zirat/tuesday_pray.txt",
                        "week_zirat/persian/tuesday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        10,
                        PrayCategories.WEEK_ZIARAT,
                        "زیارت ائمه بقیع در روز سه شنبه",
                        null,
                        "week_zirat/aeme_baghie_tuesday_pray.txt",
                        "week_zirat/persian/aeme_bagihe_tuesday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        11,
                        PrayCategories.WEEK_ZIARAT,
                        "دعای روز چهارشنبه",
                        null,
                        "week_zirat/wensday_pray.txt",
                        "week_zirat/persian/wensday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        12,
                        PrayCategories.WEEK_ZIARAT,
                        "زیارت چهار امام در روز چهارشنبه",
                        null,
                        "week_zirat/four_imam_wensday_pray.txt",
                        "week_zirat/persian/four_imam_wensday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        13,
                        PrayCategories.WEEK_ZIARAT,
                        "دعای روز پنجشنبه",
                        null,
                        "week_zirat/thursday_pray.txt",
                        "week_zirat/persian/thursday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        14,
                        PrayCategories.WEEK_ZIARAT,
                        "زیارت امام حسن عسکری در روز پنجشنبه",
                        null,
                        "week_zirat/imam_hassan_asghari_thursday_pray.txt",
                        "week_zirat/persian/imam_hassan_asghari_thursday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        15,
                        PrayCategories.WEEK_ZIARAT,
                        "دعای روز جمعه",
                        null,
                        "week_zirat/friday_pray.txt",
                        "week_zirat/persian/friday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        16,
                        PrayCategories.WEEK_ZIARAT,
                        "زیارت صاحب الزمان (عج) در روز جمعه",
                        null,
                        "week_zirat/saheb_al_zaman_friday_pray.txt",
                        "week_zirat/persian/saheb_al_zaman_friday_pray_p.txt",
                        null
                    )
                )
            }

            PrayCategories.NAMAZ -> {
                listOf(
                    PrayDataModel(
                        1,
                        PrayCategories.NAMAZ,
                        "دعای طلب رزق",
                        null,
                        "namaz/talab_rezgh_pray.txt",
                        "namaz/persian/talab_rezgh_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        2,
                        PrayCategories.NAMAZ,
                        "آداب نماز حاجت مهم",
                        null,
                        "namaz/namaz_hajat_mohem.txt",
                        "namaz/persian/namaz_hajat_mohem_p.txt",
                        null
                    ),
                    PrayDataModel(
                        3,
                        PrayCategories.NAMAZ,
                        "نماز توسعه رزق",
                        null,
                        "namaz/namaz_tose_rezgh.txt",
                        "namaz/persian/namaz_tose_rezgh_p.txt",
                        null
                    ),
                    PrayDataModel(
                        4,
                        PrayCategories.NAMAZ,
                        "نماز در شدت و سختی",
                        null,
                        "namaz/namaz_shedat.txt",
                        "namaz/persian/namaz_shedat_p.txt",
                        null
                    ),
                    PrayDataModel(
                        5,
                        PrayCategories.NAMAZ,
                        "نماز شب اول قبر",
                        null,
                        "namaz/namaz_shab_aval_ghabr.txt",
                        "",
                        null
                    ),
                    PrayDataModel(
                        6,
                        PrayCategories.NAMAZ,
                        "نماز جعفر طیار",
                        null,
                        "namaz/namaz_jafar_tiyar.txt",
                        "namaz/persian/namaz_jafar_tiyar_p.txt",
                        null
                    ),
                    PrayDataModel(
                        7,
                        PrayCategories.NAMAZ,
                        "نماز اول هر ماه",
                        null,
                        "namaz/namaz_aval_mah.txt",
                        "namaz/persian/namaz_aval_mah_p.txt",
                        null
                    ),
                    PrayDataModel(
                        8,
                        PrayCategories.NAMAZ,
                        "نماز شب",
                        null,
                        "namaz/namaz_shab.txt",
                        "",
                        null
                    ),
                    PrayDataModel(
                        9,
                        PrayCategories.NAMAZ,
                        "نماز امام جواد",
                        null,
                        "namaz/namaz_imam_javad.txt",
                        "namaz/persian/namaz_imam_javad_p.txt",
                        null
                    ),
                    PrayDataModel(
                        10,
                        PrayCategories.NAMAZ,
                        "نماز دهه اول ذی الحجه",
                        null,
                        "namaz/namaz_dahe_aval_zehaje.txt",
                        "namaz/persian/namaz_dahe_aval_zehaje_p.txt",
                        null
                    ),
                    PrayDataModel(
                        11,
                        PrayCategories.NAMAZ,
                        "نماز والدین",
                        null,
                        "namaz/namaz_valedin.txt",
                        "namaz/persian/namaz_valedin_p.txt",
                        null
                    ),
                    PrayDataModel(
                        12,
                        PrayCategories.NAMAZ,
                        "نماز استغاثه به حضرت زهرا(س)",
                        null,
                        "namaz/namaz_esteghase_hazrat_fatemeh.txt",
                        "namaz/persian/namaz_esteghase_hazrat_fatemeh_p.txt",
                        null
                    ),
                    PrayDataModel(
                        13,
                        PrayCategories.NAMAZ,
                        "نماز مسجد جمکران",
                        null,
                        "namaz/namaz_jamkaran.txt",
                        "",
                        null
                    ),
                    PrayDataModel(
                        14,
                        PrayCategories.NAMAZ,
                        "نماز میت",
                        null,
                        "namaz/namaz_myat.txt",
                        "namaz/persian/namaz_myat_p.txt",
                        null
                    )
                )
            }

            PrayCategories.GHADR_NIGHTS -> {
                listOf(
                    PrayDataModel(
                        1,
                        PrayCategories.GHADR_NIGHTS,
                        "اعمال مشترک شب های قدر",
                        null,
                        "ghadr_nights/ghadr_nights_works.txt",
                        "ghadr_nights/persian/ghadr_nights_works_p.txt",
                        null
                    ),
                    PrayDataModel(
                        2,
                        PrayCategories.GHADR_NIGHTS,
                        "اعمال شب نوزدهم",
                        null,
                        "ghadr_nights/ghadr_nights_nineteen.txt",
                        "ghadr_nights/persian/ghadr_nights_nineteen_p.txt",
                        null
                    ),
                    PrayDataModel(
                        3,
                        PrayCategories.GHADR_NIGHTS,
                        "اعمال شب بیست و یکم",
                        null,
                        "ghadr_nights/ghadr_nights_twenty_one.txt",
                        "ghadr_nights/persian/ghadr_nights_twenty_one_p.txt",
                        null
                    ),
                    PrayDataModel(
                        4,
                        PrayCategories.GHADR_NIGHTS,
                        "اعمال شب بیست و سوم",
                        null,
                        "ghadr_nights/ghadr_nights_twenty_three.txt",
                        "ghadr_nights/persian/ghadr_nights_twenty_three_p.txt",
                        null
                    ),
                    PrayDataModel(
                        5,
                        PrayCategories.GHADR_NIGHTS,
                        "اعمال روز عید فطر",
                        null,
                        "ghadr_nights/fitr_aeid_works.txt",
                        "ghadr_nights/persian/fitr_aeid_works_p.txt",
                        null
                    )
                )
            }

        }
    }

}