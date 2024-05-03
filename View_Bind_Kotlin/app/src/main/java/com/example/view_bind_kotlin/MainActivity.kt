package com.example.view_bind_kotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
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
import androidx.core.view.isVisible
import com.example.view_bind_kotlin.ui.theme.View_Bind_KotlinTheme

class MainActivity : ComponentActivity(), View.OnClickListener{

    //the id of a particular element cannot be found here
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val TextView = findViewById<TextView>(R.id.textView)
        TextView.text = "10"
        TextView.apply {
            isVisible = false

        }
        val editText = findViewById<TextView>(R.id.editText)

        editText.apply {
            text = "Satvik Bajaj"
            /*addTextChangedListener(
                Log.i("View Binding",watcher.toString())
            )*/
        }


        /* fun showToast(view: View) {
        Toast.makeText(view.context,"Button pressed",Toast.LENGTH_LONG).show()
    } Used as event handler*/
        val button: Button = findViewById<Button>(R.id.button);
        button.setOnClickListener {
            Toast.makeText(it.context, "Button pressed", Toast.LENGTH_LONG).show()
        }
        button.setOnClickListener(object: OnClickListener{
            override fun onClick(v:View){
                Toast.makeText(v.context, "Button pressed", Toast.LENGTH_LONG).show()

            }
        }

        override fun (v:View){
            Toast.makeText(v.context, "Button pressed", Toast.LENGTH_LONG).show()


        })
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
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
    View_Bind_KotlinTheme {
        Greeting("Android")
    }
}