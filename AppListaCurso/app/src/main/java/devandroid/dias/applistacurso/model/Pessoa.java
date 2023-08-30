package devandroid.dias.applistacurso.model;

public class Pessoa {


    //Atributos - Objetos, Molde, Modelo, Template
    private String primeiroNome;
    private String sobreNome;
    private String cursoDesejado;
    private String telefoneContato;

    //Métodos de acesso - Getters e Setters

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    //To String()


    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome:'" + primeiroNome + '\'' +
                ", sobreNome:'" + sobreNome + '\'' +
                ", cursoDesejado:'" + cursoDesejado + '\'' +
                ", telefoneContato:'" + telefoneContato + '\'' +
                '}';
    }

    //Construtor padrão
    public Pessoa(){

    }
}
