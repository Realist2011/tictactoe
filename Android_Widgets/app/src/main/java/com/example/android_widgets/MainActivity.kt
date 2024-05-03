package com.example.android_widgets

import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioGroup
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
import com.example.android_widgets.ui.theme.Android_WidgetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main.xml)

        val checkbox = findViewById<CheckBox>(R.id.AA)
        checkbox.setOnCheckedChangeListener { buttonView, isChecked ->  }
        val radiog = findViewById<RadioGroup>(R.id.RG)
        radiog.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.radioButton ->{
                    Toast.makeText(this,"Item is now btn 1`",Toast.LENGTH_SHORT).show()
                }
                R.id.radioButton2 ->{
                    Toast.makeText(this,"Item is now button 2",Toast.LENGTH_SHORT).show()

                }
            }
        }

    }
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
    Android_WidgetsTheme {
        Greeting("Android")
    }
}*/