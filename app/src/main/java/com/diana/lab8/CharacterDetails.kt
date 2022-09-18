package com.diana.lab8

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load

class CharacterDetails : Fragment(R.layout.fragment_character_details) {

    val args: CharacterDetailsArgs by navArgs()
    private lateinit var characterProfilePic:ImageView
    private lateinit var characterName: TextView
    private lateinit var characterSpecies: TextView
    private lateinit var characterStatus: TextView
    private lateinit var characterGender: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterProfilePic= view.findViewById(R.id.characterProfilePic)
        characterName= view.findViewById(R.id.characterName)
        characterSpecies= view.findViewById(R.id.contentSpecies)
        characterStatus= view.findViewById(R.id.contentStatus)
        characterGender= view.findViewById(R.id.contentGender)

        characterName.text=args.persona.name
        characterSpecies.text= args.persona.species
        characterStatus.text= args.persona.status
        characterGender.text=args.persona.gender

        characterProfilePic.load(args.persona.image)
    }
}