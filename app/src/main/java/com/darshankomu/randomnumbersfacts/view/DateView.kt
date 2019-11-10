package com.darshankomu.randomnumbersfacts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.darshankomu.randomnumbersfacts.R
import com.darshankomu.randomnumbersfacts.model.pojo

interface DateView {

    fun showLoading()
    fun hideLoading()
    fun getResult(numberFacts: pojo?)
    fun showProgress()
    fun hideProgress()
    fun onRequestSuccess(message: String)
    fun onRequestError(message: String)

}