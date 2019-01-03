package com.example.kathishan.accessendpointdata

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_pass.view.*


class PopulationAdapter : RecyclerView.Adapter<PopulationAdapter.PopulationViewHolder>() {

    private val data = arrayListOf<Response>()


    fun setData(items: List<Response>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopulationViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pass, parent, false)
        return PopulationViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: PopulationViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }


    class PopulationViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(popData: Response) {
            view.tvCountry.text = popData.country.toString()
            view.tvAge.text = popData.age.toString()
        }

    }
}