package com.waj.testanimation

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.Button
import android.widget.ImageView

class GridAdapter(private val context: Context, private val animations: ArrayList<Animation>
,private val frame:Int) : RecyclerView.Adapter<Holder>() {
    val texts = arrayOf("平移动画","缩放动画","旋转动画","透明动画","动画合集","自定义动画")
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val root = LayoutInflater.from(context).inflate(R.layout.item,p0,false)
        return Holder(root)
    }

    override fun getItemCount(): Int {
        return animations.size+3
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        when(position){
            in animations.indices->{
                val animation = animations[position]
                holder.btnPlay.text = texts[position]
                holder.btnPlay.setOnClickListener {
                    holder.img.startAnimation(animation )
                }
            }
            6->{
                holder.img.setImageResource(frame)
                holder.btnPlay.text = "帧动画"
                holder.btnPlay.setOnClickListener {
                    val drawable = holder.img.drawable as AnimationDrawable
                    drawable.start()
                }
            }
            7->{
                holder.btnPlay.text = "包装器模式"
                holder.btnPlay.setOnClickListener {
                    ViewWrapper.performWrapperAnimation(holder.img,10,500)
                }
            }
            8->{
                holder.btnPlay.text = "插值模式"
                holder.btnPlay.setOnClickListener {
                    ValueAnimatorWrapper.performListenerAnimator(holder.img,0,800)
                }
            }
        }

    }

}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val img = itemView.findViewById<ImageView>(R.id.imgItem)
    val btnPlay = itemView.findViewById<Button>(R.id.btnPlay)
}
