package ru.hardhill.loginactivity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@Composable
fun Register(navController: NavController) {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val nameValue = remember {mutableStateOf("")
    }
    val emailValue = remember {mutableStateOf("")
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
    
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter,) {
        Column() {
            
        }
    }

}