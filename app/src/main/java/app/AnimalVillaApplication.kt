package app

import android.app.Application
import app.AnimalVilla.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class AnimalVillaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidLogger(if (BuildConfig.DEBUG)org.koin.core.logger.Level.ERROR else org.koin.core.logger.Level.NONE)
            androidContext(this@AnimalVillaApplication)
            modules(appModule)
        }
    }
}