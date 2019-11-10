package com.darshankomu.randomnumbersfacts.activities

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.darshankomu.randomnumbersfacts.R
import com.darshankomu.randomnumbersfacts.adapter.NumberFactsAdapter
import com.darshankomu.randomnumbersfacts.model.pojo
import com.darshankomu.randomnumbersfacts.presenter.DatePresenter
import com.darshankomu.randomnumbersfacts.presenter.TriviaPresenter
import com.darshankomu.randomnumbersfacts.view.DateView
import com.darshankomu.randomnumbersfacts.view.TriviaView

class DateActivity : AppCompatActivity(), DateView {


    lateinit var recyclerView: RecyclerView
    lateinit var swipeRefresh: SwipeRefreshLayout
    lateinit var datePresenter: DatePresenter
    lateinit var itemShareLinkClick: NumberFactsAdapter.ItemClick
    lateinit var mProgressDialog: ProgressDialog

    lateinit var mPojo: pojo
    lateinit var mNumberFactsAdapter : NumberFactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trivia)

        recyclerView = findViewById(R.id.recycler_view)
        swipeRefresh = findViewById(R.id.swipe_refresh)
        recyclerView.layoutManager = LinearLayoutManager(this)


        datePresenter = DatePresenter(this)


        datePresenter.getDateData()


        swipeRefresh.setOnRefreshListener {


            datePresenter.getDateData()


        }

        itemShareLinkClick = object : NumberFactsAdapter.ItemClick {
            override fun onItemClick(view: View, position: Int) {

                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"

                intent.putExtra(Intent.EXTRA_TEXT,"\n"+mPojo.text)
                intent.putExtra(Intent.EXTRA_SUBJECT, mPojo.number)

                startActivity(Intent.createChooser(intent, "Share..."))

                startActivity(intent)

            }

        }

    }


    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing =false
    }

    override fun getResult(numberFacts: pojo?) {
        mNumberFactsAdapter = NumberFactsAdapter(this, numberFacts, itemShareLinkClick,3)
        mNumberFactsAdapter.notifyDataSetChanged()
        recyclerView.adapter = mNumberFactsAdapter
        mPojo = numberFacts!!
    }

    override fun showProgress() {
        mProgressDialog.show()
    }

    override fun hideProgress() {
        mProgressDialog.dismiss()
    }

    override fun onRequestSuccess(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun onRequestError(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    private fun checkConnection(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null

    }

    override fun onResume() {
        super.onResume()

        if(!checkConnection())
        {
            showMessage("Connection Problem!!..","May be you are not connected to internet , Try connecting on internet and try again.. ")
        }
    }

    private fun showMessage(title: String, message: String) {
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which -> dialog.dismiss()}
        builder.setCancelable(false)
        builder.show()
    }

}


