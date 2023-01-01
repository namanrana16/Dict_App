package com.example.dict

sealed class Screen(val route:String)
{
object Login:Screen(route ="login")
object Home:Screen(route ="home")

}
