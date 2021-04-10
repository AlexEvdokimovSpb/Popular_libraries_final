package gb.myhomework.popular_libraries_final.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod
import gb.myhomework.popular_libraries_final.mvp.navigation.IScreens
import gb.myhomework.popular_libraries_final.ui.fragment.StartFragment
import gb.myhomework.popular_libraries_final.ui.fragment.ViewFragment

class AndroidScreens : IScreens {
    override fun apods() = FragmentScreen { StartFragment.newInstance() }
    override fun apod(nasaApod: NasaApod) = FragmentScreen { ViewFragment.newInstance(nasaApod) }
}