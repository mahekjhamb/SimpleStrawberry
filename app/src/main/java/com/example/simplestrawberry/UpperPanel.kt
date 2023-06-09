package com.example.simplestrawberry

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainContent(navController: NavController) {
    //val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF42135A))
    ) {
        Text(
            text = "Simple Strawberry",
            fontSize = 32.sp,
            color = Color(0xFFF41465),
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )
        Text(
            text = stringResource(id = R.string.location),
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 10.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = stringResource(id = R.string.desc_one),
                Modifier.fillMaxWidth(0.6f),
                color = Color.White, fontSize = 19.sp
            )
            Image(
                painter = painterResource(id = R.drawable.upperpanelimage),
                contentDescription = "",
                Modifier
                    .padding(end = 20.dp)
                    .clip(RoundedCornerShape(20.dp)),
            )
        }
        Button(
            onClick = {
                navController.navigate(Menu.route)
                //Toast.makeText(context, "Ordered Successfully!", Toast.LENGTH_LONG).show()
            },
            Modifier.padding(start = 20.dp, bottom = 20.dp),
            //border = BorderStroke(1.dp, Color.Magenta),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF41465))
        ) {
            Text(
                text = stringResource(id = R.string.order),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp, color = Color(0xFF333333)
            )
        }
        LowerPanel(navController)

    }
}

@Composable
fun TopAppBar() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { }
        ) {
            Image(
                painter = painterResource(id = R.drawable.navi_ic),
                contentDescription = "Menu Icon",
                modifier = Modifier
                    .size(60.dp)

            )
        }
        Image(
            painter = painterResource(id = R.drawable.linear_logo),
            contentDescription = "Simple Strawberry Logo",
            modifier = Modifier
                .fillMaxWidth(0.32f)
                .align(Alignment.Center)

        )
        IconButton(onClick = {}, modifier = Modifier.align(Alignment.CenterEnd)) {
            Box{
                Image(
                    painter = painterResource(id = R.drawable.ic_cart),
                    contentDescription = "Cart",
                    modifier = Modifier.size(60.dp)
                )
            }

        }
    }

}

@Composable
fun LowerPanel(navController: NavController) {
    Column {
        WeeklySpecial()
        menuDish(navController)
    }

}

@Composable
fun WeeklySpecial() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Weekly Special",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
    }
}
@Composable
fun menuDish(navController: NavController) {
    LazyColumn{
        items(Dishes){Dish-> MenuDish(Dish,navController)}
    }
}


@Preview(showBackground = true)
@Composable
fun TopAppBarPreview(){
    TopAppBar()
}