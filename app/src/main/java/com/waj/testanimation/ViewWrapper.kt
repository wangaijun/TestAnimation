package com.waj.testanimation

import android.animation.ObjectAnimator
import android.view.View

class ViewWrapper(val view:View){
    var width:Int
        get() = view.layoutParams.width
        set(value) {
            view.layoutParams.width = value
            view.requestLayout()
        }

    companion object {
        fun performWrapperAnimation(view:View, start:Int, end:Int){
            val vm = ViewWrapper(view)
            val animator = ObjectAnimator.ofInt(vm,"width",start,end)
            animator.duration = 2000
            animator.start()
        }
    }
}