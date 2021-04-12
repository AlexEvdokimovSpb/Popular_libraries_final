package gb.myhomework.popular_libraries_final.mvp.model.cache

import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface INasaApodsCache {
    fun putNasaApods(nasaApods: List<NasaApod>): Completable
    fun getNasaApods(): Single<List<NasaApod>>
}