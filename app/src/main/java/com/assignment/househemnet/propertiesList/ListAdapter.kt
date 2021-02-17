package com.assignment.househemnet.propertiesList

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.househemnet.R
import com.assignment.househemnet.databinding.ItemPropertyAreaBinding
import com.assignment.househemnet.databinding.ItemPropertySaleBinding
import com.bumptech.glide.Glide
import java.lang.IllegalArgumentException

class ListAdapter(private val onItemClicked: (Item) -> Unit, private val context:Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var propertyItems: List<Item> = emptyList()

    companion object {
        private const val TYPE_PROPERTY = 0
        private const val TYPE_AREA = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_AREA -> AreaViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_property_area, parent, false)
            )

            TYPE_PROPERTY ->
                PropertyViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_property_sale, parent, false)
                )

            else -> throw IllegalArgumentException("Invalid View Type")

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AreaViewHolder -> holder.bind(propertyItems[position] as Area)
            is PropertyViewHolder -> holder.bind(propertyItems[position] as Property)
        }

        holder.itemView.setOnClickListener {
            onItemClicked(propertyItems[position])
        }
    }

    override fun getItemCount(): Int {
        return propertyItems.size
    }

    override fun getItemViewType(position: Int): Int {
        when (propertyItems[position]) {
            is Property -> return TYPE_PROPERTY
            is Area -> return TYPE_AREA
        }
        return super.getItemViewType(position)
    }

    fun setData(propertyItems: List<Item>) {
        this.propertyItems = propertyItems
        notifyDataSetChanged()
    }

    inner class PropertyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPropertySaleBinding.bind(itemView)

        fun bind(property: Property) {
            with(binding) {
                textViewAddress.text = property.streetAddress
                textViewArea.text = context.getString(R.string.area, property.livingArea)
                textViewLocation.text = context.getString(R.string.location, property.area, property.municipality)
                textViewPrice.text = property.askingPrice
                textViewDaysLeft.text = context.getString(R.string.days_on_hemnet, property.daysOnHemnet)
                textViewRooms.text = context.getString(R.string.rooms, property.numberOfRooms)
                Glide.with(itemView.context)
                    .load(property.image)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageView)

                if(property.type == ItemTypes.Property.name){
                    imageView.setBackgroundColor(Color.TRANSPARENT)
                }
            }
        }
    }

    inner class AreaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPropertyAreaBinding.bind(itemView)

        fun bind(area: Area) {
            with(binding) {
                textViewAddress.text = area.area
                textViewAveragePriceValue.text = area.averagePrice
                textViewGradeValue.text = area.rating
                Glide.with(itemView.context)
                    .load(area.image)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageView)
            }
        }
    }
}
