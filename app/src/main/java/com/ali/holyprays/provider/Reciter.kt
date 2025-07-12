package com.ali.holyprays.provider

enum class Reciter(
    val reciterDisplayName: String,
    private val audioMap: Map<String, String>
) {

    ABDOL_VASET(
        "عبدالباسط",
        mapOf(
            "سوره یس" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673411321696210.mp3",
            "سوره الرحمن" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673416001989199.mp3",
            "سوره واقعه" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673416255429961.mp3",
            "سوره جمعه" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673417989015468.mp3",
            "سوره تبارک(ملک)" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673419272295842.mp3",
            "سوره نبا" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673422254167522.mp3",
            "سوره اعلی" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673424932568755.mp3",
            "سوره شمس" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673425674427513.mp3",
            "سوره قدر" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673428036111830.mp3",
            "سوره زلزال" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673428320951931.mp3",
            "سوره عادیات" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673428591260999.mp3",
            "سوره کافرون" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673430259204660.mp3",
            "سوره نصر" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673430392017271.mp3",
            "سوره توحید" to "https://dl.newsong.ir/music/97/03/Abdolbaset%20Tohid_(www.new-song.ir).mp3",
            "سوره عصر" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673429159691737.mp3",
            "سوره فلق" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673430853267803.mp3",
            "سوره ناس" to "https://cdn6.iribtv.ir/9/original/2018/07/16/636673431009673180.mp3"
        )
    ),

    SHARIAR_PARHIZKARI(
        "شهریار پرهیزکاری",
        mapOf(
            "سوره یس" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ036_1.MP3",
            "سوره الرحمن" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ055_0.MP3",
            "سوره واقعه" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ056_0.MP3",
            "سوره جمعه" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ062_0.MP3",
            "سوره تبارک(ملک)" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ067_0.MP3",
            "سوره نبا" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ078_0.MP3",
            "سوره اعلی" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ087_0.MP3",
            "سوره شمس" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ091_0.MP3",
            "سوره قدر" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ097_0.MP3",
            "سوره زلزال" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ099_0.MP3",
            "سوره عادیات" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ100_0.MP3",
            "سوره کافرون" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ109_0.MP3",
            "سوره نصر" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ110_1.MP3",
            "سوره توحید" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ112.MP3",
            "سوره عصر" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ103_0.MP3",
            "سوره فلق" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ113_1.MP3",
            "سوره ناس" to "https://static.ahlolbait.com/files/ahlolbait/old/12/download/PRHIZ114_1.MP3"
        )
    ),

    MAHER_AL_MAGHILI(
        "ماهر المعیقلی",
        mapOf(
            "سوره یس" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/036-Maher-Al-Muaiqly-Surah-Ya-Seen.mp3",
            "سوره الرحمن" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/055-Maher-Al-Muaiqly-Surah-Ar-Rahman.mp3",
            "سوره واقعه" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/056-Maher-Al-Muaiqly-Surah-Al-Waqia.mp3",
            "سوره جمعه" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/062-Maher-Al-Muaiqly-Surah-Al-Jumua.mp3",
            "سوره تبارک(ملک)" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/067-Maher-Al-Muaiqly-Surah-Al-Mulk.mp3",
            "سوره نبا" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/078-Maher-Al-Muaiqly-Surah-An-Naba.mp3",
            "سوره اعلی" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/087-Maher-Al-Muaiqly-Surah-Al-Ala.mp3",
            "سوره شمس" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/091-Maher-Al-Muaiqly-Surah-Ash-Shams.mp3",
            "سوره قدر" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/097-Maher-Al-Muaiqly-Surah-Al-Qadr.mp3",
            "سوره زلزال" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/099-Maher-Al-Muaiqly-Surah-Al-Zalzala.mp3",
            "سوره عادیات" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/100-Maher-Al-Muaiqly-Surah-Al-Adiyat.mp3",
            "سوره کافرون" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/109-Maher-Al-Muaiqly-Surah-Al-Kafiroon.mp3",
            "سوره نصر" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/110-Maher-Al-Muaiqly-Surah-An-Nasr.mp3",
            "سوره توحید" to "https://server12.mp3quran.net/maher/112.mp3",
            "سوره عصر" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/103-Maher-Al-Muaiqly-Surah-Al-Asr.mp3",
            "سوره فلق" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/113-Maher-Al-Muaiqly-Surah-Al-Falaq.mp3",
            "سوره ناس" to "https://dl.emadionline.com/Maher-Al-Muaiqly-Surah/114-Maher-Al-Muaiqly-Surah-An-Nas.mp3"
        )
    ),

    MEYSAM_TAMMAR(
        "میثم تمار",
        mapOf(
            "سوره یس" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/036.mp3",
            "سوره الرحمن" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/055.mp3",
            "سوره واقعه" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/056.mp3",
            "سوره جمعه" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/062.mp3",
            "سوره تبارک(ملک)" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/067.mp3",
            "سوره نبا" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/078.mp3",
            "سوره اعلی" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/087.mp3",
            "سوره شمس" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/091.mp3",
            "سوره قدر" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/097.mp3",
            "سوره زلزال" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/099.mp3",
            "سوره عادیات" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/100.mp3",
            "سوره کافرون" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/109.mp3",
            "سوره نصر" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/110.mp3",
            "سوره توحید" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/112.mp3",
            "سوره عصر" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/103.mp3",
            "سوره فلق" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/113.mp3",
            "سوره ناس" to "https://ia600107.us.archive.org/21/items/alfirdnbv54446i67656534323543544563432433_gmail_019_201801/114.mp3"
        )
    );

    fun getAudioUrl(prayKey: String): String =
        audioMap[prayKey] ?: throw IllegalArgumentException("No URL for '$prayKey' in $name")

}