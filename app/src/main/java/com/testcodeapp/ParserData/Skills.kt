package com.testcodeapp.ParserData

import org.json.JSONObject

class Skills(json: String) : JSONObject(json) {
    val type: String? = this.optString("type")
    val data = this.optJSONArray("data")
        ?.let { 0.until(it.length()).map { i -> it.optJSONObject(i) } } // returns an array of JSONObject
        ?.map { Skills(it.toString()) } // transforms each JSONObject of the array into Foo
}

