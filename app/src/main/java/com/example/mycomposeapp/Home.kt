package com.example.mycomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycomposeapp.model.ListModel
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme


class Home : ComponentActivity() {
    var inputValue = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
//                uiContent(inputValue)
               recycleViewFun()
             //   animateVisibility()
            }
        }
    }
}

@Composable
fun animateVisibility(){
    var sizeState by remember{ mutableStateOf(200.dp) }
    val size by animateDpAsState(
        targetValue = sizeState,
        keyframes {
            durationMillis = 5000
            sizeState at 0 with LinearEasing
            sizeState * 1.5f at 1000  with FastOutLinearInEasing
            sizeState * 2f at 5000
        }
        /*spring(
            Spring.DampingRatioHighBouncy
        )*/
    )
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            tween(2000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(modifier = Modifier
        .background(color)
        .size(size),
    contentAlignment = Alignment.Center){
        
        Button(onClick = {
            sizeState += 50.dp

        }) {

        }
        
    }
}

@Composable
fun recycleViewFun(){
    /*LazyColumn{
        itemsIndexed(
            listOf("This","is","Jetpack","Compose")
        ){index,String ->
            recycleUi(index)
        }
    }*/
    var items by remember{ mutableStateOf(
        (1..20).map {
            ListModel(
                title = "Item $it",
                isSelected = false
            )
        }
    )}
    
    LazyColumn{
        items(items.size){ i->
            RecycleUi(model= items[i]){
                items = items.mapIndexed { index, item ->
               if(i == index){
                   item.copy(isSelected = it)
               }else{
                   item

               }
           }

            }
        }
    }


}

@Composable
fun UiContent(inputValue: String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        TextField(value = "dwdwdw",
            onValueChange = {
            }
        )
        
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { },) {

        }
    }

}

@Composable
fun RecycleUi(model: ListModel,onItemChange:(Boolean)->Unit ) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .clickable {
            onItemChange(model.isSelected.not())
        },
    elevation = 5.dp,
    backgroundColor = Color(0xFFF6F6F6)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween)
        {
            Text(model.title)
            if(model.isSelected){
                Icon(
                    imageVector = Icons.Default.Check ,
                    contentDescription = "Selected",
                    tint = Color.Green,
                    modifier = Modifier.size(20.dp))
            }
        }
    }
}



@Composable
fun HomeDrawer(){

}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    MyComposeAppTheme {
        HomeDrawer()
    }
}