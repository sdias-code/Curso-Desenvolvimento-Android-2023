package devandroid.dias.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.dias.applistacurso.model.Curso;

public class CursoController {
    public List listCursos;
    public List getCursoDesejados(){
        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());

        return listCursos;
    }
}
