package com.widyaanalytic.moviecatalogue.ui.splash

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.widyaanalytic.moviecatalogue.R
import com.widyaanalytic.moviecatalogue.ui.home.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(mainLooper).postDelayed({
                startActivity(MainActivity())
        }, 3000)
    }
    private fun startActivity(activity: Activity) {
        val intent = Intent(this@SplashActivity, activity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}