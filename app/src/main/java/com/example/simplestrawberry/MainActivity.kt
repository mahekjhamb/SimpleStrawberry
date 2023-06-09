package com.example.simplestrawberry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun MyNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home.route) {
        composable(Home.route) {
            MainContent(navController = navController)
        }
        composable(Menu.route) {
            MenuListScreen(navController)
        }
        composable(
            DishDetails.route + "/{${DishDetails.argDishId}}",
            arguments = listOf(navArgument(DishDetails.argDishId){
                type=NavType.IntType
            })
        ){
            val id= requireNotNull(it.arguments?.getInt(DishDetails.argDishId)){"Dish id is null"}
            DishDetails(id)
        }

    }
}

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            MyNavigation()
        }
    }
}
