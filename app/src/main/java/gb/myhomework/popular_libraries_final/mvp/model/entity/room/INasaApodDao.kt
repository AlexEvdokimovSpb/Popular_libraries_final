package gb.myhomework.popular_libraries_final.mvp.model.entity.room

import androidx.room.*

@Dao
interface INasaApodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(nasaApod: RoomNasaApod)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg nasaApods: RoomNasaApod)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(nasaApods: List<RoomNasaApod>)

    @Update
    fun update(nasaApod: RoomNasaApod)

    @Update
    fun update(vararg nasaApods: RoomNasaApod)

    @Update
    fun update(nasaApods: List<RoomNasaApod>)

    @Delete
    fun delete(nasaApod: RoomNasaApod)

    @Delete
    fun delete(vararg nasaApods: RoomNasaApod)

    @Delete
    fun delete(nasaApods: List<RoomNasaApod>)

    @Query("SELECT * FROM RoomNasaApod")
    fun getAll(): List<RoomNasaApod>

    @Query("SELECT * FROM RoomNasaApod WHERE date = :date LIMIT 1")
    fun findByLogin(date: String): RoomNasaApod?
}