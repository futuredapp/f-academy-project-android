package app.futured.academyproject

import android.app.Application
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import app.futured.academyproject.ui.AppUI
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (app.futured.academyproject.BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}

@AndroidEntryPoint
class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppUI()
        }
    }
}
