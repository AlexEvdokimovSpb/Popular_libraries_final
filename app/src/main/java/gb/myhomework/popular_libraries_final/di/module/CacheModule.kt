package gb.myhomework.popular_libraries_final.di.module

import androidx.room.Room
import dagger.Module
import dagger.Provides
import gb.myhomework.popular_libraries_final.App
import gb.myhomework.popular_libraries_final.mvp.model.cache.INasaApodsCache
import gb.myhomework.popular_libraries_final.mvp.model.cache.RoomNasaApodsCache
import gb.myhomework.popular_libraries_final.mvp.model.entity.room.Database
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun database(app: App) = Room.databaseBuilder(app, Database::class.java, Database.DB_NAME)
        .build()

    @Singleton
    @Provides
    fun nasaApodsCache(db: Database): INasaApodsCache = RoomNasaApodsCache(db)

}