package com.codingka.tareasapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit

//fun LoginScreen(){
//    var email by remember {mutableStateOf("")}
//    var password by remember {mutableStateOf("")}
//    var passworVisible by remember {mutableStateOf(false)}
//
//    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center) {
//        Text("Your Logo", fontSize = 24.sp)
//        Spacer(modifier = Modifier.height(16.dp))
//        Text("Sign in", fontSize = 34.sp )
//        Spacer(modifier = Modifier.height(16.dp))
//        Text("If you don’t have an account register", fontSize = 16.sp)
//        TextButton(onClick = {
//            //Accion redirigir
//        }) { Text("register here!!", fontSize = 16.sp, color= MaterialTheme.colorScheme.primary) }
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Column(modifier = Modifier.height(100.dp).padding(16.dp),
//            ) {
//            OutlinedTextField(
//                value = email,
//                onValueChange = {email = it},
//                label = {Text("Enter your email address")},
//                modifier = Modifier.fillMaxWidth(),
//                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//
//            OutlinedTextField(
//                value = password,
//                onValueChange = {password = it},
//                label = {Text("Enter your password")},
//                modifier = Modifier.fillMaxWidth(),
//                visualTransformation = if(passworVisible) VisualTransformation.None else PasswordVisualTransformation(),
//                trailingIcon = {
//                    val image = if(passworVisible){
//                        Icons.Filled.Visibility
//                    }else{
//                        Icons.Filled.VisibilityOff
//                    }
//                    IconButton(onClick = {passworVisible =! passworVisible}) {
//                        Icon(imageVector = image, contentDescription = "password")
//                    }
//                }
//
//            )
//        }
//
//
//        Button(onClick = {},
//            modifier = Modifier.fillMaxWidth(),
//            colors = ButtonDefaults.buttonColors(backgroundColor= MaterialTheme.colorScheme.primary )) {
//            Text("Login")
//        }
//    }
//}