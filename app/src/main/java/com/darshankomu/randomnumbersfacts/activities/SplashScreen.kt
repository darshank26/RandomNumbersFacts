package com.darshankomu.randomnumbersfacts.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.darshankomu.randomnumbersfacts.R


class SplashScreen : AppCompatActivity() {

    lateinit var mImg: ImageView
    lateinit var mAppName: TextView
    lateinit var mAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions

        init()
        startSplashScreen()

    }

    private fun startSplashScreen() {
        startAnimation()
        val SPLASH_TIME_OUT = 3500
        Handler().postDelayed({
            startActivity(Intent(this@SplashScreen, MainPage::class.java))
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    private fun startAnimation() {
        mAnimation = AnimationUtils.loadAnimation(this@SplashScreen, R.anim.splash_zoom)
        mImg.startAnimation(mAnimation)
        //mAppName.startAnimation(mAnimation);
    }


    private fun init() {
        mImg = findViewById(R.id.splash_icon_img)
        mAppName = findViewById(R.id.app_name)
    }
}

