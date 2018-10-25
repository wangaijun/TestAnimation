package com.waj.testanimation

import android.animation.IntEvaluator
import android.animation.ValueAnimator
import android.view.View

object ValueAnimatorWrapper{
    fun performListenerAnimator(view: View, start: Int, end: Int) {
        val valueAnimator = ValueAnimator.ofInt(1,100)
        valueAnimator.addUpdateListener(object : ValueAnimator.AnimatorUpdateListener{
            private val evaluator = IntEvaluator()
            override fun onAnimationUpdate(animation: ValueAnimator?) {
                val currentValue = animation?.animatedValue
                val fraction = animation?.animatedFraction!!
                view.layoutParams.width = evaluator.evaluate(fraction,start,end)
                view.requestLayout()
            }
        })
        valueAnimator.setDuration(2000).start()
    }
}