package gb.myhomework.popular_libraries_final.mvp.presenter

import com.github.terrakok.cicerone.Router
import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod
import gb.myhomework.popular_libraries_final.mvp.view.IViewFragmentView
import moxy.MvpPresenter
import javax.inject.Inject

class ViewPresenter(val apod: NasaApod) :
    MvpPresenter<IViewFragmentView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        apod.title?.let { viewState.setTitle(it) }
        apod.url?.let { viewState.loadApod(it) }
        apod.copyright?.let { viewState.setCopyright(it) }
        apod.explanation?.let { viewState.setExplanation(it) }
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}