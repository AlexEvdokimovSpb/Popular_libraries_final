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

    private var startDate = GregorianCalendar()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.dateSelection()
    }

    fun setData(year: Int, monthOfYear: Int, dayOfMonth: Int) {
        // Дата публикации первого изображения 1995-06-16
        val firstDate = GregorianCalendar(1995, 6, 16)
        // Текущая дата
        var lastDate = GregorianCalendar()

        startDate = GregorianCalendar(year, monthOfYear, dayOfMonth)
        if (startDate < firstDate) {
            startDate = firstDate
        }
        if (startDate >= lastDate) {
            lastDate.add(GregorianCalendar.DAY_OF_MONTH, -1)
            startDate = lastDate
        }

        retrofitNasaApodRepo.setData(startDate)
        router.navigateTo(screens.endDateSelection())
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}