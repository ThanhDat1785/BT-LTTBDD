package com.example.btth04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import com.example.btth04.ui.theme.BTTH04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BTTH04Theme {
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier.padding(30.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(top=10.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text("Trần Thành Đạt", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text("079205014572", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.padding(top = 150.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.jetpack),
                contentDescription = "Jetpack",
                modifier = Modifier.size(200.dp)
            )


            Text("Jetpack Compose", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(
                "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
                fontSize = 16.sp, textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(top = 400.dp))
        }
        Button(
            onClick = { navController.navigate("Screen_Menu") },
            shape = RoundedCornerShape(50),

            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("I'm ready", color = Color.White, fontSize = 16.sp)
        }
    }
}