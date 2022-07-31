package app

import android.view.View
import android.view.Window
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class AppMethods{

    //Hides the system bars when app is running
    fun hideSystemBars(supportActionBar: android.app.ActionBar?, window: Window, findViewById: Any) {
        supportActionBar?.hide()
        val windowInsetsController =
            WindowCompat.getInsetsController(window, findViewById as View)
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }
}