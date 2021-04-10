package gb.myhomework.popular_libraries_final.mvp.presenter

import com.github.terrakok.cicerone.Router
import gb.myhomework.popular_libraries_final.mvp.navigation.IScreens
import gb.myhomework.popular_libraries_final.mvp.view.IMainView
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<IMainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.apods())
    }

    fun backClicked() {
        router.exit()
    }

}
