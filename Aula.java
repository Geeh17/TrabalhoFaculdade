 

public class Aula
{
    private String nome;
    private double valorPorAluno;
    private int limiteAluno;

    private int contAlunos;

    public int getContAlunos() {
        return contAlunos;
    }

    public void setContAlunos() {
        this.contAlunos++ ;
    }

    public Aula(String nome, double valorPorAluno, int limeteAluno){
        this.limiteAluno = limeteAluno;
        this.valorPorAluno = valorPorAluno;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  nome + '\'' +", valor/aluno: " + valorPorAluno + ", limite de alunos: " + limiteAluno + "alunos agendados: " + contAlunos ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorPorAluno() {
        return valorPorAluno;
    }

    public void setValorPorAluno(double valorPorAluno) {
        this.valorPorAluno = valorPorAluno;
    }

    public int getLimiteAluno() {
        return limiteAluno;
    }

    public void setLimiteAluno(int limiteAluno) {
        this.limiteAluno = this.limiteAluno;
    }
}
