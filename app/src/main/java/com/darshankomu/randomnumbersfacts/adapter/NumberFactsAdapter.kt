package com.darshankomu.randomnumbersfacts.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.darshankomu.randomnumbersfacts.R
import com.darshankomu.randomnumbersfacts.activities.YearActivity
import com.darshankomu.randomnumbersfacts.model.pojo

class NumberFactsAdapter(private val context: Context, private val recipe: pojo?, private val itemClick: ItemClick,private var flag : Int) : RecyclerView.Adapter<NumberFactsAdapter.RecyclerViewAdapter>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerViewAdapter {

        val view = LayoutInflater.from(context).inflate(R.layout.number_fact_card, viewGroup, false)


        return RecyclerViewAdapter(view, itemClick)


    }


    override fun onBindViewHolder(holder: RecyclerViewAdapter, pos: Int) {

        val number_facts_data = recipe

        holder.number_title.text = "${number_facts_data!!.number}"

        holder.number_fact_text.text = "${number_facts_data.text}"




    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class RecyclerViewAdapter(itemView: View, var itemClick: ItemClick) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var number_title: TextView
        var number_fact_text: TextView
        var share_button_img : ImageView
        var card_background : CardView


        init {

            number_title = itemView.findViewById(R.id.number_title)
            number_fact_text = itemView.findViewById(R.id.number_facts)
            share_button_img = itemView.findViewById(R.id.share_img)
            card_background = itemView.findViewById(R.id.cardView)

            share_button_img.setOnClickListener(this)


            if(flag == 1)
            {
                card_background.setCardBackgroundColor(Color.parseColor("#FF00FB"))
            }
            if(flag == 2)
            {
                card_background.setCardBackgroundColor(Color.parseColor("#4736DC"))
            }

            if(flag == 3)
            {
                card_background.setCardBackgroundColor(Color.parseColor("#FF0077"))
            }

            if(flag == 4)
            {
                card_background.setCardBackgroundColor(Color.parseColor("#039BE5"))
            }

        }



        override fun onClick(v: View) {
            itemClick.onItemClick(v, adapterPosition)
        }




    }

    interface ItemClick {
        fun onItemClick(view: View, position: Int)
    }



}