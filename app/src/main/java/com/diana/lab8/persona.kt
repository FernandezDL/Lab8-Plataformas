package com.diana.lab8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load

class persona(
    private val list:MutableList<Character>,
    private val listener: CharactersFragment
    ) : RecyclerView.Adapter<persona.ViewHolder>() {

    interface RecyclerPersonClickHandler{
        fun onPersonClicked(persona: Character)
    }

    class ViewHolder(private val view: View,
                     private val list3: RecyclerPersonClickHandler):RecyclerView.ViewHolder(view){

        private val characterGroup: ConstraintLayout = view.findViewById(R.id.itemRecycler_personsInformationGroup)
        private val characterName: TextView= view.findViewById(R.id.itemRecycler_name)
        private val characterProfilePic: ImageView= view.findViewById(R.id.itemRecycler_image)
        private val characterSpecies: TextView= view.findViewById(R.id.itemRecycler_description)
        private val characterInformation: TextView= view.findViewById(R.id.itemRecycler_information)

        fun showInformation(person: Character)
        {
            characterProfilePic.load(person.image)
            characterName.text=person.name
            characterSpecies.text= person.species
            characterInformation.text= person.status

            characterGroup.setOnClickListener{
                list3.onPersonClicked(person)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context)
            . inflate(R.layout.itemrecycler, parent, false)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(
            list[position]
        )
    }

    override fun getItemCount()= list.size
}