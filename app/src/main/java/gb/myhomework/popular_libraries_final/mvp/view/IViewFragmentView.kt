package gb.myhomework.popular_libraries_final.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IViewFragmentView : MvpView {
    fun setTitle(title: String)
    fun loadApod(url: String)
    fun setCopyright(copyright: String)
    fun setExplanation(explanation: String)
}