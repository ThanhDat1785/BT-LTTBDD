package com.example.jpc

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.text.style.TextAlign
import coil3.compose.AsyncImage
import androidx.compose.ui.text.style.TextDecoration

@Composable

fun ImageScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ) {
            IconButton(
                onClick = {navController.navigate("Screen_Menu")},
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Blue
                )
            }
            Text(
                "Images",
                modifier = Modifier.align(Alignment.Center),
                fontWeight = FontWeight.Bold, fontSize = 20.sp,
                color = Color.Blue
            )
        }
        //Spacer(modifier = Modifier.padding(top = 10.dp))
            Image(
                painter = painterResource(id = R.drawable.uth),
                contentDescription = "Dog Image",
                modifier = Modifier
                    .height(350.dp)
                    .width(350.dp)
            )
            Text("In app", fontSize = 30.sp)

            AsyncImage(
                model = "https://giaothongvantaitphcm.edu.vn/wp-content/uploads/2024/06/ky-niem-36-nam-thanh-lap-truong-dai-hoc-giao-thong-van-tai-tphcm-560px.jpg",
                contentDescription = "uthschool",
                modifier = Modifier
                    .height(350.dp)
                    .width(350.dp)
            )
            Text("https://giaothongvantaitphcm.edu.vn/wp-content/uploads/2024/06/ky-niem-36-nam-thanh-lap-truong-dai-hoc-giao-thong-van-tai-tphcm-560px.jpg",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 12.dp),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                color = Color.Blue
            )


    }
}