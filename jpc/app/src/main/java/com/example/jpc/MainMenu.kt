package com.example.jpc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ButtonDefaults


@Composable
fun MainMenu(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize() .padding(top=50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            "UI Components List",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFF007AFF)

        )
        Spacer(modifier = Modifier.height(16.dp))
        Column (
            modifier = Modifier.fillMaxSize().
            padding(start=10.dp),
            horizontalAlignment = Alignment.Start
        ){
            Text("Display", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {navController.navigate("Text_Detail")},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4),
                contentColor = Color.Black),
                modifier = Modifier.fillMaxWidth()
                    .padding(start=20.dp)
                    .padding(end=30.dp)) {
                Column(modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.Start){
                    Text("Text",fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text("Display text")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {navController.navigate("Image_Screen")},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4),
                    contentColor = Color.Black),
                modifier = Modifier.fillMaxWidth()
                    .padding(start=20.dp)
                    .padding(end=30.dp)) {
                Column(modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.Start){
                    Text("Image",fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text("Display an image")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text("Input", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {navController.navigate("Text_Field")},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4),
                    contentColor = Color.Black),
                modifier = Modifier.fillMaxWidth()
                    .padding(start=20.dp)
                    .padding(end=30.dp)) {
                Column(modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.Start){
                    Text("TextField",fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text("Input field for text")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4),
                    contentColor = Color.Black),
                modifier = Modifier.fillMaxWidth()
                    .padding(start=20.dp)
                    .padding(end=30.dp)) {
                Column(modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.Start){
                    Text("PasswordField",fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text("Input field for password")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text("Layout", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {navController.navigate("Column")},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4),
                    contentColor = Color.Black),
                modifier = Modifier.fillMaxWidth()
                    .padding(start=20.dp)
                    .padding(end=30.dp)) {
                Column(modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.Start){
                    Text("Column",fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text("Arranges elements vertically")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {navController.navigate("Row")},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4),
                    contentColor = Color.Black),
                modifier = Modifier.fillMaxWidth()
                    .padding(start=20.dp)
                    .padding(end=30.dp)) {
                Column(modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.Start){
                    Text("Row",fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text("Arranges elements horizontally")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCC8A82),
                    contentColor = Color.Black),
                modifier = Modifier.fillMaxWidth()
                    .padding(start=20.dp)
                    .padding(end=30.dp)) {
                Column(modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.Start){
                    Text("Tự tìm hiểu",fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text("Tìm ra các thành phần UI đơn giản")
                }
            }

        }
    }

}

