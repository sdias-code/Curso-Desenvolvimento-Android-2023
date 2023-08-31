package devandroid.dias.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.dias.applistacurso.model.Pessoa;
import devandroid.dias.applistacurso.view.MainActivity;

public class PessoaController {

    //Classe Pessoa
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_lista_vip";
    public PessoaController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_CONTROLLER", "Controller Iniciado!");
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC_CONTROLLER", "Salvo "+ pessoa.toString());

        listaVip.putString("PrimeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("Sobrenome", pessoa.getSobreNome());
        listaVip.putString("CursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("TelefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();
    }

    public Pessoa buscarDados(Pessoa pessoa){
        pessoa.setPrimeiroNome(preferences.getString("PrimeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("Sobrenome", ""));
        pessoa.setCursoDesejado(preferences.getString("CursoDesejado", ""));
        pessoa.setTelefoneContato(preferences.getString("TelefoneContato", ""));

        return pessoa;
    }

    public void limparDados(){

        listaVip.clear();
        listaVip.apply();
    }
}
