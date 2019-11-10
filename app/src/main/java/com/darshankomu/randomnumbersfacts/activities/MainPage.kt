package com.darshankomu.randomnumbersfacts.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.darshankomu.randomnumbersfacts.R
import kotlinx.android.synthetic.main.activity_main_page.*

class MainPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        card_trivia.setOnClickListener {

            val trivia = Intent(this@MainPage,TriviaActivity::class.java)
            startActivity(trivia)

        }

        card_year.setOnClickListener {

            val trivia = Intent(this@MainPage,YearActivity::class.java)
            startActivity(trivia)

        }

        card_date.setOnClickListener {

            val trivia = Intent(this@MainPage,DateActivity::class.java)
            startActivity(trivia)

        }

        card_math.setOnClickListener {

            val trivia = Intent(this@MainPage,MathActivity::class.java)
            startActivity(trivia)

        }

    }
}
