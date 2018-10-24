package com.waj.testanimation

import android.graphics.Camera
import android.view.animation.Animation
import android.view.animation.Transformation

class Rotate3dAnimation(
    private val fromDegree: Float,
    private val toDegree: Float,
    private val centerX: Float,
    private val centerY: Float,
    private val depth: Float,
    private val reverse: Boolean) : Animation(){

    private lateinit var camera: Camera

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        camera = Camera()
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        val degree = fromDegree + (toDegree-fromDegree)*interpolatedTime
        val matrix = t?.matrix
        camera.save()

        //Z轴平移
        if (reverse){
            camera.translate(0f,0f,depth*interpolatedTime)
        }else{
            camera.translate(0f,0f,depth*(1-interpolatedTime))
        }

        //Y轴旋转
        camera.rotateY(degree)
        camera.getMatrix(matrix)
        camera.restore()

        //围绕View中心点进行旋转
        matrix?.preTranslate(-centerX,-centerY)
        matrix?.postTranslate(centerX,centerY)

        super.applyTransformation(interpolatedTime, t)
    }
}