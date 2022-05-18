package uk.co.planetbeyond.meal_search_clean_architecture

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import uk.co.planetbeyond.data.prefs.AppPrefs
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    ///@Inject lateinit var appPrefs: AppPrefs

    override fun onCreate() {
        super.onCreate()

       ///appPrefs.isFirstTime()
    }
}