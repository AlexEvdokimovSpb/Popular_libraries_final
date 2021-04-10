package gb.myhomework.popular_libraries_final.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IViewFragmentView : MvpView {
    fun addText(title: String)
}