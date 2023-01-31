package com.example.mycomposeapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme

class Splash : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            callLoginContent(this)
        }
    }
}

@Composable
fun callLoginContent(context : Context) {
    Column(modifier = Modifier.fillMaxSize()
        .clickable(onClick = {
            context.startActivity(Intent(context,Login::class.java))
        }),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image(modifier = Modifier.height(200.dp)
            .width(200.dp),
            painter = painterResource(id = R.drawable.iconhome),
            contentDescription = null)

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MyComposeAppTheme {
       // callLoginContent()
    }
}