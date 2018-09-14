package br.org.venturus.venturusbootcamp

import android.app.Application
import br.org.venturus.venturusbootcamp.data.dataModule
import br.org.venturus.venturusbootcamp.domain.domainModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber
import kotlin.system.measureTimeMillis

class BootcampApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        val koinStartupTime = measureTimeMillis {
            startKoin(
                this, listOf(
                    dataModule,
                    domainModule,
                    appModule
                )
            )
        }
        Timber.d("Koin took $koinStartupTime to build")
    }
}
