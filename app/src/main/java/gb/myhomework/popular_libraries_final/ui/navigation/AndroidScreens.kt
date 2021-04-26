package gb.myhomework.popular_libraries_final.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod
import gb.myhomework.popular_libraries_final.mvp.navigation.IScreens
import gb.myhomework.popular_libraries_final.ui.fragment.*

class AndroidScreens : IScreens {
    override fun apods() = FragmentScreen { StartFragment.newInstance() }
    override fun apod(nasaApod: NasaApod) = FragmentScreen { ViewFragment.newInstance(nasaApod) }
    override fun apodVideo(nasaApod: NasaApod) = FragmentScreen { ViewVideoFragment.newInstance(nasaApod) }
    override fun dateSelection() = FragmentScreen { DateSelectionFragment.newInstance() }
    override fun endDateSelection() = FragmentScreen { EndDateSelectionFragment.newInstance() }
}