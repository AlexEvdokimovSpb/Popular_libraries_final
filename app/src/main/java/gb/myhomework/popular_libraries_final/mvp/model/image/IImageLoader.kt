package gb.myhomework.popular_libraries_final.mvp.model.image

interface IImageLoader<T> {
    fun load(url: String, container: T)
}