package gb.myhomework.popular_libraries_final.mvp.presenter

import com.github.terrakok.cicerone.Router
import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod
import gb.myhomework.popular_libraries_final.mvp.model.repo.INasaApodRepo
import gb.myhomework.popular_libraries_final.mvp.navigation.IScreens
import gb.myhomework.popular_libraries_final.mvp.presenter.list.IApodsListPresenter
import gb.myhomework.popular_libraries_final.mvp.view.IStartFragmentView
import gb.myhomework.popular_libraries_final.mvp.view.list.IApodItemView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject
import javax.inject.Named

class StartPresenter :
    MvpPresenter<IStartFragmentView>() {

    @Inject
    @field:Named("uiScheduler")
    lateinit var uiScheduler: Scheduler

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    @Inject
    lateinit var retrofitNasaApodRepo: INasaApodRepo

    class ApodsListPresenter : IApodsListPresenter {
        val apods = mutableListOf<NasaApod>()
        override var itemClickListener: ((IApodItemView) -> Unit)? = null

        override fun bindView(view: IApodItemView) {
            val apod = apods[view.pos]
            view.setDate(apod.date)
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
            val apod = apodsListPresenter.apods[view.pos]
            router.navigateTo(screens.apod(apod))
        }
    }

    fun loadData() {
        retrofitNasaApodRepo.getNasaApods()
            .observeOn(uiScheduler)
            .subscribe({ repos ->
                apodsListPresenter.apods.clear()
                apodsListPresenter.apods.addAll(repos)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}