package devandroid.dias.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.dias.applistacurso.model.Curso;

public class CursoController {
    private List<Curso> listCursos;
    public List getListaDeCursos(){
        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("Java"));
        listCursos.add(new Curso("Php"));
        listCursos.add(new Curso("Phyton"));
        listCursos.add(new Curso("SQL"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("Flutter"));
        listCursos.add(new Curso("Dart"));
        listCursos.add(new Curso("Android"));
        listCursos.add(new Curso("IOS"));
        listCursos.add(new Curso("Ruby"));
        listCursos.add(new Curso("Go Lang"));

        return listCursos;
    }
}
