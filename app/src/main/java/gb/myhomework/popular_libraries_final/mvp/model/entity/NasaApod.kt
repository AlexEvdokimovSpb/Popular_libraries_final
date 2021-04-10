package gb.myhomework.popular_libraries_final.mvp.model.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NasaApod(
    val dateNasaApod: String,
    val title: String
) : Parcelable