package com.example.qltv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThuVien()
        }
    }
}

@Composable
fun ThuVien() {
    var text by remember { mutableStateOf("") }
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Hệ thống", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text("Quản lý Thư viện", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text("Sinh viên", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }

        Text(
            "Sinh viên",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 20.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Nhập tên sinh viên") },
                modifier = Modifier
                    .weight(1f)
            )
            Button(onClick = { /* Thay đổi */ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White)) {
                Text("Thay đổi")
            }
        }
        Spacer(modifier = Modifier.height(70.dp))
        Text("Danh sách sách", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(start = 20.dp))
        Spacer(modifier = Modifier.height(40.dp))
        Box(modifier = Modifier
            .fillMaxWidth().padding(start = 30.dp, end = 30.dp)
            .height(100.dp)
            .background(Color(0xFFDCDCE1))){
            var checkedState by remember { mutableStateOf(false) }
            val n = 10  // số lượng sách dynamic
            val bookList = List(n) { index -> "Sách ${index + 1}" }
            val checkedStates = remember { mutableStateListOf(*Array(n) { false }) }

            LazyColumn(
                modifier = Modifier.padding(8.dp)
            ) {
                items(bookList.size) { index ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Checkbox(
                            checked = checkedStates[index],
                            onCheckedChange = { checkedStates[index] = it }
                        )
                        Text(bookList[index], fontSize = 16.sp)
                    }
                }
            }

        }
    }
}
