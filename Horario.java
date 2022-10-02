import java.util.ArrayList;

public class Horario
{
    private Aula aula;
    private Profissional profissional;
    private Sala sala;
    private String turno;
    private String data;
    
    private ArrayList<Aluno> alunos;

    public Horario() {
       alunos = new ArrayList<>();
    }

    public double getTotalValorArrecadado(ArrayList<Aluno> alunos, Aula aula){
        int contador = 0;
        for (Aluno a: alunos) {
            contador ++;
        }
        return contador *  aula.getValorPorAluno();
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Horario" +
                "aula=" + aula.getNome() +
                ", valor por aluno=" + aula.getValorPorAluno() +
                ", profissional=" + profissional.getNome() +
                ", sala=" + sala.getNumero() +
                ", turno='" + turno + '\'' +
                ", data='" + data + '\'' +
                ", total de alunos=" + alunos.size() +
                ", limite de alunos=" + aula.getLimiteAluno() +
                ", total arrecadado=" + getTotalValorArrecadado(alunos, aula) +
                '}';
    }
}
    
    
