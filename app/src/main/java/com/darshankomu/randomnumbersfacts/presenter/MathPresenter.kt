package com.darshankomu.randomnumbersfacts.presenter

import com.darshankomu.randomnumbersfacts.api.ApiClient
import com.darshankomu.randomnumbersfacts.api.ApiInterface
import com.darshankomu.randomnumbersfacts.model.pojo
import com.darshankomu.randomnumbersfacts.view.DateView
import com.darshankomu.randomnumbersfacts.view.MathView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MathPresenter(private val view : MathView) {

    internal fun getMathData()
    {
        view.showLoading()

        val apiInterface = ApiClient.apiClient.create(ApiInterface::class.java)

        val call = apiInterface.get_math_facts

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
