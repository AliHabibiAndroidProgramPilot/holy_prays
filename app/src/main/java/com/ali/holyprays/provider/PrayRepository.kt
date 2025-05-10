package com.ali.holyprays.provider

object PrayRepository {

    fun providePrayByCategory(category: PrayCategories): List<PrayDataModel> {
        return when (category) {
            PrayCategories.PRAYS -> {
                listOf(
                    PrayDataModel(
                        1,
                        "دعای صباح",
                        null,
                        "prays/sabah_pray.txt",
                        "prays/persian/sabah_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        2,
                        "دعای کمیل",
                        null,
                        "prays/komeil_pray.txt",
                        "prays/persian/komeil_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        3,
                        "دعای ندبه",
                        null,
                        "prays/nadabe_pray.txt",
                        "prays/persian/nadabe_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        4,
                        "دعای سمات",
                        null,
                        "prays/samat_pray.txt",
                        "prays/persian/samat_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        5,
                        "دعای مجیر",
                        null,
                        "prays/majir_pray.txt",
                        "prays/persian/majir_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        6,
                        "دعای جوشن کبیر",
                        null,
                        "prays/joshan_kabir_pray.txt",
                        "prays/persian/joshan_kabir_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        7,
                        "دعای توسل",
                        null,
                        "prays/tavasol_pray.txt",
                        "prays/persian/tavasol_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        8,
                        "دعای هر روز ماه رجب",
                        null,
                        "prays/rajab_everyday_pray.txt",
                        "prays/persian/rajab_everyday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        9,
                        "صلوات شعبانیه",
                        null,
                        "prays/salavat_shabanihe_pray.txt",
                        "prays/persian/salavat_shabanihe_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        10,
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
                    PrayDataModel(1, "دعای وقت افطار", null, null, null, null),
                    PrayDataModel(2, "دعای مشترک شب و روز ماه رمضان", null, null, null, null),
                    PrayDataModel(3, "دعای افتتاح", null, null, null, null),
                    PrayDataModel(4, "دعای سحر", null, null, null, null),
                    PrayDataModel(5, "دعای روز اول ماه رمضان", null, null, null, null),
                    PrayDataModel(6, "دعای روز دوم ماه رمضان", null, null, null, null),
                    PrayDataModel(7, "دعای روز سوم ماه رمضان", null, null, null, null),
                    PrayDataModel(8, "دعای روز چهارم ماه رمضان", null, null, null, null),
                    PrayDataModel(9, "دعای روز پنجم ماه رمضان", null, null, null, null),
                    PrayDataModel(10, "دعای روز ششم ماه رمضان", null, null, null, null),
                    PrayDataModel(11, "دعای روز هفتم ماه رمضان", null, null, null, null),
                    PrayDataModel(12, "دعای روز هشتم ماه رمضان", null, null, null, null),
                    PrayDataModel(13, "دعای روز نهم ماه رمضان", null, null, null, null),
                    PrayDataModel(14, "دعای روز دهم ماه رمضان", null, null, null, null),
                    PrayDataModel(15, "دعای روز یازدهم ماه رمضان", null, null, null, null),
                    PrayDataModel(16, "دعای روز دوازدهم ماه رمضان", null, null, null, null),
                    PrayDataModel(17, "دعای روز سیزدهم ماه رمضان", null, null, null, null),
                    PrayDataModel(18, "دعای روز چهاردهم ماه رمضان", null, null, null, null),
                    PrayDataModel(19, "دعای روز پانزدهم ماه رمضان", null, null, null, null),
                    PrayDataModel(20, "دعای روز شانزدهم ماه رمضان", null, null, null, null),
                    PrayDataModel(21, "دعای روز هفدهم ماه رمضان", null, null, null, null),
                    PrayDataModel(22, "دعای روز هجدهم ماه رمضان", null, null, null, null),
                    PrayDataModel(23, "دعای روز نوزدهم ماه رمضان", null, null, null, null),
                    PrayDataModel(24, "دعای روز بیستم ماه رمضان", null, null, null, null),
                    PrayDataModel(25, "دعای روز بیست و یکم ماه رمضان", null, null, null, null),
                    PrayDataModel(26, "دعای روز بیست و دوم ماه رمضان", null, null, null, null),
                    PrayDataModel(27, "دعای روز بیست و سوم ماه رمضان", null, null, null, null),
                    PrayDataModel(28, "دعای روز بیست و چهارم ماه رمضان", null, null, null, null),
                    PrayDataModel(29, "دعای روز بیست و پنجم ماه رمضان", null, null, null, null),
                    PrayDataModel(30, "دعای روز بیست و ششم ماه رمضان", null, null, null, null),
                    PrayDataModel(31, "دعای روز بیست و هفتم ماه رمضان", null, null, null, null),
                    PrayDataModel(32, "دعای روز بیست و هشتم ماه رمضان", null, null, null, null),
                    PrayDataModel(33, "دعای روز بیست و نهم ماه رمضان", null, null, null, null),
                    PrayDataModel(34, "دعای روز سی ام ماه رمضان", null, null, null, null),
                    PrayDataModel(37, "اعمال مشترک شب های قدر", null, null, null, null),
                    PrayDataModel(38, "اعمال شب نوزدهم", null, null, null, null),
                    PrayDataModel(39, "اعمال شب بیست و یکم", null, null, null, null),
                    PrayDataModel(40, "اعمال شب بیست و سوم", null, null, null, null),
                    PrayDataModel(41, "اعمال روز عید فطر", null, null, null, null)
                )
            }

            PrayCategories.ZIARAT -> {
                listOf(
                    PrayDataModel(1, "زیارت امین الله", null, null, null, null),
                    PrayDataModel(2, "زیارت وارث", null, null, null, null),
                    PrayDataModel(3, "زیارت عاشورا", null, null, null, null),
                    PrayDataModel(
                        4, "دعای بعد از زیارت عاشورا", "معروف به علقمه", null, null, null
                    ),
                    PrayDataModel(5, "زیارت اربعین", null, null, null, null),
                    PrayDataModel(6, " زیارت حضرت عباس", null, null, null, null),
                    PrayDataModel(7, "زیارت امام رضا", null, null, null, null),
                    PrayDataModel(8, "دعای بعد از زیارت امام رضا", null, null, null, null),
                    PrayDataModel(9, "زیارت وداع امام رضا", null, null, null, null),
                    PrayDataModel(10, "زیارت آل یاسین", null, null, null, null),
                    PrayDataModel(11, "زیارت امام زمان", "بعد از نماز صبح", null, null, null),
                    PrayDataModel(12, "دعای فرج", null, null, null, null),
                    PrayDataModel(13, "دعای عهد", null, null, null, null),
                    PrayDataModel(14, "زیارت جامعه کبیره", null, null, null, null),
                    PrayDataModel(15, "زیارت حضرت معصومه", null, null, null, null),
                    PrayDataModel(16, "زیارت حضرت عبدالعظیم", null, null, null, null),
                    PrayDataModel(17, "زیارت امامزادگان", null, null, null, null),
                    PrayDataModel(18, "حدیث شریف کسا", null, null, null, null),
                    PrayDataModel(19, "دعای نور", null, null, null, null),
                    PrayDataModel(20, "دعای مکنون", null, null, null, null),
                    PrayDataModel(21, "دعای طول عمر", null, null, null, null),
                    PrayDataModel(22, "دعای ادای قرض", null, null, null, null),
                    PrayDataModel(23, "دعای استجابت دعا", null, null, null, null),
                    PrayDataModel(24, "دعای سریع الاجابه", null, null, null, null),
                    PrayDataModel(25, "زیارت اهل قبور", null, null, null, null),
                    PrayDataModel(26, "تاریخچه چهارده معصوم", null, null, null, null)
                )
            }

            PrayCategories.SORE -> {
                listOf(
                    PrayDataModel(
                        1,
                        "سوره یس",
                        null,
                        "sore/yase.txt",
                        "sore/persian/yase_p.txt",
                        null
                    ),
                    PrayDataModel(
                        2,
                        "سوره الرحمن",
                        null,
                        "sore/al_rahman.txt",
                        "sore/persian/al_rahman_p.txt",
                        null
                    ),
                    PrayDataModel(
                        3,
                        "سوره واقعه",
                        null,
                        "sore/vaghe.txt",
                        "sore/persian/vaghe_p.txt",
                        null
                    ),
                    PrayDataModel(
                        4,
                        "سوره جمعه",
                        null,
                        "sore/jome.txt",
                        "sore/persian/jome_p.txt",
                        null
                    ),
                    PrayDataModel(
                        5,
                        "سوره تبارک(ملک)",
                        null,
                        "sore/tabarak_melk.txt",
                        "sore/persian/tabarak_melk_p.txt",
                        null
                    ),
                    PrayDataModel(6, "نبا", null, "sore/naba.txt", "sore/persian/naba_p.txt", null),
                    PrayDataModel(
                        7,
                        "سوره اعلی",
                        null,
                        "sore/aali.txt",
                        "sore/persian/aali_p.txt",
                        null
                    ),
                    PrayDataModel(
                        8,
                        "شوره شمس",
                        null,
                        "sore/shams.txt",
                        "sore/persian/shams_p.txt",
                        null
                    ),
                    PrayDataModel(
                        9,
                        "سوره قدر",
                        null,
                        "sore/ghadr.txt",
                        "sore/persian/ghadr_p.txt",
                        null
                    ),
                    PrayDataModel(
                        10,
                        "سوره زلزال",
                        null,
                        "sore/zalzal.txt",
                        "sore/persian/zalzal_p.txt",
                        null
                    ),
                    PrayDataModel(
                        11,
                        "سوره عادیات",
                        null,
                        "sore/adiyat.txt",
                        "sore/persian/adiyat_p.txt",
                        null
                    ),
                    PrayDataModel(
                        12,
                        "سوره کافرون",
                        null,
                        "sore/kaferon.txt",
                        "sore/persian/kaferon_p.txt",
                        null
                    ),
                    PrayDataModel(
                        13,
                        "سوره نصر",
                        null,
                        "sore/nasr.txt",
                        "sore/persian/nasr_p.txt",
                        null
                    ),
                    PrayDataModel(
                        14,
                        "سوره توحید",
                        null,
                        "sore/towhid.txt",
                        "sore/persian/towhid_p.txt",
                        null
                    ),
                    PrayDataModel(
                        15,
                        "سوره عصر",
                        null,
                        "sore/asr.txt",
                        "sore/persian/asr_p.txt",
                        null
                    ),
                    PrayDataModel(
                        16,
                        "سوره فلق",
                        null,
                        "sore/falagh.txt",
                        "sore/persian/falagh_p.txt",
                        null
                    ),
                    PrayDataModel(
                        17,
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
                        "تعقیبات مشترکه",
                        null,
                        "namaz_taghibat/taghibat_moshtarake.txt",
                        "namaz_taghibat/persian/taghibat_moshtarake_p.txt",
                        null
                    ),
                    PrayDataModel(
                        2,
                        "تعقیبات نماز صبح",
                        null,
                        "namaz_taghibat/taghibat_namaz_sobh.txt",
                        "namaz_taghibat/persian/taghibat_namaz_sobh_p.txt",
                        null
                    ),
                    PrayDataModel(
                        3,
                        "تعقیبات نماز ظهر",
                        null,
                        "namaz_taghibat/taghibat_namaz_zohr.txt",
                        "namaz_taghibat/persian/taghibat_namaz_zohr_p.txt",
                        null
                    ),
                    PrayDataModel(
                        4,
                        "تعقیبات نماز عصر",
                        null,
                        "namaz_taghibat/taghibat_namaz_asr.txt",
                        "namaz_taghibat/persian/taghibat_namaz_asr_p.txt",
                        null
                    ),
                    PrayDataModel(
                        5,
                        "تعقیبات نماز مغرب",
                        null,
                        "namaz_taghibat/taghibat_namaz_maghreb.txt",
                        "namaz_taghibat/persian/taghibat_namaz_maghreb_p.txt",
                        null
                    ),
                    PrayDataModel(
                        6,
                        "نماز غفلیه",
                        null,
                        "namaz_taghibat/namaz_ghefliye.txt",
                        "namaz_taghibat/persian/namaz_ghefliye_p.txt",
                        null
                    ),
                    PrayDataModel(
                        7,
                        "تعقیبات نماز اعشا",
                        null,
                        "namaz_taghibat/taghibat_namaz_asha.txt",
                        "namaz_taghibat/persian/taghibat_namaz_asha_p.txt",
                        null
                    ),
                    PrayDataModel(
                        8,
                        "آمن الرسول",
                        null,
                        "namaz_taghibat/amen_al_rasoul.txt",
                        "namaz_taghibat/persian/amen_al_rasoul_p.txt",
                        null
                    ),
                    PrayDataModel(
                        9,
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
                        "دعای روز شنبه",
                        null,
                        "week_zirat/saturday_pray.txt",
                        "week_zirat/persian/saturday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        2,
                        "زیارت حضرت رسول (ص) در روز شنبه",
                        null,
                        "week_zirat/rasoul_saturday_pray.txt",
                        "week_zirat/persian/amir_al_momenin_sunday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        3,
                        "دعای روز یکشنبه",
                        null,
                        "week_zirat/saturday_pray.txt",
                        "week_zirat/persian/sunday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        4,
                        "زیارت حضرت امیرالمومنین در روز یکشنبه",
                        null,
                        "week_zirat/amir_al_momenin_sunday_pray.txt",
                        "week_zirat/persian/amir_al_momenin_sunday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        5,
                        "زیارت حضرت زهرا در روز یکشنبه",
                        null,
                        "week_zirat/hazrat_zahra_sunday_pray.txt",
                        "week_zirat/persian/hazrat_zahra_sunday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        6,
                        "دعای روز دوشنبه",
                        null,
                        "week_zirat/monday_pray.txt",
                        "week_zirat/persian/monday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        7,
                        "زیارت امام حسن در روز دوشنبه",
                        null,
                        "week_zirat/imam_hassan_monday_pray.txt",
                        "week_zirat/persian/imam_hassan_monday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        8,
                        "زیارت امام حسین در روز دوشنبه",
                        null,
                        "week_zirat/imam_hossein_monday_pray.txt",
                        "week_zirat/persian/imam_hossein_monday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        9,
                        "دعای روز سه شنبه",
                        null,
                        "week_zirat/tuesday_pray.txt",
                        "week_zirat/persian/tuesday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        10,
                        "زیارت ائمه بقیع در روز سه شنبه",
                        null,
                        "week_zirat/aeme_baghie_tuesday_pray.txt",
                        "week_zirat/persian/aeme_bagihe_tuesday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        11,
                        "دعای روز چهارشنبه",
                        null,
                        "week_zirat/wensday_pray.txt",
                        "week_zirat/persian/wensday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        12,
                        "زیارت چهار امام در روز چهارشنبه",
                        null,
                        "week_zirat/four_imam_wensday_pray.txt",
                        "week_zirat/persian/four_imam_wensday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        13,
                        "دعای روز پنجشنبه",
                        null,
                        "week_zirat/thursday_pray.txt",
                        "week_zirat/persian/thursday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        14,
                        "زیارت امام حسن عسکری در روز پنجشنبه",
                        null,
                        "week_zirat/imam_hassan_asghari_thursday_pray.txt",
                        "week_zirat/persian/imam_hassan_asghari_thursday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        15,
                        "دعای روز جمعه",
                        null,
                        "week_zirat/friday_pray.txt",
                        "week_zirat/persian/friday_pray_p.txt",
                        null
                    ),
                    PrayDataModel(
                        16,
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
                    PrayDataModel(1, "دعای طلب رزق", null, null, null, null),
                    PrayDataModel(2, "آداب نماز حاجت مهم", null, null, null, null),
                    PrayDataModel(3, "نماز توسعه رزق", null, null, null, null),
                    PrayDataModel(4, "نماز در شدت و سختی", null, null, null, null),
                    PrayDataModel(5, "نماز شب اول قبر", null, null, null, null),
                    PrayDataModel(6, "نماز جعفر طیار", null, null, null, null),
                    PrayDataModel(7, "نماز اول هر ماه", null, null, null, null),
                    PrayDataModel(8, "نماز شب", null, null, null, null),
                    PrayDataModel(9, "نماز امام جواد", null, null, null, null),
                    PrayDataModel(10, "نماز دهه اول ذی الحجه", null, null, null, null)
                )
            }
        }
    }

}