package devandroid.dias.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.dias.applistacurso.R;
import devandroid.dias.applistacurso.controller.CursoController;
import devandroid.dias.applistacurso.controller.PessoaController;
import devandroid.dias.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    EditText editPrimeiroNome;
    EditText editSobreNome;
    EditText editNomeCurso;
    EditText editTelefoneContato;
    SharedPreferences.Editor listaVip;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    Spinner spinner;
    Pessoa pessoa;
    PessoaController pessoaController;
    CursoController cursoController;
    List<String> nomeDosCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoaController = new PessoaController(MainActivity.this);
        pessoaController.toString();

        cursoController = new CursoController();
        nomeDosCursos = cursoController.dadosParaSpinner();

        pessoa = new Pessoa();
        pessoaController.buscarDados(pessoa);

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);
        spinner = findViewById(R.id.spinner);

        // Adapter
        // Layout
        // Injetar o Adapter ao Spinner -> Lista gerada
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursoController.dadosParaSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobreNome.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");

                pessoaController.limparDados();
            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte logo!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobreNome.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();
                pessoaController.salvar(pessoa);
            }
        });

        Log.i("POOAndroid", pessoa.toString());


    }
}