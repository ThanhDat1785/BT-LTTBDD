package com.example.jpc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

@Composable
fun ColumnScreen(navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 20.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ) {
            IconButton(
                onClick = {navController.navigate("Screen_Menu") },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Blue
                )
            }
            Text(
                "Column",
                modifier = Modifier.align(Alignment.Center),
                fontWeight = FontWeight.Bold, fontSize = 20.sp,
                color = Color.Blue
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFF5F0F0), shape = RoundedCornerShape(16.dp))
                .padding(horizontal = 30.dp, vertical = 30.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(color = Color(0xFFB2E5C5), shape = RoundedCornerShape(24.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(color = Color(0xFF66D18E), shape = RoundedCornerShape(24.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(color = Color(0xFFB2E5C5), shape = RoundedCornerShape(24.dp))
            )
        }
    }
}
