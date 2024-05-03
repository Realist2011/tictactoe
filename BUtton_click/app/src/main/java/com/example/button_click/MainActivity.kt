package com.example.button_click

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.

class MainActivity : ComponentActivity() {
    private lateinit var binding:ActivityNew
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn2 = findViewById<>()
            }


    /*fun showToast(view: View) {
        Toast.makeText(this,"This button is clicked",Toast.LENGTH_SHORT).show( )
    }*/
}





/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BUtton_clickTheme {
        Greeting("Android")
    }
}*/