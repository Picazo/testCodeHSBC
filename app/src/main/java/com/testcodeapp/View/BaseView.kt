package app.kotlinapp

/**
 * Created by PicazoBc on 2/05/2019.
 * This class is planning to have a module app
 */
interface BaseView<T>{
    fun setPresenter(presenter:T)
}