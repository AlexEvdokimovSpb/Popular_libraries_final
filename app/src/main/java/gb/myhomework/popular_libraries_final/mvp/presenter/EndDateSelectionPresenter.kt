package gb.myhomework.popular_libraries_final.mvp.presenter

import com.github.terrakok.cicerone.Router
import gb.myhomework.popular_libraries_final.mvp.model.repo.INasaApodRepo
import gb.myhomework.popular_libraries_final.mvp.navigation.IScreens
import gb.myhomework.popular_libraries_final.mvp.view.IDateSelectionFragmentView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class EndDateSelectionPresenter :
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

    private var endDate = GregorianCalendar()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.dateSelection()
    }

    fun setData(year: Int, monthOfYear: Int, dayOfMonth: Int) {

        var startDate = retrofitNasaApodRepo.getData()
        var lastDate = GregorianCalendar()


        endDate = GregorianCalendar(year, monthOfYear, dayOfMonth)
        if (endDate < startDate) {
            endDate = startDate
        }
        if (endDate >= lastDate) {
            lastDate.add(GregorianCalendar.DAY_OF_MONTH, -1)
            endDate = lastDate
        }

        retrofitNasaApodRepo.setEndData(endDate)
        router.navigateTo(screens.apods())
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}