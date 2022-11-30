package com.example.myapplication;

import java.util.ArrayList;

public class Dicas {
    public ArrayList<String> sugereDicas(String tempo){
        ArrayList<String> dicas = new ArrayList<>();
        if (tempo.equals("Chuvoso")){
            dicas.add("Faça alguma receita;");
            dicas.add("Coloque os estudos em dia;");
            dicas.add("Assista a um filme/série.");
        }
        else if (tempo.equals("Ensolarado")){
            dicas.add("Evite contato com o sol;");
            dicas.add("Use protetor solar;");
            dicas.add("Mantenha-se hidratado.");
        }
        else if (tempo.equals("Tempestade")){
            dicas.add("Evite dirigir;");
            dicas.add("Desligue os aparelhos;");
            dicas.add("Fique em casa.");
        }
        return dicas;
    }
}
