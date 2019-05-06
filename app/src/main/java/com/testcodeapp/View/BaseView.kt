package app.kotlinapp

/**
 * Created by PicazoBc on 2/05/2019.
 */
interface BaseView<T>{
    fun setPresenter(presenter:T)
}