package com.example.ativpeso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity3 extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = getIntent();
                Intent i = new Intent(MainActivity3.this,MainActivity4.class);
                i.putExtra("informacao", intent.getStringExtra("informacao"));
                startActivity(i);
            }
        }, 4000);
    }
}