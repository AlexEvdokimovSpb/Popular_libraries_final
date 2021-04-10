package gb.myhomework.popular_libraries_final.mvp.presenter

import com.github.terrakok.cicerone.Router
import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod
import gb.myhomework.popular_libraries_final.mvp.view.IViewFragmentView
import moxy.MvpPresenter

class ViewPresenter(val apod: NasaApod, val router: Router) :
    MvpPresenter<IViewFragmentView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.addText(apod.title)
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}