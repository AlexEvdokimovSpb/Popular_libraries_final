package gb.myhomework.popular_libraries_final.mvp.presenter

import com.github.terrakok.cicerone.Router
import gb.myhomework.popular_libraries_final.mvp.model.repo.INasaApodRepo
import gb.myhomework.popular_libraries_final.mvp.navigation.IScreens
import gb.myhomework.popular_libraries_final.mvp.view.IDateSelectionFragmentView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject
import javax.inject.Named

class DateSelectionPresenter :
    MvpPresenter<IDateSelectionFragmentView>() {

    @Inject
    @field:Named("uiScheduler")
    lateinit var uiScheduler: Scheduler

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    @Inject
    lateinit var retrofitNasaApodRepo: INasaApodRepo

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.dateSelection()
    }

    fun setData(year: Int, monthOfYear: Int, dayOfMonth: Int) {
        retrofitNasaApodRepo.setData(year, monthOfYear, dayOfMonth)
        router.navigateTo(screens.endDateSelection())
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}