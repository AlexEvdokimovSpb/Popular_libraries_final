package gb.myhomework.popular_libraries_final.mvp.presenter.list

interface IListPresenter<V> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}