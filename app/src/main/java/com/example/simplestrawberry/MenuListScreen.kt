package com.example.simplestrawberry

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuListScreen(navController: NavController) {
    Column {
        UpperHalf()
        LowerHalf(navController)
    }

}

@Composable
fun UpperHalf() {
    Column(
        modifier = Modifier
            .background(Color(0xFFF42135A))
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp, color = Color(0xFFF41465)
        )
    }
    Text(
        text = "Order For Takeaway",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
fun LowerHalf(navController: NavController) {
    Column {
        LazyRow {
            items(category) { category -> MenuCategory(category) }
        }
        Divider(modifier = Modifier.padding(start = 8.dp, end = 8.dp), color=Color(0xFFF41465), thickness = 1.dp)
        LazyColumn{
            items(Dishes){Dish-> MenuDish(Dish, navController)}
        }
    }

}

val category = listOf<String>(
    "Lunch", "Dessert", "A La Carte", "Mains", "Specials"
)

@Composable
fun MenuCategory(category: String) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        shape = RoundedCornerShape(40),
        modifier = Modifier.padding(5.dp)
    ) {
        Text(text = category)
    }
}

data class Dish(
    val id:Int,
    val name: String,
    val Price: String,
    val Desc: String,
    val Image: Int
)

val Dishes = listOf(
    Dish(
        1,
        "Greek Salad",
        "Rs 350",
        "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
        R.drawable.greeksalad
    ),
    Dish(
        2,
        "Bruschetta",
        "Rs 250",
        "Our Bruschetta is made from grilled bread that has been smeared with garlic...",
        R.drawable.bruschetta
    ),
    Dish(
        3,
        "Lemon Dessert",
        "Rs 350",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.lemondessert
    ),
    Dish(
        4,
        "Grilled Fish",
        "Rs 450",
        "Fish marinated in fresh orange and lemon juice. Grilled with orange and lemon wedges.",
        R.drawable.grilledfish
    ),
    Dish(
        5,
        "Pasta",
        "Rs 300",
        "Penne with fried aubergines, cherry tomatoes, tomato sauce, fresh chilli, garlic, basil & salted ricotta cheese.",
        R.drawable.pasta
    ),
    Dish(
        6,
        "Lasagne",
        "Rs 475",
        "Oven-baked layers of pasta stuffed with Bolognese sauce, béchamel sauce, ham, Parmesan & mozzarella cheese .",
        R.drawable.lasagne
    ),
    Dish(
        1,
        "Greek Salad",
        "Rs 350",
        "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
        R.drawable.greeksalad
    ),
    Dish(
        2,
        "Bruschetta",
        "Rs 250",
        "Our Brushetta is made from grilled bread that has been smeared with garlic...",
        R.drawable.bruschetta
    ),
    Dish(
        3,
        "Lemon Dessert",
        "Rs 350",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.lemondessert
    )
)
fun getDish(id:Int)= Dishes.firstOrNull{it.id==id}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuDish(Dish: Dish, navController: NavController) {
    Card(onClick = {navController.navigate(DishDetails.route+ "/${Dish.id}")}) {
        Row(
            modifier = Modifier
                .fillMaxSize( )
                .padding(8.dp)
        ) {
            Column {
                Text(text = Dish.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = Dish.Desc,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(0.75f)
                )
                Text(text = Dish.Price, color = Color.Gray, fontWeight = FontWeight.Bold)
            }
            Image(painter = painterResource(id = Dish.Image), contentDescription = " ")
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        color = Color.LightGray,
        thickness = 1.dp
    )
}
