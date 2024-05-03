package com.example.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
import com.example.intents.ui.theme.IntentsTheme

const val key1 = "name"
const val key2 = "age"
const val key3 = "isStudent"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.mail)
        val txt = findViewById<EditText>(R.id.editTextText)
        btn.setOnClickListener{
            val email = txt.toString()
            val i = Intent()
            i.action = Intent.ACTION_SENDTO
            i.data = Uri.parse("mailto:$email")
            i.putExtra(Intent.EXTRA_SUBJECT,"iMPLICIT INTENTS")
            startActivity(i)


        }

       /* val i = intent.getStringExtra()*/
        /*val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            val i = Intent(this,MainActivity2::class.java)
            i.putExtra(key1,"satvik")
            startActivity(i)
    }*/
}}

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
    IntentsTheme {
        Greeting("Android")
    }
}*/