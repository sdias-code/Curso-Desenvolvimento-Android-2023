package devandroid.dias.applistacurso.model;

public class Curso {

    private String nomeDoCursoDesejado;

    public Curso(String curso) {
        nomeDoCursoDesejado = curso;
    }

    public String getNomeDoCursoDesejado() {
        return nomeDoCursoDesejado;
    }

    public void setNomeDoCursoDesejado(String nomeDoCursoDesejado) {
        this.nomeDoCursoDesejado = nomeDoCursoDesejado;
    }
}
