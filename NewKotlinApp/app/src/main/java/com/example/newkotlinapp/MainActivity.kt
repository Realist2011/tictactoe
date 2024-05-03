package com.example.newkotlinapp

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newkotlinapp.ui.theme.NewKotlinAppTheme
/*import kotlinx.android.synthetic.main.activity_main.ed1
import kotlinx.android.synthetic.main.activity_main.ed2
import kotlinx.android.synthetic.main.activity_main.tvres*/

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewKotlinAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        val btnAdd:Button = findViewById(R.id.tvres)
        btnAdd.setOnClickListener(View.OnClickListener{
           // Toast.makeText(this@MainActivity,"Hello!",Toast.LENGTH_SHORT).show()
            val res = Binding.ed1.text.toString().toInt() + Binding.ed2.text.toString().toInt()
            Binding.tvres.text = res.toString()

        })
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewKotlinAppTheme {
        Greeting("Android")
    }
}