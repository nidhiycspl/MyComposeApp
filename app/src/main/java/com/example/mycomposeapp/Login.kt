package com.example.mycomposeapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeAppTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting2("Android")
//                }
                LoginScreenUi(this)
            }
        }
    }
}

@Composable
fun LoginScreenUi(context: Context) {
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()))
    {
        Column(modifier = Modifier
            .widthIn(300.dp)
            .align(Alignment.Center)
            .padding(30.dp))
        {
            Row(verticalAlignment = Alignment.CenterVertically)
            {

                Image(modifier = Modifier
                    .size(100.dp),
                    painter = painterResource(id = R.drawable.iconhome),
                    contentDescription = null,)
                
                Spacer(modifier = Modifier.width(10.dp))
                
                Text(text = stringResource(R.string.patta_survey_app),
                style = TextStyle(color = Color.Black,
                    fontSize = 20.sp,fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight(500))),
                    textAlign = TextAlign.Center))

            }

            Spacer(modifier = Modifier.height(36.dp))

            Text(stringResource(R.string.login), style = TextStyle(color = Color.Black,
                fontSize = 20.sp,fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight(400))),
                textAlign = TextAlign.Center))

            Spacer(modifier = Modifier.height(10.dp))

            Text(stringResource(R.string.enter_credentials), style = TextStyle(color = Color.Black,
                fontSize = 14.sp, textAlign = TextAlign.Center))

            Spacer(modifier = Modifier.height(20.dp))


            OutlinedTextField(
                modifier = Modifier
                .fillMaxWidth(),
                value = email.value ,
                onValueChange = {
                       email.value = it
                },
                label = { Text(text = "Email")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.baseline_email),
                        tint = Color(ContextCompat.getColor(context,R.color.black)),
                        contentDescription = null )

                },
                trailingIcon = {
                    IconButton(onClick = { }) {
                        Icon(modifier = Modifier.padding(end = 4.dp),
                            imageVector = Icons.Default.Clear,
                            contentDescription = null)
                    }
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = password.value ,
                onValueChange = {
                    password.value = it
                },
                label = { Text(text = "Password")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_password),
                        tint = Color(ContextCompat.getColor(context, R.color.black)),
                        contentDescription = null
                    )

                }

            )

            Spacer(modifier = Modifier.height(10.dp))

            Button( modifier = Modifier.fillMaxWidth(),

                onClick = {showToast(context,"Login button clicked")}) {
                Text(text = "Login")
            }



        }
    }

}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeAppTheme {
       // Greeting2("Android")
       // LoginScreenUi(context)
    }

}