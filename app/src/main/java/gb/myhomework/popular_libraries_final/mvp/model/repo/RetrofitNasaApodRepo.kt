package gb.myhomework.popular_libraries_final.mvp.model.repo

import android.util.Log
import gb.myhomework.popular_libraries_final.Constants
import gb.myhomework.popular_libraries_final.mvp.model.api.IDataSource
import gb.myhomework.popular_libraries_final.mvp.model.cache.INasaApodsCache
import gb.myhomework.popular_libraries_final.mvp.model.network.INetworkStatus
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitNasaApodRepo(
    val api: IDataSource,
    val networkStatus: INetworkStatus,
    val cache: INasaApodsCache
) : INasaApodRepo {

    val apiKey: String = "EaxuLo0zfMy3jNtz0N7jVa9sSOjpdcL2k7Tkbevz"
    val startDate: String = "2021-01-01"
    val endDate: String = "2021-01-03"

    val TAG = "HW " + RetrofitNasaApodRepo::class.java.simpleName

    override fun getNasaApods() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            if (Constants.DEBUG) {
                Log.v(TAG, "is online $api ")
            }
            api.getNasaApods(apiKey, startDate, endDate).flatMap { nasaApods ->
                if (Constants.DEBUG) {
                    Log.v(TAG, "is online startDate $startDate ")
                }
                cache.putNasaApods(nasaApods).toSingleDefault(nasaApods)
            }

        } else {
            if (Constants.DEBUG) {
                Log.v(TAG, "is not online $api ")
            }
            cache.getNasaApods()

        }
    }.subscribeOn(Schedulers.io())
}






