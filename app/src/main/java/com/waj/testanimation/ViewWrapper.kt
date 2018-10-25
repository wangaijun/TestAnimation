package com.waj.testanimation

import android.animation.ObjectAnimator
import android.view.View

class ViewWrapper(val view:View){
    var width:Int
        get() = view.layoutParams.width
        set(value) {view.layoutParams.width = value}

    companion object {
        public fun performWrapperAnimation(view:View, start:Int, end:Int){
            val vm = ViewWrapper(view)
            ObjectAnimator.ofInt(vm,"width",start,end)
        }
    }
}