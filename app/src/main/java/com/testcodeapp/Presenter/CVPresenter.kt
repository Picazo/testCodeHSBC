package com.testcodeapp.Presenter

import android.util.Log
import com.beust.klaxon.Klaxon
import com.testcodeapp.APIS.APIServices
import com.testcodeapp.Contract.ContractCV
import com.testcodeapp.Model.CurriculumVitae
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Collections.list


class CVPresenter(private val view: ContractCV.View): ContractCV.Presenter {
    companion object {
        val listSkills = ArrayList<CurriculumVitae.Skills>()
    }

    init {
        this.view.setPresenter(this)
    }

    val apiService by lazy {
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

                        var jsonObject = JSONObject(response.body().toString())
                        var jsonArray = jsonObject.getJSONArray("skills")

                        for (i in 0..(jsonArray.length() - 1)) {
                            val jsonObject1 = jsonArray.getJSONObject(i)
                            val newSkill = CurriculumVitae.Skills(jsonObject1.getString("title"), jsonObject1.getString("description"), jsonObject1.getString("time") )
                            listSkills.add(newSkill)
                        }


                    } else {
                        Log.i(
                            "onEmptyResponse",
                            "Returned empty response"
                        )
                    }
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                //TODO handle error code, then app doesnt have internt
            }
        })

    }
}