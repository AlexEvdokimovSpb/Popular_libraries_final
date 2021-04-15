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
        viewState.setTitle(apod.title)
        viewState.loadApod(apod.url)
        viewState.setCopyright(apod.copyright)
        viewState.setExplanation(apod.explanation)
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}