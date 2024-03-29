package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    GreetingImage(stringResource(R.string.happy_birthday_text) ,
                        stringResource(R.string.signature_text))
                }
            }
        }
    }
}
@Composable
fun GreetingText(message : String, from:String , modifier: Modifier=Modifier) {
    // Create a column so that texts don't overlap
    Column ( verticalArrangement = Arrangement.Center
        ,modifier=modifier.padding(8.dp))
    {
        Text(
            text = message,
            fontSize = 80.sp,
            lineHeight = 150.sp,
            textAlign= TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier= Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message : String, from:String , modifier: Modifier=Modifier){
    val image= painterResource(id = R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.7F
        )
        GreetingText(
            message=message,
            from=from,
            modifier= Modifier
                .fillMaxSize()
                .padding(8.dp)


        )
    }


}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    MyApplicationTheme {
        GreetingImage(stringResource(id = R.string.happy_birthday_text) , stringResource(id = R.string.signature_text))
    }
}