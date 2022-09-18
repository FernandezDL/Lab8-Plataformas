package com.diana.lab8

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharactersFragment : Fragment(R.layout.fragment_characters), persona.RecyclerPersonClickHandler {

    private lateinit var recyclerView: RecyclerView
    private lateinit var characterList: MutableList<Character>
    private lateinit var adapter: persona


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.character_list)
        setUpRecycler()
    }

    private fun setUpRecycler(){

        characterList= RickAndMortyDB.getCharacters()
        adapter= persona(characterList, this)

        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter= adapter

    }

    override fun onPersonClicked(persona: Character) {
        val action= CharactersFragmentDirections.actionCharactersFragmentToCharacterDetails2(persona)

        requireView().findNavController().navigate(action)
    }
}