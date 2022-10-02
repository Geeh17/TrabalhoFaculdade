import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String matricula;
    private ArrayList<Aula> aulas;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        aulas = new ArrayList<>();
    }

    public Aluno() {
        aulas = new ArrayList<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Aula> getAulas() {
        return aulas;
    }

    public void addAula(Aula aula) {
        this.aulas.add(aula);
    }
}
