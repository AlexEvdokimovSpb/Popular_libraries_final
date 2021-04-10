package gb.myhomework.popular_libraries_final.mvp.model

import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod

class NasaApodRepo {

    private val nasaApods = listOf(
        NasaApod("2021-01-01", "Gagarin1"),
        NasaApod("2021-01-02", "Gagarin2"),
        NasaApod("2021-01-03", "Gagarin3"),
        NasaApod("2021-01-04", "Gagarin4"),
        NasaApod("2021-01-05", "Gagarin5"),
        NasaApod("2021-01-06", "Gagarin6")

    )

    fun getNasaApods(): List<NasaApod> {
        return nasaApods
    }
}