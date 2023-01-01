package com.example.dict

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.example.dict.Screens.Home
import com.example.dict.Screens.Login
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
@ExperimentalMaterialApi
fun SetupNavGraph(navController: NavHostController){

    NavHost(navController = navController,
        startDestination =Screen.Login.route
    ){
        composable(route = Screen.Login.route){
            Login(navController = navController)
        }

        composable(route = Screen.Home.route){
            Home(navController = navController)
        }




    }

}