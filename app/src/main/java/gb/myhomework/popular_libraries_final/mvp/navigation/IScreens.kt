package gb.myhomework.popular_libraries_final.mvp.navigation

import com.github.terrakok.cicerone.Screen
import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod

interface IScreens {
    fun apods(): Screen
    fun apod(nasaApod: NasaApod): Screen
    fun apodVideo(nasaApod: NasaApod): Screen
    fun dateSelection(): Screen
    fun endDateSelection(): Screen
}