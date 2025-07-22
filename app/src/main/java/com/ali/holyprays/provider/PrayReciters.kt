package com.ali.holyprays.provider

enum class PrayReciters(
    val reciterDisplayName: String,
    private val audioMap: Map<String, String>
) {

    MOHSEN_FARAHMAND(
        "محسن فرهمند",
        mapOf(
            "دعای صباح" to "https://ahlolbait.com/files/u12/download/sabah-farahmand.mp3",
            "دعای کمیل" to "https://v.delgarm.com/mp3/804/2021/09/17/1631823486_Y7dW0.mp3",
            "دعای ندبه" to "https://ahlolbait.com/files/u12/download/nodbeh-farahmand.mp3",
            "دعای سمات" to "https://ahlolbait.com/files/u12/download/samat-farahmand.mp3",
            "دعای جوشن کبیر" to "https://dl.sevilmusics.com/cdn/music/svm/dua-joushan-kabir/Dua%20Joushan%20Kabir%20Mohsen%20Farahmand.mp3?_=9",
            "دعای توسل" to "https://ahlolbait.com/files/u12/download/tavassol-farahmand.mp3",
            "صلوات شعبانیه" to "https://faalchi.com/api/filedb/42c62ff7.mp3",
            "دعای افتتاح" to "https://dl.emadionline.com/fmd/Farahmand-Dua-Iftitah.mp3",
            "دعای سحر" to "https://dl.emadionline.com/fmd/Dua-Sahar-Farahmand.mp3",
            "زیارت عاشورا" to "https://ahlolbait.com/files/u12/download/ashoura-farahmand.mp3",
            "زیارت اربعین" to "https://v.delgarm.com/mp3/804/2021/09/18/1631983366_R0nG8.mp3",
            "زیارت آل یاسین" to "https://ahlolbait.com/files/u12/download/aleyasin-farahmand.mp3",
            "دعای فرج" to "https://dl.sevilmusics.com/cdn/music/svl/dua-faraj/Dua%20Faraj%20Mohsen%20Farahmand.mp3?_=11",
            "دعای عهد" to "https://ahlolbait.com/files/u12/download/ahd-farahmand.mp3",
            "دعای نور" to "https://dl.emadionline.com/fmd/Dua-Noor-Farahmand.mp3"
        )
    ),

    MEYSAM_MOTIE(
        "میثم مطیعی",
        mapOf(
            "دعای صباح" to "https://cdn.mashreghnews.ir/d/2022/04/04/4/3441819_128kb.mp3",
            "دعای کمیل" to "https://ahlolbait.com/files/u12/download/DoaKomeilMashhad1393%5B02%5D.mp3",
            "دعای ندبه" to "https://dl.emadionline.com/Dua/Motiee-%D9%90Dua-Nudba.mp3",
            "دعای سمات" to "https://iqna.ir/files/fa/news/1401/9/14/2758641_117.mp3",
            "دعای جوشن کبیر" to "https://cdn.mashreghnews.ir/d/2018/06/03/0/2263382.mp3",
            "صلوات شعبانیه" to "https://dl.emadionline.com/Munajat/Motiee-Meysam-Shabaniyah-Salawat.mp3",
            "دعای افتتاح" to "https://dl.emadionline.com/Dua/Motiei-Dua-Iftitah.mp3",
            "دعای سحر" to "https://cdn.mashreghnews.ir/d/2019/05/17/2/2516959_64kb.mp3",
            "زیارت عاشورا" to "https://khedmatgozaran.com/mag/wp-content/uploads/2024/10/mp3-ashoora-pilgrimage-with-the-voice-of-Meisam-Motiei.mp3",
            "زیارت اربعین" to "https://cdn.mashreghnews.ir/d/2019/10/19/0/2628091.mp3",
            "زیارت آل یاسین" to "https://cdn.mashreghnews.ir/d/2020/05/01/0/2783562.mp3",
            "دعای فرج" to "https://www.mohtavanashr.ir/wp-content/uploads/2025/03/4031222017.mp3",
            "دعای عهد" to "https://www.mohtavanashr.ir/wp-content/uploads/2025/03/4031222016.mp3",
            "دعای نور" to "https://kheimegah.com/motiee/voc/20%D8%B1%D9%85%D8%B6%D8%A7%D9%8698-%D8%AF%D8%B9%D8%A7%DB%8C-%D8%A8%D8%B3%D9%85-%D8%A7%D9%84%D9%84%D9%87-%D8%A7%D9%84%D9%86%D9%88%D8%B1-%D8%AF%D8%B9%D8%A7%DB%8C-%D8%AA%D8%A8/img/o/52/%D8%AD%D8%A7%D8%AC%20%D9%85%DB%8C%D8%AB%D9%85%20%D9%85%D8%B7%DB%8C%D8%B9%DB%8C_20%D8%B1%D9%85%D8%B6%D8%A7%D9%8698-%D8%AF%D8%B9%D8%A7%DB%8C%20%D8%A8%D8%B3%D9%85%20%D8%A7%D9%84%D9%84%D9%87%20%D8%A7%D9%84%D9%86%D9%88%D8%B1%20(%D8%AF%D8%B9%D8%A7%DB%8C%20%D8%AA%D8%A8)-1562392379.mp3"
        )
    ),

    ABOUZAR_HALVAJI(
        "اباذر حلواجی",
        mapOf(
            "دعای صباح" to "https://www.ziaossalehin.ir/sites/default/files/field/sound/Abazar-Alhalwachi-www.Ziaossalehin.ir-Dua-Sabah2021.mp3",
            "دعای کمیل" to "https://khedmatgozaran.com/mag/wp-content/uploads/2024/09/mp3-dua-kumay-with-the-voice-of-abazar-elhalvaji.mp3",
            "دعای ندبه" to "https://iqna.ir/files/fa/news/1402/11/10/3319702_406.mp3",
            "دعای سمات" to "https://dl.emadionline.com/Dua/Dua-Simaat-Halawaji.mp3",
            "دعای جوشن کبیر" to "https://dl.emadionline.com/Dua/Halwaji-Dua-Jaushan-Kabeer.mp3",
            "دعای توسل" to "https://dl.emadionline.com/Dua/Dua-Tawassul-al-Halawaji.mp3",
            "صلوات شعبانیه" to "https://www.ziaossalehin.ir/sites/default/files/field/sound/014-Abather-Alhalwachi-www.ziaossalehin.ir-Munajat-Shabaniyah.mp3",
            "دعای افتتاح" to "https://dl.emadionline.com/Dua/Dua-Iftitah-Al-Halawaji.mp3",
            "دعای سحر" to "https://dl.emadionline.com/Dua/Dua-Sahar-Halawaji.mp3",
            "زیارت عاشورا" to "https://khedmatgozaran.com/mag/wp-content/uploads/2024/10/mp3-ashoora-pilgrimage-with-the-voice-of-Abazar-Halwaji.mp3",
            "زیارت اربعین" to "https://dl.emadionline.com/Ziarat-Arbaeen/Abather-Alhalwachi-Ziyarat-Arbaeen.mp3",
            "زیارت آل یاسین" to "https://dl.emadionline.com/Dua/Abather-Al-Halawaji-Aale-Yasin.mp3",
            "دعای فرج" to "https://files.olgoirani.com/Files/Content/1398/12/3201/halavaji-faraj.mp3",
            "دعای عهد" to "https://dl.emadionline.com/Dua/Halawaji-Dua-Ahad.mp3",
            "دعای نور" to "https://mobyan.ir/Mobile/MediaGanj.aspx?ProductId=77&MediaId=B7B09803-9C9A-47E2-8DDE-4F4B8A0129A8"
        )
    );

    fun getAudioUrl(prayKey: String): String =
        audioMap[prayKey] ?: throw IllegalArgumentException("No URL for '$prayKey' in $name")

}