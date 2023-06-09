package com.example.simplestrawberry

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DishDetails(id: Int) {
    val dish = requireNotNull(getDish(id))
    Scaffold() {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(it)) {
            Image(
                painter = painterResource(id = dish.Image),
                contentDescription = "Dish image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = dish.name,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                fontSize = 40.sp
            )
            Text(text = dish.Desc, modifier = Modifier.padding(10.dp))
            Counter()
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF41465)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(text = "Add for ${dish.Price}")
            }


        }
    }
}

@Composable
fun Counter() {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        var counter by remember {
            mutableStateOf(1)
        }
        TextButton(onClick = { counter-- }) {
            Text(text = "-", style = MaterialTheme.typography.h2, fontSize = 40.sp)

        }
        Text(text = counter.toString(), style = MaterialTheme.typography.h2, fontSize = 40.sp)
        TextButton(onClick = { counter++ }) {
            Text(text = "+", style = MaterialTheme.typography.h2, fontSize = 40.sp)

        }
    }
}
