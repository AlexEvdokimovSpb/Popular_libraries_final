package gb.myhomework.popular_libraries_final.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomNasaApod(
    val copyright: String?,
    @PrimaryKey
    val date: String,
    val explanation: String?,
    val hdurl: String?,
    val mediaType: String?,
    val serviceVersion: String?,
    val title: String?,
    val url: String?

    // Дополнительные поля
//    val resource: String? = null,
//    val concepts: String? = null,
//    val conceptTags: Boolean? = null,
//    val thumbnailUrl: String? = null
)