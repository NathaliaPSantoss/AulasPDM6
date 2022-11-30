package com.example.ativpeso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    Intent intent;
    TextView tvPedido;
    Button btnVoltar, btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        intent = getIntent();

        tvPedido = findViewById(R.id.tv_pedido);

        btnConfirmar = findViewById(R.id.btn_confirmar);
        btnVoltar = findViewById(R.id.btn_voltar);

    }

    public void telaResumo(View view){
        Intent i = new Intent(MainActivity4.this,MainActivity2.class);
        i.putExtra("resumo",intent.getStringExtra("informacao"));
        startActivity(i);
    }
}