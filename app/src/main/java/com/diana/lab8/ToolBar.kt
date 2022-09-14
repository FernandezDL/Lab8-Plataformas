package com.diana.lab8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController

class ToolBar : AppCompatActivity() {

    private lateinit var toolBar: ToolBar
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_tool_bar)

        val navigation = supportFragmentManager.findFragmentById(R.id.toolBarFragment_containerView)
                as NavigationFragment
        navController=navigation.navController

    }
}