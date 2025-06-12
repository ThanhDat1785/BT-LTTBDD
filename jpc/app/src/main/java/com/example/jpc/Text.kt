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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily.Companion.Cursive
import androidx.compose.foundation.layout.Spacer
import androidx.navigation.NavController

@Composable
fun TextScreen(navController: NavController) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()

    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        ) {
            IconButton(
                onClick = { navController.navigate("Screen_Menu") },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Blue
                )
            }
            Text("Text Detail",
                modifier = Modifier.align(Alignment.Center),
                fontWeight = FontWeight.Bold, fontSize = 20.sp,
                color = Color.Blue
            )
        }
        Spacer(modifier = Modifier.padding(top = 400.dp))
        Text(

            buildAnnotatedString {
                append("The ")
                withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough,
                        color = Color.Black
                    )
                ) {
                    append("quick ")
                }
                withStyle(SpanStyle(color = Color(0xFFB87333), fontWeight = FontWeight.Bold)) {
                    append("Brown\n")
                }
                withStyle(SpanStyle(color = Color.Black)) {
                    append("fox j u m p s ")
                }
                withStyle(SpanStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)) {
                    append("over\n")
                }
                withStyle(
                    style = SpanStyle(
                        textDecoration = TextDecoration.Underline,
                        color = Color.Black
                    )
                ) {
                    append("the ")
                }
                withStyle(
                    style = SpanStyle(
                        fontStyle = FontStyle.Italic,
                        color = Color.Black,
                        fontFamily = Cursive
                    )
                ) {
                    append("lazy ")
                }
                withStyle(SpanStyle(color = Color.Black)) {
                    append("dog.")
                }
            },
            fontSize = 30.sp,
            lineHeight = 36.sp,
            textAlign = TextAlign.Center
        )
    }
}

