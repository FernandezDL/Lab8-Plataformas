package com.diana.lab8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var toolBar: MaterialToolbar
    private lateinit var navController: NavController
    private lateinit var listOfPersons: MutableList<Character>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment= supportFragmentManager.findFragmentById(R.id.main_FragmentContainerView)
        as NavHostFragment

        navController= navHostFragment.navController

        val appBarConfigurations= AppBarConfiguration(navController.graph)

        toolBar= findViewById(R.id.main_toolBar)
        toolBar.setupWithNavController(navController, appBarConfigurations)

        setUpRecycler()
        listToNavGraph()
        setListeners()
    }

    private fun setUpRecycler(){
        listOfPersons= RickAndMortyDB.getCharacters()
    }

    private fun listToNavGraph(){
        navController.addOnDestinationChangedListener{_, destination, _ ->

            when(destination.id)
            {
                R.id.characterDetails2 ->
                {
                    toolBar.menu.findItem(R.id.menu_fromAToZ).isVisible= false
                    toolBar.menu.findItem(R.id.menu_fromZToA).isVisible=false
                }

                else ->
                {
                    toolBar.visibility= View.VISIBLE
                }
            }
        }
    }

    private fun setListeners(){
        toolBar.setOnMenuItemClickListener{
            when(it.itemId)
            {
                R.id.menu_fromAToZ-> {
                    listOfPersons.sortBy { Character -> Character.name }
                }

                R.id.menu_fromZToA -> {
                    listOfPersons.sortByDescending { Character -> Character.name }
                }
            }

            true
        }
    }
}