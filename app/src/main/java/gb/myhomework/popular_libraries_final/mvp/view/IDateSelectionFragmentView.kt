package gb.myhomework.popular_libraries_final.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IDateSelectionFragmentView  : MvpView {
    fun dateSelection()
}