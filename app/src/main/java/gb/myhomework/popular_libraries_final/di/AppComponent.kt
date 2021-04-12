package gb.myhomework.popular_libraries_final.di

import dagger.Component
import gb.myhomework.popular_libraries_final.di.module.*
import gb.myhomework.popular_libraries_final.mvp.presenter.MainPresenter
import gb.myhomework.popular_libraries_final.mvp.presenter.StartPresenter
import gb.myhomework.popular_libraries_final.mvp.presenter.ViewPresenter
import gb.myhomework.popular_libraries_final.ui.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        ApiModule::class,
        RepoModule::class,
        CacheModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(starPresenter: StartPresenter)
    fun inject(viewPresenter: ViewPresenter)
}