package com.example.madpractical8_20012011134

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var alarmimgs: ImageView
    lateinit var alarmimg_frameByFrameAnimation: AnimationDrawable
    lateinit var alarmimgAnimation: Animation
    lateinit var heartimgs: ImageView
    lateinit var heart_frameByFrameAnimation: AnimationDrawable
    lateinit var heartAnimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alarmimgs = findViewById(R.id.alarmImages)
        alarmimgs.setBackgroundResource(R.drawable.alarm_image_list)

        heartimgs = findViewById(R.id.heartImages)
        heartimgs.setBackgroundResource(R.drawable.heart_image_list)

        alarmimg_frameByFrameAnimation = alarmimgs.background as AnimationDrawable

        heart_frameByFrameAnimation = heartimgs.background as AnimationDrawable

        alarmimgAnimation = AnimationUtils.loadAnimation(this, R.anim.alarm_animation)
        alarmimgAnimation.setAnimationListener(this)

        heartAnimation = AnimationUtils.loadAnimation(this, R.anim.heart_animation)
        alarmimgAnimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if (hasFocus) {
            alarmimg_frameByFrameAnimation.start()
            alarmimgs.startAnimation(alarmimgAnimation)

            heart_frameByFrameAnimation.start()
            heartimgs.startAnimation(heartAnimation)
        }
    }



    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationRepeat(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        
    }
}

