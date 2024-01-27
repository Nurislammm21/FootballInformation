package com.example.progressapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.progressapp.data.Information
import com.example.progressapp.data.InformationInterface
import com.example.progressapp.databinding.InfoOneItemBinding

class InformationAdapter(private val data: ArrayList<Information>,
                         private val informationInterface: InformationInterface
) : RecyclerView.Adapter<InformationAdapter.InformationViewHolder>() {


    inner class InformationViewHolder(private val binding: InfoOneItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(info: Information,informationInterface: InformationInterface) = with(binding){
            txtTitle.text = info.title
            descriptionTxt.text = info.description
            teamHeaderImageView.setImageResource(info.headerImageIdResource)
            learnMoreBtn.setOnClickListener{
                    informationInterface.onLearnMoreButton(adapterPosition)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationViewHolder {
        return InformationViewHolder(InfoOneItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: InformationViewHolder, position: Int) {
        holder.bind(data[position],informationInterface)
    }


}