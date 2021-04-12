package gb.myhomework.popular_libraries_final.mvp.model.cache

import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod
import gb.myhomework.popular_libraries_final.mvp.model.entity.room.Database
import gb.myhomework.popular_libraries_final.mvp.model.entity.room.RoomNasaApod
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RoomNasaApodsCache(val db: Database) : INasaApodsCache {

    override fun putNasaApods(nasaApods: List<NasaApod>) = Completable.fromAction {
        val roomNasaApods = nasaApods.map { nasaApod ->
            RoomNasaApod(
                nasaApod.copyright,
                nasaApod.date,
                nasaApod.explanation,
                nasaApod.hdurl,
                nasaApod.mediaType,
                nasaApod.serviceVersion,
                nasaApod.title,
                nasaApod.url
//                nasaApod.resource,
//                nasaApod.concepts,
//                nasaApod.conceptTags,
//                nasaApod.thumbnailUrl
            )
        }
        db.nasaApodDao.insert(roomNasaApods)
    }.subscribeOn(Schedulers.io())


    override fun getNasaApods() = Single.fromCallable {
        db.nasaApodDao.getAll().map { roomNasaApod ->
            NasaApod(
                roomNasaApod.copyright,
                roomNasaApod.date,
                roomNasaApod.explanation,
                roomNasaApod.hdurl,
                roomNasaApod.mediaType,
                roomNasaApod.serviceVersion,
                roomNasaApod.title,
                roomNasaApod.url
//                roomNasaApod.resource,
//                roomNasaApod.concepts,
//                roomNasaApod.conceptTags,
//                roomNasaApod.thumbnailUrl
            )
        }
    }.subscribeOn(Schedulers.io())
}

