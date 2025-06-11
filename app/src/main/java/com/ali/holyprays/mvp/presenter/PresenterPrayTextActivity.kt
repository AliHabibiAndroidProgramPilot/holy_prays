package com.ali.holyprays.mvp.presenter

import android.util.Log
import com.ali.holyprays.mvp.ext.ActivityLifecycle
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.model.ModelPrayTextActivity
import com.ali.holyprays.mvp.view.ViewPrayTextActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PresenterPrayTextActivity(
    private val view: ViewPrayTextActivity,
    private val model: ModelPrayTextActivity,
    private val utils: ActivityUtils
) : ActivityLifecycle {

    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    override fun presenterOnCreate() {
        view.setInsetsAndUiColor()
        providePrayText(view.provideFilesPath(), view.providePrayPersianTranslationFilePath())
        view.navigationBackHandler()
        view.setToolbarText()
        view.manageRecyclerScroll()
        view.initPersianTranslationButton()
        view.initDarkModeButton {
            val isDarkModeEnabled = model.toggleDarkMode()
            view.darkModeButtonUiStateChanger(isDarkModeEnabled)
        }
        view.initPlusAndMinusTextSizeButtons()
    }

    private fun providePrayText(prayFilePath: String, prayPersianTranslationFilePath: String) {
        scope.launch {
            try {
                val context = utils.takeContext()
                val arabicFileContent = model.readPrayTextFileFromAsset(context, prayFilePath)
                val persianFileContent = model.readPrayPersianTranslationFileFromAsset(
                    context,
                    prayPersianTranslationFilePath
                )
                view.setupRecyclerViewData(arabicFileContent, persianFileContent)
//                view.darkModeButtonUiStateChanger(model.initDarkModePrefs())
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("EXCEPTION", "failed to load file")
            }
        }
    }

    override fun presenterOnDestroy() {
        if (job.isActive)
            job.cancel()
    }

}