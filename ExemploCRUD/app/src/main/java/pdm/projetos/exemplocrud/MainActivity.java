package pdm.projetos.exemplocrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    EditText etNome, etTelefone, etEmail;
    ListView lvContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsById();
    }

    private void findViewsById() {

        etNome = findViewById(R.id.et_nome);
        etTelefone = findViewById(R.id.et_tel);
        etEmail = findViewById(R.id.et_email);
        lvContatos = findViewById(R.id.lv_contatos);

    }

    //Métodos de clique
}