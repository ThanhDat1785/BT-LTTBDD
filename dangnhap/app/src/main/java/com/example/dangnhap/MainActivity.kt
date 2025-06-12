package com.example.dangnhap

import androidx.compose.material.icons.filled.Lock
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class RecoverViewModel : ViewModel() {
    var email by mutableStateOf("")
    var code by mutableStateOf("")
    var password by mutableStateOf("")
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: RecoverViewModel = viewModel()

            NavHost(navController, startDestination = "forget") {
                composable("forget") { Forgetpass(navController, viewModel) }
                composable("verify") { Verifycode(navController, viewModel) }
                composable("create") { Creatpass(navController, viewModel) }
                composable("confirm") { Confirm(navController, viewModel) }
            }
        }
    }
}

@Composable
fun Forgetpass(navController: NavHostController, viewModel: RecoverViewModel){
    var email by remember { mutableStateOf(viewModel.email) }

    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(id = R.drawable.uthlogo),
            contentDescription = "App Logo",
            modifier = Modifier.size(250.dp)
        )
        Text("SmartTasks", fontWeight = FontWeight.Bold,
            fontSize = 30.sp, color = Color.Blue)
        Spacer(modifier = Modifier.height(16.dp))

        Text("ForgetPassword ?",fontWeight = FontWeight.Bold,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Enter your email, we will send you a verification code.",fontWeight = FontWeight.Bold,
            fontSize = 15.sp,textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp))
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Your Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {  viewModel.email = email
                navController.navigate("verify")},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue, contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(50.dp)
        ) {
            Text("Next")
        }
    }
}

@Composable
fun Verifycode(navController: NavHostController, viewModel: RecoverViewModel) {
    val codeDigits = remember { mutableStateListOf("", "", "", "", "") }

    val focusRequesters = List(5) { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequesters.forEach { it.freeFocus() }
    }

    IconButton(onClick = { navController.navigate("forget")}, modifier = Modifier.padding(start = 10.dp, top = 20.dp)) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.uthlogo),
            contentDescription = "App Logo",
            modifier = Modifier.size(250.dp)
        )

        Text("SmartTasks", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Color.Blue)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Verify Code", fontWeight = FontWeight.Bold, fontSize = 30.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Enter the code we just sent you on your registered Email.",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            for (i in 0 until 5) {
                OutlinedTextField(
                    value = codeDigits[i],
                    onValueChange = { value ->
                        if (value.length <= 1 && value.all { it.isDigit() }) {
                            codeDigits[i] = value
                            if (value.isNotEmpty() && i < 4) {
                                focusRequesters[i + 1].requestFocus()
                            }
                        }
                    },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .focusRequester(focusRequesters[i]),
                    singleLine = true,
                    textStyle = LocalTextStyle.current.copy(
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {viewModel.code = codeDigits.joinToString("")
                navController.navigate("create")} ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue, contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(50.dp)
        ) {
            Text("Next")
        }
    }
}

@Composable
fun Creatpass(navController: NavHostController, viewModel: RecoverViewModel){
    var pass by remember { mutableStateOf("") }
    var repass by remember { mutableStateOf("") }
    IconButton(onClick = {navController.navigate("verify") }, modifier = Modifier.padding(start = 10.dp, top = 20.dp)) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black
        )
    }
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(id = R.drawable.uthlogo),
            contentDescription = "App Logo",
            modifier = Modifier.size(250.dp)
        )
        Text("SmartTasks", fontWeight = FontWeight.Bold,
            fontSize = 30.sp, color = Color.Blue)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Create new password",fontWeight = FontWeight.Bold,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Your new password must be different from previously used password.",fontWeight = FontWeight.Bold,
            fontSize = 15.sp,textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp))
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            label = { Text("Password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Lock Icon"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = repass,
            onValueChange = { repass = it },
            label = { Text("Confirm password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Lock Icon"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (pass == repass) {
                    viewModel.password = pass
                    navController.navigate("confirm")
                } else {

                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue, contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(50.dp)
        ) {
            Text("Next")
        }
    }
}

@Composable
fun Confirm(navController: NavHostController, viewModel: RecoverViewModel) {
    IconButton(onClick = {navController.navigate("create") }, modifier = Modifier.padding(start = 10.dp, top = 20.dp)) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.uthlogo),
            contentDescription = "App Logo",
            modifier = Modifier.size(250.dp)
        )
        Text("SmartTasks", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Color.Blue)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Confirm", fontWeight = FontWeight.Bold, fontSize = 30.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "We are here to help you!",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        val fieldStyle = LocalTextStyle.current.copy(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )

        OutlinedTextField(
            value = viewModel.email,
            onValueChange = {},
            label = { Text("Email") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon"
                )
            },
            enabled = false,
            textStyle = fieldStyle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = viewModel.code,
            onValueChange = {},
            label = { Text("Verification Code") },
            enabled = false,
            textStyle = fieldStyle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = viewModel.password,
            onValueChange = {},
            label = { Text("Password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Lock Icon"
                )
            },
            enabled = false,
            textStyle = fieldStyle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* handle submit */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue, contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(50.dp)
        ) {
            Text("Submit")
        }
    }
}
