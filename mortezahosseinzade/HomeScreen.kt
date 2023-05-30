package com.example.mortezahosseinzade

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var Name by remember { mutableStateOf("morteza.h") }
    var Pass by remember { mutableStateOf("1234") }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally ) {
        TextField(
            value = username,
            onValueChange = {username=it},
            label = { Text(text = "Enter Your UserName") },
        )
        TextField(
            value = password,
            onValueChange = {password=it},
            label = { Text(text = "Enter Your Password") },
        )
        val context = LocalContext.current
        Button(onClick = {
            if (password == Pass && username == Name) {
                Toast.makeText(context,"خوش آمدید", Toast.LENGTH_SHORT).show()
                navController.navigate(Second.Route)
            }
            else {
                Toast.makeText(context,"نام کاربری یا کلمه عبور اشتباه می باشد !", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Login")
        }
    }
}