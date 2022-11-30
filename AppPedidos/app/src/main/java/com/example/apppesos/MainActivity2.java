package com.example.ativpeso;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    Intent i;
    TextView tvRecebido, tvPedido;
    Button btnVoltar, btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvRecebido = findViewById(R.id.tv_recebido);
        tvPedido = findViewById(R.id.tv_pedido);

        btnConfirmar = findViewById(R.id.btn_confirmar);
        btnVoltar = findViewById(R.id.btn_voltar);

        i = getIntent(); // agora tenho todos os extras oriundos da tela anterior
        if (i.hasExtra("resumo")){
            btnConfirmar.setVisibility(View.GONE);
            tvPedido.setText("Resumo do Pedido:");
            btnVoltar.setText("Novo Pedido");
            tvRecebido.setText(i.getStringExtra("resumo"));
        }
        else
            tvRecebido.setText(i.getStringExtra("informacao"));

    }

    public void primeiraTela(View view) {
        Intent i = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(i);
    }

    public void intro(View view){
        Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
        intent.putExtra("informacao", i.getStringExtra("informacao"));
        startActivity(intent);
    }
}