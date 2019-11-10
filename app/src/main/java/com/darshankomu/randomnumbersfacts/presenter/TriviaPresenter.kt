package com.darshankomu.randomnumbersfacts.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.darshankomu.randomnumbersfacts.R
import com.darshankomu.randomnumbersfacts.api.ApiClient
import com.darshankomu.randomnumbersfacts.api.ApiInterface
import com.darshankomu.randomnumbersfacts.model.pojo
import com.darshankomu.randomnumbersfacts.view.TriviaView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TriviaPresenter(private val view : TriviaView) {

    internal fun getTriviaData()
    {
        view.showLoading()

        val apiInterface = ApiClient.apiClient.create(ApiInterface::class.java)

        val call = apiInterface.get_trivia_facts

        call.enqueue(object : Callback<pojo>
        {

            override fun onResponse(call: Call<pojo>, response: Response<pojo>) {
                view.hideLoading()

                if(response.isSuccessful)
                {
                    view.getResult(response.body())
                }


            }

            override fun onFailure(call: Call<pojo>, t: Throwable) {
                view.hideLoading()
                view.onRequestError(t.localizedMessage!!)
            }

        })

    }



}
