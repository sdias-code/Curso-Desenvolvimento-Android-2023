package devandroid.dias.applistacurso.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

import devandroid.dias.applistacurso.R;
import devandroid.dias.applistacurso.controller.PessoaController;
import devandroid.dias.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    Pessoa outraPessoa;
    EditText editPrimeiroNome;
    EditText editSobreNome;
    EditText editNomeCurso;
    EditText editTelefoneContato;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    PessoaController pessoaController;

    //Adicionado SharedPreferences
    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_lista_vip";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciado SharedPreferences
        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = preferences.edit();

        pessoa = new Pessoa();

        outraPessoa = new Pessoa();

        pessoaController = new PessoaController();
        pessoaController.toString();

        outraPessoa.setPrimeiroNome("Fábio");
        outraPessoa.setSobreNome("Medeiros");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("11-9445-9090");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

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

                listaVip.putString("PrimeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("Sobrenome", pessoa.getSobreNome());
                listaVip.putString("CursoDesejado", pessoa.getCursoDesejado());
                listaVip.putString("TelefoneContato", pessoa.getTelefoneContato());
                listaVip.apply();
            }
        });

        Log.i("POOAndroid", pessoa.toString());

        Log.i("POOAndroid", outraPessoa.toString());

    }
}