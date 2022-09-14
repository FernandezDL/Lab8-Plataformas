package com.diana.lab8

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar

class ToolBar : AppCompatActivity() {

    private lateinit var toolBar: MaterialToolbar
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_tool_bar)

        val navigation = supportFragmentManager.findFragmentById(R.id.toolBarFragment_containerView)
                as NavHostFragment

        navController=navigation.navController

        val appBarConfiguration= AppBarConfiguration(navController.graph)

        toolBar=findViewById(R.id.toolBar)
        toolBar= setupWithNavController(navController, appBarConfiguration)

        listenToNavGraphChanges()
    }

    private fun listenToNavGraphChanges() {

        navController.addOnDestinationChangedListener{_, destino, _ ->
            when(destino.id)
            {
                R.id.characterDetails2 ->
                {
                    toolBar.menu.findItem(R.id.menu_fromAToZ).isVisible= false
                    toolBar.menu.findItem(R.id.menu_fromZToA).isVisible= false
                }

                else ->
                {
                    toolBar.visibility= View.VISIBLE
                }
            }
        }
    }
}