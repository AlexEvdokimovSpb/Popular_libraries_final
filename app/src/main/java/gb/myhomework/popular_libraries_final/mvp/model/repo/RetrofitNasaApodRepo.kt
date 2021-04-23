package gb.myhomework.popular_libraries_final.mvp.model.repo

import gb.myhomework.popular_libraries_final.mvp.model.api.IDataSource
import gb.myhomework.popular_libraries_final.mvp.model.cache.INasaApodsCache
import gb.myhomework.popular_libraries_final.mvp.model.network.INetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitNasaApodRepo(
    val api: IDataSource,
    val networkStatus: INetworkStatus,
    val cache: INasaApodsCache
) : INasaApodRepo {

    val apiKey: String = "EaxuLo0zfMy3jNtz0N7jVa9sSOjpdcL2k7Tkbevz"
    var startDate: String = "2021-01-01"
    var endDate: String = "2021-01-10"

    override fun setData(year: Int, monthOfYear: Int, dayOfMonth: Int) {
        startDate = StringBuilder() // Месяц отсчитывается с 0, поэтому добавляем 1
            .append(year).append("-")
            .append(monthOfYear + 1).append("-")
            .append(dayOfMonth)
            .toString()
    }

    override fun setEndData(year: Int, monthOfYear: Int, dayOfMonth: Int) {
        endDate = StringBuilder()
            .append(year).append("-")
            .append(monthOfYear + 1).append("-")
            .append(dayOfMonth)
            .toString()
    }

    override fun getNasaApods() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getNasaApods(apiKey, startDate, endDate).flatMap { nasaApods ->
                cache.putNasaApods(nasaApods)
                Single.just(nasaApods)
            }
        } else {
            cache.getNasaApods()
        }
    }.subscribeOn(Schedulers.io())

}






