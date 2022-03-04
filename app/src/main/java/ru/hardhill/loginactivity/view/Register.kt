package ru.hardhill.loginactivity

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.hardhill.loginactivity.ui.theme.Purple500

@Composable
fun RegisterPage(navController: NavController) {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val nameValue = remember {
        mutableStateOf("")
    }
    val emailValue = remember {
        mutableStateOf("")
    }
    val phoneValue = remember {
        mutableStateOf("")
    }
    val passwordValue = remember {
        mutableStateOf("")
    }
    val confirmPasswordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_login),
                    contentDescription = "registration",
                    modifier = Modifier
                        .width(175.dp)
                        .height(175.dp),
                    contentScale = ContentScale.Fit,
                )
            }
            Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color.LightGray)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Sign Up", fontSize = 30.sp, fontWeight = FontWeight.Black)
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedTextField(
                            value = nameValue.value,
                            onValueChange = {
                                nameValue.value = it
                            },
                            label = { Text(text = "Name") },
                            placeholder = { Text(text = "Name") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                        OutlinedTextField(
                            value = emailValue.value,
                            onValueChange = {
                                emailValue.value = it
                            },
                            label = { Text(text = "Email address") },
                            placeholder = { Text(text = "Email address") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                        OutlinedTextField(
                            value = phoneValue.value,
                            onValueChange = {
                                phoneValue.value = it
                            },
                            label = { Text(text = "Email address") },
                            placeholder = { Text(text = "Email address") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        )
                        OutlinedTextField(
                            value = passwordValue.value,
                            onValueChange = {
                                passwordValue.value = it
                            },
                            label = { Text(text = "Password") },
                            placeholder = { Text(text = "Password") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        passwordVisibility.value = !passwordVisibility.value
                                    },
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_eye1),
                                        contentDescription = "Password Eye",
                                        tint = if (passwordVisibility.value) Purple500 else Color.Gray,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            },
                            visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
                        )
                        OutlinedTextField(
                            value = confirmPasswordValue.value,
                            onValueChange = {
                                confirmPasswordValue.value = it
                            },
                            label = { Text(text = "Confirm Password") },
                            placeholder = { Text(text = "Confirm Password") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                                    },
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_eye1),
                                        contentDescription = "Password Eye",
                                        tint = if (confirmPasswordVisibility.value) Purple500 else Color.Gray,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            },
                            visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        Button(onClick = {
                            if(nameValue.value.isEmpty()) Toast.makeText(context,"Please enter the name!",Toast.LENGTH_SHORT).show()
                            else if(emailValue.value.isEmpty()) Toast.makeText(context,"Please enter the email!",Toast.LENGTH_SHORT).show()
                            else if(phoneValue.value.isEmpty()) Toast.makeText(context,"Please enter the phone!",Toast.LENGTH_SHORT).show()
                            else if(passwordValue.value.isEmpty()) Toast.makeText(context,"Please enter the password!",Toast.LENGTH_SHORT).show()
                            else if(confirmPasswordValue.value.isEmpty()) Toast.makeText(context,"Please confirm the password!",Toast.LENGTH_SHORT).show()
                            else Toast.makeText(context,"Successfully Registered!",Toast.LENGTH_SHORT).show()
                        }) {
                            Text(text = "Sign Up", fontSize = 20.sp)
                        }
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(text = "Login instead", modifier = Modifier.clickable {
                            navController.navigate("login_page")
                        })

                    }
                }
            }
        }
    }

}