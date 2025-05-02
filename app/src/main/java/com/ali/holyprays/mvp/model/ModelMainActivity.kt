package com.ali.holyprays.mvp.model

import java.time.LocalDate

class ModelMainActivity {

    fun currentSystemDayOfWeek(): Int = LocalDate.now().dayOfWeek.value

}