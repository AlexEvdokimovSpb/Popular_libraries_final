package gb.myhomework.popular_libraries_final

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import gb.myhomework.popular_libraries_final.di.AppComponent
import gb.myhomework.popular_libraries_final.di.DaggerAppComponent
import gb.myhomework.popular_libraries_final.di.module.AppModule
import gb.myhomework.popular_libraries_final.mvp.model.entity.room.Database

class App : Application()  {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        Database.create(this)
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
    }
}