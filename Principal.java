import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
public class Principal
{   
    static Academia academia = new Academia("Pedrin's Academy");
    static ArrayList <Profissional> profissionais = new ArrayList<>();
    static ArrayList <Sala> salas = new ArrayList<>();
    static ArrayList <Horario> horarios = new ArrayList<>();
    static ArrayList <Aula> aulas = new ArrayList<>();
    static ArrayList <Aluno> alunos = new ArrayList<>();
    static Scanner le = new Scanner(System.in);
    
    public static void main(String [] args){
        valoresListas();
        menuPrincipal();
    }
    public static void menuPrincipal(){
        while(true){
            menuPrincipalImprime();
            int op =le.nextInt();
            if(op == 0) System.exit(0);
            else if(op == 1) menuCadastroAgendamento() ;
            else if(op == 2) menuRelatorios();
        }
    }

    public static void menuCadastroAgendamento(){
        while (true){
            menuCadastroAgendamentoImprime();
            int op = le.nextInt();
            if(op == 0) menuPrincipal();
            else if(op == 1) cadastraProfissional(/*profissionais*/);
            else if(op == 2) cadastraSala( );
            else if(op == 3) cadastraAula( );
            else if(op == 4) addAulaProfissional();
            else if(op == 5) agendarHorario( );
            else if(op == 6) cadastraAluno( );
            else if(op == 7) addAulaAluno(  );
        }
    }

    public static void menuRelatorios(){
        while (true){
            menuRelatoriosImprime();
            int op = le.nextInt();
            if(op == 0) menuPrincipal();
            else if(op == 1) listarSalas( salas );
            else if(op == 2) listarProfissionais( profissionais );
            else if(op == 3) listarAulas(  aulas );
            else if(op == 4) listarAlunos( alunos );
            else if(op == 5) listarAlunosAgendados( horarios );
            else if(op == 6) valorArrecadado();
        }
    }

    private static void valoresListas() {
        aulas.add(new Aula("Ginastica", 100.00, 45));
        aulas.add(new Aula("Lan bahia", 150.00, 40));
        aulas.add(new Aula("Boxe", 120.00, 45));
        profissionais.add(new Profissional( "Predin"));
        profissionais.add(new Profissional( "Gustim"));
        profissionais.add(new Profissional( "Zezim"));
        salas.add(new Sala("Sala 101"));
        salas.add(new Sala("Sala 102"));
        salas.add(new Sala("Sala 103"));
        alunos.add(new Aluno("Tulim", "123"));
        alunos.add(new Aluno("Julim", "321"));
        alunos.add(new Aluno("Gilmarzim", "312"));
    }

    private static void menuPrincipalImprime() {
        System.out.println("*******************************************");
        System.out.println("## Bem vindo a acadêmia " + academia.getNome() + "##");
        System.out.println("##1 - Cadastros / Agendamentos");
        System.out.println("##2 - Relatórios");
        System.out.println("##0 - Sair");
    }

    private static void menuCadastroAgendamentoImprime() {
        System.out.println("********************************************************");
        System.out.println("############## CADASTRO E AGENDAMENTO ##################");

        System.out.println("##1 - Cadastrar profissional");
        System.out.println("##2 - Cadastrar sala");
        System.out.println("##3 - Cadastrar aula");
        System.out.println("##4 - Adicionar aula a um profissional");
        System.out.println("##5 - Agendar horário");
        System.out.println("##6 - Cadastrar aluno");
        System.out.println("##7 - Agendar aula para um aluno");

        System.out.println("##0 - Menu principal");
    }

    private static void menuRelatoriosImprime() {
        System.out.println("******************");
        System.out.println("### RELATÓRIOS ###");
        System.out.println("##1 - Listar salas");
        System.out.println("##2 - Listar profissionais");
        System.out.println("##3 - Listar aulas ");
        System.out.println("##4 - Listar alunos");
        System.out.println("##5 - Listar alunos agendados");
        System.out.println("##6 - Valor arrecadado por aula");

        System.out.println("##0 - Menu principal");
    }

    private static void addAulaAluno( ) {

        listarAlunos(alunos);
        System.out.println("## Selecione o aluno ##");
        Aluno aluno = alunos.get(le.nextInt() -1 );

        listarHorariosAula(horarios);
        System.out.println("## Selecione o horário/aula ##");
        Horario horario = horarios.get(le.nextInt() -1 );

        if( horarios.isEmpty()){
            System.out.println("## Nenhum horário disponível ##");
            menuCadastroAgendamento();
        }

        for (Aluno a : horario.getAlunos()) {
            if(a.equals(aluno)){
                System.out.println("## Horário já agendado para este aluno ##");
                menuCadastroAgendamento();
            }
        }

        if(horario.getAula().getLimiteAluno() > horario.getAula().getContAlunos())
        horario.getAula().setContAlunos();
        else{
            System.out.println("## Limite de alunos atingido ##");
            menuCadastroAgendamento();
        }
        aluno.addAula(horario.getAula());
        horario.addAluno(aluno);
        System.out.println("## Aula selecionada com sucesso ##");
    }
    private static void cadastraAluno() {
        System.out.println("## Informe o nome do Aluno ##");
        le.nextLine();
        String nome = le.nextLine();
        System.out.println("## Informe o matricula do Aluno ##");
        String matricula = le.next();
        Aluno aluno = new Aluno();

        for (Aluno a : alunos ) {
            if (a.getMatricula().equals(matricula)){
                System.out.println("Aluno já cadastrado");
                menuPrincipal();
            }
        }        
        aluno.setNome(nome);
        aluno.setMatricula(matricula);
        alunos.add(aluno);
        System.out.println("Cadastrado com sucesso!");
    }
    private static void valorArrecadado() {
        int cont =1;
        System.out.println("Valor arrecadado por horário: ");
        for (Horario horario: horarios) {
            System.out.println("## " + cont + " - "+ horario.toString());
        }
    }
    private static void listarAlunosAgendados(ArrayList<Horario> horarios) {         
        if(horarios.isEmpty()) {
        System.out.println("Nenhum alunos está com horário agendado");
        menuPrincipal();   
    }     
        int cont = 1;
        for (Horario h: horarios) {
            System.out.println("##" + cont +" Aluno " + h.getAlunos().get(cont-1).getNome() + " aula: " + h.getAula().getNome() + " data: " + h.getData());
        }
    }
    private static void listarAlunos(ArrayList<Aluno> alunos) {
        System.out.println("## Alunos ##");
        int cont = 1;
        for(Aluno a : alunos ){
            System.out.println("#"+ cont + " "+ a.getNome());
            cont ++;
        }
    }
    public static void addAulaProfissional(){
        System.out.println("## AGREGAR AULAS ##");
        listarProfissionais( profissionais );        
        Profissional profissional = profissionais.get( le.nextInt() -1 );        
        listarAulas(  aulas );
        Aula aula = aulas.get( le.nextInt() -1 );
        for (Aula a : profissional.getAulas()) {
            if(a.equals(aula)){
                System.out.println("Aula já cadastrada para este profissional");
                menuPrincipal();
            }
        }
        profissional.addAula( aula );        
        System.out.println("## Aula adicionada ao profissional com sucesso! ##");    
    }
    public static void listarAulas(ArrayList <Aula> aulas){
        System.out.println("## AULAS ##");
        int cont = 1;        
        for (Aula a : aulas ){
            System.out.println("## "+ cont +" #" + a.getNome());
            cont ++;
        }
    }
    public static void cadastraAula(){
        System.out.println("##Cadastrar aula##");
        System.out.println("## Informe o nome da aula ##");
        le.nextLine();
        String nome = le.nextLine();
        System.out.println("## Informe o valor da aula ##");
        double valor = le.nextDouble();
        System.out.println("## Informe o número máxmo de alunos ##");
        int numAlunos = le.nextInt();
        for (Aula a : aulas ) {
            if (a.getNome().equals(nome)){
                System.out.println("Aula já cadastrada");
                menuPrincipal();
            }
        }
        Aula aula = new Aula( nome, valor, numAlunos );
        aulas.add(aula);
        System.out.println("Aula cadastrada com sucesso!");        
    }
    public static void cadastraSala(){
        System.out.println("## Informe o número da sala ##");
        le.nextLine();
        Sala sala = new Sala( le.nextLine() );
        salas.add(sala);
        System.out.println("Sala Cadastrada com sucesso!");        
    }
    public static void listarSalas(ArrayList<Sala> salas){
        System.out.println("## Lista de salas ##");
        int cont = 1;
        for(Sala s : salas ){            
            System.out.println("#"+ cont + " "+ s.getNumero());
            cont ++;
        }     
    }
    public static void agendarHorario(){        
        System.out.println("## Agendar aula ##");
        System.out.println("## Selecione um profissional ##");
        if(profissionais.isEmpty()){
            System.out.println("## Nenhum profissional cadastrado ##");
            cadastraProfissional( /*profissionais*/ );
        }        
        listarProfissionais( profissionais );        
        Horario horario = new Horario();        
        Profissional profissional = profissionais.get( le.nextInt() -1 );
        System.out.println("## Selecione a aula ##");
        if(profissional.getAulas().isEmpty()){
            System.out.println("## Nenhuma aula cadastrada para este profissional ##");
            menuPrincipal();
        }
        listarAulaProfissional(  profissional  );   
        Aula aula = profissional.getAulas().get(le.nextInt() - 1);

        String juntaData = cadastarDataAula();

        String turno;

        int escolhaTurno = le.nextInt();

        if(escolhaTurno <= 0 && escolhaTurno > 3){
            System.out.println("## Valor inválido ##");
            menuPrincipal();
        }

        if( escolhaTurno == 1 ) turno = "Manhã";
        else if( escolhaTurno == 2 ) turno = "Tarde";
        else if( escolhaTurno == 3 ) turno = "Noite";
        else turno = "Não informado";

        for (Horario h : profissional.getHorarios()) {
            if(h.getData().equals(juntaData) && h.getTurno().equals(turno))  {
                System.out.println("Horário indisponível");
                menuPrincipal();
            }
        }

        System.out.println("## Selecione uma sala ##");

        if(salas.isEmpty()){
            System.out.println("## Nenhuma sala, favor cadastrar. ##");
            cadastraSala( );
        }

        listarSalas( salas );

        Sala sala = salas.get( le.nextInt() -1 );

        horario.setTurno(turno);
        horario.setProfissional( profissional );
        horario.setData( juntaData );
        horario.setAula(aula);
        horario.setSala(sala);
        profissional.addHorario(horario);
        horarios.add(horario);
        
        System.out.println("## Aula: " + aula.getNome() +  ", profissional: " 
        +profissional.getNome()+ ", dia: " + horario.getData() +", turno: "+ horario.getTurno()
        + ", sala: " + sala.getNumero() + " Agendada com sucesso!");
    }

    private static String cadastarDataAula() {
        System.out.println("## cadastre um horário ##");

        Calendar cal = Calendar.getInstance();
        int diaAtual = cal.get(Calendar.DATE);
        int mesAtual = cal.get(Calendar.MONTH) + 1;
        int anoAtual = cal.get(Calendar.YEAR);
        int dia = 0;
        int mes = 0;
        int ano = 0;

        System.out.println("## Informe o dia (DD) ##");
        dia = le.nextInt();

        System.out.println("## Informe o mês (MM) ##");
        mes = le.nextInt();

        System.out.println("## Informe o ano (AAAA) ##");
        ano = le.nextInt();

        if( dia >= diaAtual && dia <= 31 && mes >= mesAtual && mes <=12 && ano
        >= anoAtual) System.out.println("## Data válida ##");
        else if( dia < diaAtual && dia > 0 && mes>= mesAtual) 
        System.out.println("## Data válida ##");
        else if( dia < diaAtual && dia > 0 && mes < mesAtual && mes > 0 && ano > anoAtual) 
        System.out.println("## Data válida ##");
        else {
            System.out.println("## Data inválida ##");
            menuPrincipal();
        }
        String juntaData = dia+"/"+mes+"/"+ano;
        System.out.println("## Escolha o turno ##");
        System.out.println("## 1 Manhã ##");
        System.out.println("## 2 Tarde ##");
        System.out.println("## 3 Noite ##");
        return juntaData;
    }

    public static void listarAulaProfissional(Profissional profissional){        
        System.out.println("## Aulas ##");
        int cont = 1;         
       
        for(Aula a : profissional.getAulas() ){
            System.out.println("#"+ cont + " "+ a.getNome());
            cont ++;
        }     
    }

    public static void listarHorariosAula(ArrayList<Horario> horarios){
        System.out.println("## Horarios ##");
        int cont = 1;

        for(Horario h : horarios ){
            System.out.println("#"+ cont + " Aula: "+ h.getAula() +" dia: "+ h.getData()  + " turno: "+ h.getTurno());
            cont ++;
        }
    }
    public static void listarProfissionais(ArrayList<Profissional> profissionais){        
        System.out.println("## Profissionais ##");
        int cont = 1;
       
        for(Profissional p : profissionais ){
            System.out.println("#"+ cont + " "+ p.getNome());
            cont ++;
        }     
    }
    
    public static void cadastraProfissional(){
        Profissional profissional = new Profissional();
        System.out.println("## Informe o nome do Profissional ##");
        le.nextLine();
        String nome = le.nextLine();

        for (Profissional p : profissionais ) {
            if (p.getNome().equals(nome)){
                System.out.println("Profissional já cadastrado");
                menuPrincipal();
            }
        }
        profissional.setNome(nome);
        profissionais.add(profissional);
        System.out.println("Cadastrado com sucesso!");        
    }    
}
