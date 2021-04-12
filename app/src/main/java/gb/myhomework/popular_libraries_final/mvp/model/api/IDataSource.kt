package gb.myhomework.popular_libraries_final.mvp.model.api

import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IDataSource {

    @GET("planetary/apod")
    fun getNasaApods(
        @Query("api_key") apiKey: String,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String
    ): Single<List<NasaApod>>
}