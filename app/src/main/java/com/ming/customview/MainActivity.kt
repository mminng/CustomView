package com.ming.customview

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view: CustomView = findViewById(R.id.customView)
        findViewById<TextView>(R.id.textView).setOnClickListener {
            view.resetCount()
            val random: Int = Random.nextInt(10..360)
            val propertyP: PropertyValuesHolder =
                PropertyValuesHolder.ofFloat(
                    "progress",
                    0F, random.toFloat()
                )
//            val propertyC: PropertyValuesHolder = PropertyValuesHolder.ofInt(
//                "BackgroundColor",
//                resources.getColor(R.color.purple_200),
//                resources.getColor(R.color.teal_700),
//            )
            val animator: ObjectAnimator =
                ObjectAnimator.ofPropertyValuesHolder(
                    view,
                    propertyP,
//                    propertyC
                )
            animator.duration = 3000
            animator.start()

//            val animatorT: ObjectAnimator =
//                ObjectAnimator.ofFloat(view, "progress", 0F, random.toFloat())
//            val animatorC: ObjectAnimator = ObjectAnimator.ofArgb(
//                view, "color",
//                resources.getColor(R.color.purple_200),
//                resources.getColor(R.color.teal_200),
//                resources.getColor(R.color.purple_200)
//            )
//
//            animatorT.duration = 3000
//            animatorC.duration = 3000
//            animatorT.start()
//            animatorC.start()
        }
    }
}