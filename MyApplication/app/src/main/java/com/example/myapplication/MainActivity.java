package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvDicas;
    Spinner spnTempo;
    ArrayList<String> dicasFDS;
    Button btnDicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDicas = findViewById(R.id.tvDicas);
        spnTempo = findViewById(R.id.spnTempo);
        btnDicas = findViewById(R.id.btnDicas);

        dicasFDS = new ArrayList<>();

    }

    public void verDicas(View view){
        Dicas dicas = new Dicas();
        String texto = spnTempo.getSelectedItem().toString();

        if (texto.equals("Selecione...")){
            tvDicas.setText("Selecione uma opcao.");
        }
        else{
            tvDicas.setText("");
            dicasFDS = dicas.sugereDicas(texto);
            for (int i=0; i<dicasFDS.size();i++){
                tvDicas.append(dicasFDS.get(i));
                tvDicas.append("\n");
            }
        }
    }

}