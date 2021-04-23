package gb.myhomework.popular_libraries_final.mvp.model.repo

import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod
import io.reactivex.rxjava3.core.Single

interface INasaApodRepo {
    fun getNasaApods(): Single<List<NasaApod>>
    fun setData(year: Int, monthOfYear: Int, dayOfMonth: Int)
    fun setEndData(year: Int, monthOfYear: Int, dayOfMonth: Int)
}