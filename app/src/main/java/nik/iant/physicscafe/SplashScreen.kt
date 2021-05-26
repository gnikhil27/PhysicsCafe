package nik.iant.physicscafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import java.util.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //WindowManager.LayoutParams.FLAG_FULLSCREEN

        setContentView(R.layout.activity_splash_screen)
        setTheme(android.R.style.Theme_Light_NoTitleBar_Fullscreen)

        val blink  = AnimationUtils.loadAnimation(this,R.anim.blink)
        findViewById<ImageView>(R.id.splashImage).animation = blink
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },5000)

    }
}