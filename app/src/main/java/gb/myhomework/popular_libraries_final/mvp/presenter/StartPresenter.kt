package gb.myhomework.popular_libraries_final.mvp.presenter

import com.github.terrakok.cicerone.Router
import gb.myhomework.popular_libraries_final.mvp.model.NasaApodRepo
import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod
import gb.myhomework.popular_libraries_final.mvp.navigation.IScreens
import gb.myhomework.popular_libraries_final.mvp.presenter.list.IApodsListPresenter
import gb.myhomework.popular_libraries_final.mvp.view.IStartFragmentView
import gb.myhomework.popular_libraries_final.mvp.view.list.IApodItemView
import moxy.MvpPresenter

class StartPresenter (val nasaApodRepo: NasaApodRepo, val router: Router, val screens: IScreens) :
    MvpPresenter<IStartFragmentView>() {

    class ApodsListPresenter : IApodsListPresenter {
        val apods = mutableListOf<NasaApod>()
        override var itemClickListener: ((IApodItemView) -> Unit)? = null

        override fun bindView(view: IApodItemView) {
            val apod = apods[view.pos]
            view.setTitle(apod.title)
        }

        override fun getCount() = apods.size
    }

    val apodsListPresenter = ApodsListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        apodsListPresenter.itemClickListener = { view ->
            val apod =apodsListPresenter.apods[view.pos]
            router.navigateTo(screens.apod(apod))
        }
    }

    fun loadData() {
        val apods = nasaApodRepo.getNasaApods()
        apodsListPresenter.apods.clear()
        apodsListPresenter.apods.addAll(apods)
        viewState.updateList()
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}