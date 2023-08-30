package devandroid.dias.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.dias.applistacurso.model.Pessoa;

public class PessoaController {

    //Classe Pessoa


    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_CONTROLLER", "Controller Iniciado!");
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC_CONTROLLER", "Salvo "+ pessoa.toString());
    }
}
