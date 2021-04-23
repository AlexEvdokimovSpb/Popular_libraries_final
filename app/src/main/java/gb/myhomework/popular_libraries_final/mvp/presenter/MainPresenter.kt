package gb.myhomework.popular_libraries_final.mvp.presenter

import com.github.terrakok.cicerone.Router
import gb.myhomework.popular_libraries_final.mvp.navigation.IScreens
import gb.myhomework.popular_libraries_final.mvp.view.IMainView
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter : MvpPresenter<IMainView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.dateSelection())
    }

    fun backClicked() {
        router.exit()
    }

}
