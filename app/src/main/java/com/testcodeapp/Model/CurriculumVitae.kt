package com.testcodeapp.Model

import com.beust.klaxon.Json

object CurriculumVitae {

    data class Skills(val title: String, val year: String, val description: String)

    data class Person(
        @Json(name = "name")
        val name: String,

        @Json(name = "age")
        val age: String,

        @Json(name = "direction")
        val direction: String,

        @Json(name = "email")
        val email: String,

        @Json(name = "phone_number")
        val phone_number: String,

        @Json(name="about_me")
        val about_me: String

        )
}