package com.example.dict.Screens

import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dict.Screen

@Composable
fun Login(navController: NavHostController){

// for Login check

    val LoginViewModel:LoginViewModel= hiltViewModel()







    LoginScreen(navController = navController,LoginViewModel)

}


@Composable
fun LoginScreen(navController: NavHostController,LoginViewModel: LoginViewModel){

    val focusManager = LocalFocusManager.current

    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }

    val isEmailValid by derivedStateOf {
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    val isPasswordValid by derivedStateOf{
        password.length >7
    }

    var isPasswordVisible by remember{
        mutableStateOf(false)
    }
    LoginViewModel.auth(email,password)
    Column(
        modifier= Modifier
            .background(color = Color.LightGray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Text(
            text= "LOGIN",
            fontFamily= FontFamily.SansSerif,
            fontWeight= FontWeight.Bold,
            fontStyle= FontStyle.Italic,
            fontSize=32.sp,
            modifier= Modifier.padding(top=16.dp)
        )



        Card(
            modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            shape= RoundedCornerShape(16.dp),
            border= BorderStroke(1.dp, Color.Black)
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier= Modifier.padding(all=10.dp)
            ){
                OutlinedTextField(value = email,
                    onValueChange = { email=it},
                    label={ Text("Email Address") },
                    placeholder={ Text("abc@domain.com") },
                    singleLine=true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext={ focusManager.moveFocus(FocusDirection.Down)}
                    ),
                    isError=!isEmailValid,
                    trailingIcon={
                        if (email.isNotBlank()){
                            IconButton(onClick = { email="" }) {
                                Icon(imageVector = Icons.Filled.Clear,
                                    contentDescription = "Clear Email")
                            }
                        }
                    }
                )

                OutlinedTextField(value = password,
                    onValueChange = { password=it},
                    label={ Text("Password") },
                    singleLine=true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone={ focusManager.clearFocus()}
                    ),
                    isError=!isPasswordValid,
                    trailingIcon = {
                        IconButton(onClick ={isPasswordVisible=!isPasswordVisible}){
                            androidx.compose.material.Icon(
                                imageVector = if (isPasswordVisible) Icons.Default.Done else Icons.Default.Clear,
                                contentDescription = "Toggle password visibility"
                            )
                        }
                    },
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
                )

                Button(onClick = { checkLogin(navController, LoginViewModel) },
                    modifier= Modifier.fillMaxWidth(),
                    colors= ButtonDefaults.buttonColors(backgroundColor = Color.Green)) {
                    Text(
                        text="Log in",
                        fontWeight = FontWeight.Bold,
                        color= Color.Black,
                        fontSize=16.sp
                    )
                }

            }

        }

    }

}



fun checkLogin(navController: NavHostController, LoginViewModel: LoginViewModel){


    val state =LoginViewModel.state.value

    Log.d("auth", state)

    if(state != "error" && state.isNotEmpty()){
        navController.navigate(Screen.Home.route)

    }




}