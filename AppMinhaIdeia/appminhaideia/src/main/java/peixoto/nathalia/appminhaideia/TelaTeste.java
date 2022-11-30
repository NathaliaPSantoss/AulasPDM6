package peixoto.nathalia.appminhaideia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class TelaTeste extends AppCompatActivity {

    String TAG = "APP_CADASTRO";

    private ImageView linkedinPedro, githubPedro, linkedinNathalia, githubNathalia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_teste);
        Log.d(TAG, "onCreate; Tela info carregada...");
        getSupportActionBar().hide();
        findViewById();
    }

    private void findViewById() {
        linkedinPedro = findViewById(R.id.iv_linkedin_Pedro);
        githubPedro = findViewById(R.id.iv_github_Pedro);
        linkedinNathalia = findViewById(R.id.iv_linkedin_Nathalia);
        githubNathalia = findViewById(R.id.iv_github_Nathalia);
    }

    public void contato(View view) {
        switch (view.getId()) {
            case R.id.iv_linkedin_Pedro:
                Log.d(TAG,"Linkedin Pedro selecionado...");
                linkedinPedro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.linkedin.com/in/pedro-haruke-42840721a/");
                    }
                });
                break;
            case R.id.iv_github_Pedro:
                Log.d(TAG,"Github Pedro selecionado...");
                githubPedro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://github.com/PedroHaruke");
                    }
                });
                break;
            case R.id.iv_linkedin_Nathalia:
                Log.d(TAG,"Linkedin Nathalia selecionado...");
                linkedinNathalia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.linkedin.com/in/nathália-peixoto-dos-santos-65a334170/");
                    }
                });
                break;
            case R.id.iv_github_Nathalia:
                Log.d(TAG,"Github Nathalia selecionado...");
                githubNathalia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://github.com/nathSantos19");
                    }
                });
                break;
            default:
                Toast.makeText(this, "OPS!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void goLink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}