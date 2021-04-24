package gb.myhomework.popular_libraries_final.mvp.model.repo

import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod
import io.reactivex.rxjava3.core.Single
import java.util.*

interface INasaApodRepo {
    fun getNasaApods(): Single<List<NasaApod>>
    fun setData(startData: GregorianCalendar)
    fun getData(): GregorianCalendar
    fun setEndData(endData: GregorianCalendar)
}