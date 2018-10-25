package com.waj.testanimation

import android.content.Context

object Utils{
    fun dp2px(context: Context,dp:Int):Int{
        val scale = context.resources.displayMetrics.density
        return (dp*scale+0.5f).toInt()
    }
}