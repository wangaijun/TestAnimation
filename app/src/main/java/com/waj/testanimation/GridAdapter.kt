package com.waj.testanimation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.ImageView

class GridAdapter(val context: Context, val animations: ArrayList<Animation>) : RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val root = LayoutInflater.from(context).inflate(R.layout.item,p0,false)
        return Holder(root)
    }

    override fun getItemCount(): Int {
        return animations.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        val animation = animations[p1]
        p0.img.startAnimation(animation )
    }

}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val img = itemView.findViewById<ImageView>(R.id.imgItem)
}
