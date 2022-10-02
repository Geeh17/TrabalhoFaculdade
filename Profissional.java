 

import java.util.ArrayList;
//import java.util.Calendar;

public class Profissional
{
    private String nome;    
    private ArrayList <Horario> horarios;
    private ArrayList <Aula> aulas;
    
    public Profissional(String nome){
        this.nome = nome;
        this.horarios = new ArrayList<>();
        this.aulas = new ArrayList<>();
    }
    public Profissional(){
        horarios = new ArrayList<>();
        aulas = new ArrayList<>();
        horarios = new ArrayList<>();

    }    
    
    public ArrayList<Aula> getAulas() {
        return aulas;
    }
    public void addAula( Aula aula) {
        aulas.add(aula);
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public ArrayList<Horario> getHorarios(){
        return this.horarios;
    }

    public void addHorario(Horario horario) {
        this.horarios.add(horario);
    }
}


  