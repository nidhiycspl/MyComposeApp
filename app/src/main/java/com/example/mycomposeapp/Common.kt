package com.example.mycomposeapp

import android.app.Activity
import android.content.Context
import android.widget.Toast
import java.util.regex.Pattern

fun showToast(context: Context, message: String){
    Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
}

fun isEmailValid(email : String) : Boolean {
   val emailPattern =  Pattern.compile(
        "[a-zA-Z0-9+._%\\-]{1,256}"+"@"+"[a-zA-Z\\d][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+")
    return emailPattern.matcher(email).matches()
}