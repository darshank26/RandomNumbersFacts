package com.darshankomu.randomnumbersfacts.api
import com.darshankomu.randomnumbersfacts.model.pojo
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @get:GET("date?json")
    val get_day_facts: Call<pojo>

    @get:GET("year?json")
    val get_year_facts: Call<pojo>

    @get:GET("trivia?json")
    val get_trivia_facts: Call<pojo>

    @get:GET("math?json")
    val get_math_facts: Call<pojo>


}
