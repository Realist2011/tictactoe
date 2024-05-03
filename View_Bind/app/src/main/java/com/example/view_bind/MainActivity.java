package com.example.view_bind;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="Btn";
    TextView txt_count;
    Button btn_increment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_increment = findViewById(R.id.button)
                btn_increment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG, "onClick: ");
                        
                    }
                });
    }
    public void onButtonClicked(View v){
        Log.d(TAG, "onButtonClicked: ");
    }
}