package com.example.ativpeso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbCafe, cbBurger, cbCoca, cbPastel;
    TextView tvCafe, tvBurger, tvCoca, tvPastel, valorBurger, valorCafe, valorPastel, valorCoca;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbCafe = findViewById(R.id.cb_cafe);
        cbBurger = findViewById(R.id.cb_burger);
        cbCoca = findViewById(R.id.cb_coca);
        cbPastel = findViewById(R.id.cb_pastel);

        tvBurger = findViewById(R.id.tv_burger);
        tvCafe = findViewById(R.id.tv_cafe);
        tvCoca = findViewById(R.id.tv_coca);
        tvPastel = findViewById(R.id.tv_pastel);
        valorBurger = findViewById(R.id.valorBurger);
        valorCafe = findViewById(R.id.valorCafe);
        valorPastel = findViewById(R.id.valorPastel);
        valorCoca = findViewById(R.id.valorCoca);

        spn = findViewById(R.id.spn);
    }

    public void setarQtd(View view) {
        int valorCafe, valorCoca, valorBurger, valorPastel;
        String valor;
        switch(view.getId())
        {
            case R.id.btnLessCafe:
                valor = tvCafe.getText().toString();
                if(Integer.parseInt(valor) > 0)
                    valorCafe = Integer.parseInt(valor) - 1;
                else
                    valorCafe = 0;
                tvCafe.setText(""+valorCafe);
                break;
            case R.id.btnPlusCoca:
                valor = tvCoca.getText().toString();
                valorCoca = Integer.parseInt(valor) + 1;
                tvCoca.setText(""+valorCoca);
                break;
            case R.id.btnPlusCafe:
                valor = tvCafe.getText().toString();
                valorCafe = Integer.parseInt(valor) + 1;
                tvCafe.setText(""+valorCafe);
                break;
            case R.id.btnLessCoca:
                valor = tvCoca.getText().toString();
                if(Integer.parseInt(valor) > 0)
                    valorCoca = Integer.parseInt(valor) - 1;
                else
                    valorCoca = 0;
                tvCoca.setText(""+valorCoca);
                break;

            case R.id.btnLessBurger:
                valor = tvBurger.getText().toString();
                if(Integer.parseInt(valor) > 0)
                    valorBurger = Integer.parseInt(valor) - 1;
                else
                    valorBurger = 0;
                tvBurger.setText(""+valorBurger);
                break;
            case R.id.btnPlusBurger:
                valor = tvBurger.getText().toString();
                valorBurger = Integer.parseInt(valor) + 1;
                tvBurger.setText(""+valorBurger);
                break;
            case R.id.btnLessPastel:
                valor = tvPastel.getText().toString();
                if(Integer.parseInt(valor) > 0)
                    valorPastel = Integer.parseInt(valor) - 1;
                else
                    valorPastel = 0;
                tvPastel.setText(""+valorPastel);
                break;
            case R.id.btnPlusPastel:
                valor = tvPastel.getText().toString();
                valorPastel = Integer.parseInt(valor) + 1;
                tvPastel.setText(""+valorPastel);
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }
    }

    public void fazerPedido(View view) {
        if (!validaCampos().equals("")){
            Toast.makeText(MainActivity.this,
                    validaCampos(), Toast.LENGTH_LONG).show();
        }
        else if (!verificarPgto().equals("")){
            Toast.makeText(MainActivity.this,
                    verificarPgto(), Toast.LENGTH_LONG).show();
        }
        else{
            atualizarPedido();
        }
    }

    private String validaCampos() {
        if (cbCafe.isChecked()){
            if (tvCafe.getText().toString().equals("0")){
                return "Informe a quantidade de café";
            }
        }
        else {
            if (!tvCafe.getText().toString().equals("0")){
                return "Marque o café";
            }
        }
        if (cbCoca.isChecked()){
            if (tvCoca.getText().toString().equals("0")){
                return "Informe a quantidade de coca";
            }
        }
        else {
            if (!tvCoca.getText().toString().equals("0")){
                return "Marque o coca";
            }
        }
        if (cbPastel.isChecked()){
            if (tvPastel.getText().toString().equals("0")){
                return "Informe a quantidade de pastel";
            }
        }
        else {
            if (!tvPastel.getText().toString().equals("0")){
                return "Marque o pastel";
            }
        }
        if (cbBurger.isChecked()){
            if (tvBurger.getText().toString().equals("0")){
                return "Informe a quantidade de burger";
            }
        }
        else {
            if (!tvBurger.getText().toString().equals("0")){
                return "Marque o burger";
            }
        }
        if(!cbBurger.isChecked() && !cbCoca.isChecked() && !cbCafe.isChecked() && !cbPastel.isChecked()){
            return "Selecione um item para continuar!";
        }
        return "";
    }

    private String verificarPgto() {
        if (spn.getSelectedItem().toString().equals("Selecione...")){
            return "Informe o pagamento!";
        }
        return "";
    }

    private void atualizarPedido() {
        String pedido = "";
        float juros = 0;
        float jurosCalculado = 0;
        float valorTotal = 0;
        float valorTotalJuros;
        float valorTotalCafe = Float.parseFloat(tvCafe.getText().toString()) * Float.parseFloat(
                valorCafe.getText().toString());
        float valorTotalCoca = Float.parseFloat(tvCoca.getText().toString()) * Float.parseFloat(
                valorCoca.getText().toString());
        float valorTotalBurger = Float.parseFloat(tvBurger.getText().toString()) * Float.parseFloat(
                valorBurger.getText().toString());
        float valorTotalPastel = Float.parseFloat(tvPastel.getText().toString()) * Float.parseFloat(
                valorPastel.getText().toString());

        if(valorTotalCafe > 0){
            pedido += tvCafe.getText().toString() + " Café(s) R$ " + valorCafe.getText().toString() +
                    ": " + valorTotalCafe + "\n";
            valorTotal += valorTotalCafe;
        }
        if(valorTotalBurger > 0){
            pedido += tvBurger.getText().toString() + " Burger(s) R$ " + valorBurger.getText().toString() +
                    ": " + valorTotalBurger + "\n";
            valorTotal += valorTotalBurger;
        }
        if(valorTotalPastel > 0){
            pedido += tvPastel.getText().toString() + " Pastel(s) R$ " + valorPastel.getText().toString() +
                    ": " + valorTotalPastel + "\n";
            valorTotal += valorTotalPastel;
        }
        if(valorTotalCoca > 0){
            pedido += tvCoca.getText().toString() + " Coca(s) R$ " + valorCoca.getText().toString() +
                    ": " + valorTotalCoca + "\n";
            valorTotal += valorTotalCoca;
        }

        if(spn.getSelectedItem().toString().equals("Débito")){
            juros = 5;
            jurosCalculado = (float) (valorTotal * 0.05);
        }
        else if(spn.getSelectedItem().toString().equals("Crédito")){
            juros = 10;
            jurosCalculado = (float) (valorTotal * 0.1);
        }

        valorTotalJuros = valorTotal + jurosCalculado;

        pedido += "Total: R$ " + valorTotal + " + " + jurosCalculado + " ("+juros+"%) = R$ " + valorTotalJuros;

        enviarPedido(pedido);
    }

    private void enviarPedido(String pedido){
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("informacao",pedido);
        this.startActivity(intent);
    }
}