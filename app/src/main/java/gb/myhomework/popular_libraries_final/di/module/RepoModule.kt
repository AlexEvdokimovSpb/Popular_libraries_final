package gb.myhomework.popular_libraries_final.di.module

import dagger.Module
import dagger.Provides
import gb.myhomework.popular_libraries_final.mvp.model.api.IDataSource
import gb.myhomework.popular_libraries_final.mvp.model.cache.INasaApodsCache
import gb.myhomework.popular_libraries_final.mvp.model.network.INetworkStatus
import gb.myhomework.popular_libraries_final.mvp.model.repo.INasaApodRepo
import gb.myhomework.popular_libraries_final.mvp.model.repo.RetrofitNasaApodRepo
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun nasaApodsRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: INasaApodsCache
    ): INasaApodRepo = RetrofitNasaApodRepo(api, networkStatus, cache)
}