package xyz.jalalkun.composebasicnavigation

import android.app.Application
import com.jalalkun.apiservice.RetrofitModule.retrofitModule
import com.jalalkun.apiservice.module.apiModule
import com.jalalkun.apiservice.module.repositoryModule
import com.jalalkun.apiservice.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApp)
            modules(listOf(
                //databaseModule,
                viewModelModule,
                apiModule,
                repositoryModule,
                retrofitModule
            ))

        }
    }
}