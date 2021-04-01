package com.example.remvp4.util


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.remvp4.R
import com.example.remvp4.data.local.Property
import com.example.remvp4.ui.homePage.HomePageFragmentDirections



class PropertyAdapter : RecyclerView.Adapter<PropertyAdapter.ViewHolder>() {



    var data = listOf<Property>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }



    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)

        holder.qualityImage.setOnClickListener { view ->
            view.findNavController().navigate(
                HomePageFragmentDirections.actionHomePageFragmentToMainInputFragment(
                    property = item
                )
            )
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)

    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val projectName: TextView = itemView.findViewById(R.id.project_name)
        val qualityImage: ImageView = itemView.findViewById(R.id.property_image)

        fun bind(item: Property) {
            projectName.text = item.projectName
//            For use later when we change the image dynamically
//            val res = itemView.context.resources
//            qualityImage.setImageResource(R.drawable.ic_baseline_house_24)

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.property_item_view, parent, false)

                return ViewHolder(view)
            }
        }

    }

    class OnClickListener(val clickListener: (property: Property) -> Unit) {
        fun onClick(property: Property) = clickListener(property)
    }


}