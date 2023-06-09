package com.example.simplestrawberry

interface Destinations {
    val route: String
}

object Home : Destinations {
    override val route = "home"
}

object Menu : Destinations {
    override val route = "menu"
}
object DishDetails:Destinations{
    override val route="Dish"
    const val argDishId="DishId"
}