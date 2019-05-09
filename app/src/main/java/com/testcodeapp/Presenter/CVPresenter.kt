package com.testcodeapp.Presenter

import android.util.Log
import com.beust.klaxon.Klaxon
import com.testcodeapp.APIS.APIServices
import com.testcodeapp.Contract.ContractCV
import com.testcodeapp.Model.CurriculumVitae
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CVPresenter(private val view: ContractCV.View): ContractCV.Presenter {


    var disposable: Disposable? = null

    init {
        this.view.setPresenter(this)
    }

    // instance of interface created for Retrofit API calls
    val apiService by lazy {
        //initializing Retrofit stuff
        APIServices.getCV()
    }

    override fun start() {
    }

    override fun getCV() {

        val call = apiService

        call.getCV().enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.i("Responsestring", response.body().toString())
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString())

                        var result = Klaxon()
                            .parse<CurriculumVitae.Person>(response.body().toString())

                        result?.name?.let { view.setData(it,result?.age,result.direction,result.email,result.phone_number,result.about_me) }
                    } else {
                        Log.i(
                            "onEmptyResponse",
                            "Returned empty response"
                        )
                    }
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {

            }
        })

    }

    fun showResult(result: String){
        view.showToast(result)
    }

    fun showError(error : String){

    }


}