package com.testcodeapp.Contract

import app.kotlinapp.BasePresenter
import app.kotlinapp.BaseView
import com.testcodeapp.Model.CurriculumVitae

interface ContractCV {

    interface View : BaseView<Presenter> {
        fun showToast(resultData: String)
        fun setData(name: String,age: String,direction: String,email: String,phone_number: String,about_me: String)

    }

    interface Presenter : BasePresenter {
        fun getCV(){
        }
    }
}

