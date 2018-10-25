package com.waj.testanimation

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.ImageView

class GridAdapter(private val context: Context, private val animations: ArrayList<Animation>
,private val frame:Int) : RecyclerView.Adapter<Holder>() {
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
                holder.img.startAnimation(animation )
            }
            6->{
                holder.img.setImageResource(frame)
                val drawable = holder.img.drawable as AnimationDrawable
                drawable.start()
            }
            7->{
                ViewWrapper.performWrapperAnimation(holder.img,10,500)
            }
            8->{
                ValueAnimatorWrapper.performListenerAnimator(holder.img,0,800)
            }
        }

    }

}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val img = itemView.findViewById<ImageView>(R.id.imgItem)
}
