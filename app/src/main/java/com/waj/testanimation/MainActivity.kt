package com.waj.testanimation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {
    private val animations = arrayListOf<Animation>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAnimation(this)
        mRvGrid.layoutManager = GridLayoutManager(this,2)
//        mRvGrid.adapter = GridAdapter
    }

    private fun initAnimation(context: Context){
        animations.add(AnimationUtils.loadAnimation(context,R.anim.anim_translate)) //平移动画
        animations.add(AnimationUtils.loadAnimation(context,R.anim.anim_scale)) //缩放动画
        animations.add(AnimationUtils.loadAnimation(context,R.anim.anim_rotate)) //旋转动画
        animations.add(AnimationUtils.loadAnimation(context,R.anim.anim_alpha)) //透明动画
        animations.add(AnimationUtils.loadAnimation(context,R.anim.anim_all)) //动画合集

        val anim = Rotate3dAnimation(0.0f, 720.0f, 100.0f, 0.0f, false) //自定义动画
        anim.duration = 2000
        animations.add(anim)
    }
}
