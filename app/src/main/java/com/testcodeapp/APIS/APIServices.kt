package com.testcodeapp.APIS

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

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