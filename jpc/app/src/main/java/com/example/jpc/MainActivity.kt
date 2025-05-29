package com.example.jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController=navController, startDestination = "Screen", builder = {
                composable ("Screen"){ MainScreen(navController) }
                composable ("Screen_Menu"){ MainMenu(navController) }
                composable ("Text_Detail"){ TextScreen(navController) }
                composable ("Image_Screen"){ ImageScreen(navController) }
                composable ("Text_Field"){ TextField(navController) }
                composable ("Column"){ ColumnScreen(navController) }
                composable ("Row"){ RowScreen(navController) }

            })
        }
    }
}


