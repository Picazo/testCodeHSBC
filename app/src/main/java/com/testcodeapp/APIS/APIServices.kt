package com.testcodeapp.APIS

import com.testcodeapp.Model.CurriculumVitae
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.Result
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface APIServices {

    @GET("CVJCPB.json")
    fun getCV(): Call<String>


    companion object{
        fun getCV():APIServices{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/Picazo/Test/master/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()

            return retrofit.create(APIServices::class.java)

        }
    }


}