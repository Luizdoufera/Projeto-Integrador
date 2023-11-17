//classe ação
import java.util.Date;

public class Acao {
    private String descricao;
    private double percentualConcluido;
    private Date dataInicio;
    private Date dataFim;
    private Status status;

    public Acao(String descricao, Date dataInicio, Date dataFim) {
        this.descricao = descricao;
        this.percentualConcluido = 0;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public void concluirAcao(double percentual) {
        if (percentual >= 0 && percentual <= 100) {
            this.percentualConcluido = percentual;
            verificarDataFim();
        } else {
            System.out.println("Percentual inválido. Deve estar entre 0 e 100.");
        }
    }
    public void InformarStatus(Status status){
        this.status = status;
    }

    private void verificarDataFim() {
        if (new Date().after(dataFim) && percentualConcluido < 100) {
            System.out.println("Aviso: Ação '" + descricao + "' não foi concluída até a data fim.");
        }
    }


    public double getPercentualConcluido() {
        return percentualConcluido;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public Status getStatus(){
        return status;
    }

    @Override
    public String toString() {
        return "Acão: " + descricao +"\nPercentual : " + percentualConcluido + "%" +
                "\nData de inicio: " + dataInicio + "\nData Fim: " + dataFim + "\nStatus: " + status;
    }
}

//classe atividade

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Atividade {
    private String descricao;
    private List<Acao> acoes;
    private Date dataInicio;
    private Date dataFim;

    public Atividade(String descricao, Date dataInicio, Date dataFim) {
        this.descricao = descricao;
        this.acoes = new ArrayList<>();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public void adicionarAcao(Acao acao) {
        acoes.add(acao);
    }

    public int getPercentualConcluido() {
        if (acoes.isEmpty()) {
            return 0;  // Se não há ações, a tarefa está automaticamente 0% concluída.
        }

        int somaPercentuais = 0;
        for (Acao acao : acoes) {
            somaPercentuais += acao.getPercentualConcluido();
        }

        return somaPercentuais / acoes.size();  // Média dos percentuais das ações.
    }

    public String getDescricao() {
        return descricao;
    }

    public void estaConcluida() {
        int percentual = getPercentualConcluido();
        if (new Date().after(dataFim) && percentual < 100) {
            System.out.println("Aviso: Tarefa '" + descricao + "' não foi concluída até a data fim.");
        }
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    @Override
    public String toString() {
        return "Infomação geral da tarefa" + "\nDescricao: " + descricao + "\n\nAções: " + acoes +
                "\n\nData de inicio da tarefa: " + dataInicio + "\nData Fim da tarefa: " + dataFim + "\nPercentual da tarefa: " + getPercentualConcluido() + "%";
    }
}

//classe departamento

public enum Departamento {

    ADM,
    FUNCIONARIO,
    LIDER,
}

//classe empresa

public class Empresa {

    private String nome;
    private String cnpj;

    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}

//classe projeto

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projeto {

    private String nome;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private List<Atividade> tarefa;

    public Projeto(String nome, String descricao, Date dataInicio, Date dataFim){
        this.nome = nome;
        this.descricao = descricao;
        tarefa = new ArrayList<>();
    }

    public void adicionarTarefa(Atividade tarefa){
        this.tarefa.add(tarefa);
    }

    int percentual = 0;
    public int getPercentualConcluido(){
        for(Atividade tarefas: tarefa){
            percentual += tarefas.getPercentualConcluido();
        }
        return percentual / tarefa.size();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "\n\nNome do Projeto: " + nome +
        "\nDescricao do Projeto: " + descricao + "\nPercentual do projeto: " + getPercentualConcluido() + "%";
    }
}

//Classe Status
public enum Status {

    A_EXECULTAR,
    EM_ANDAMENTO,
    FINALIZADO,

}

//classe usuário
public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private Departamento departamento;

    public Usuario(String nome, String email, String senha, Departamento departamento){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.departamento = departamento;
    }

    public boolean validarSenha(String validasenha){
        return validasenha.equals(senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}


// classe main

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws ParseException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("**Fazer cadastro de usuáario**");
            System.out.println("1- SIM, 2- NÃO");
            int decide = sc.nextInt();
            sc.nextLine();

            if (decide == 1) {
                System.out.println("Informe o nome de usuário: ");
                String usuario = sc.nextLine();
                System.out.println("Infome o email: ");
                String email = sc.nextLine();
                System.out.println("Infome a senha: ");
                String senha = sc.nextLine();
                System.out.println("Escolha o departamento");
                System.out.println("1 - ADM");
                System.out.println("2 - FUNCIONARIO");
                System.out.println("3 - LIDER");
                int escolha = sc.nextInt();

                Departamento departamento;
                switch (escolha) {
                    case 1:
                        departamento = Departamento.ADM;
                        break;
                    case 2:
                        departamento = Departamento.FUNCIONARIO;
                        break;
                    case 3:
                        departamento = Departamento.LIDER;
                        break;
                    default:
                        System.out.println("Opção inválida. Usando o departamento padrão Funcionario");
                        departamento = Departamento.FUNCIONARIO;
                        break;
                }
                Usuario usuario1 = new Usuario(usuario, email, senha, departamento);
                System.out.println("Usuário cadastrado");
                System.out.println("Fazer longin");
                System.out.println("Digite a senha: ");
                String validaSenha = sc.next();

                if (usuario1.validarSenha(validaSenha)) {
                    System.out.println("Senha correta:)");
                    System.out.println("\nVamos cadastrar um projeto: ");
                    System.out.println("Informe o nome do projeto para o Kanban: ");
                    String nomeProjeto = sc.next();
                    System.out.println("Infome a descrição: ");
                    String descricaoProjeto = sc.next();
                    System.out.println("Infome a data de inicio no formato dd/MM/yyy: ");
                    String dataInicioProjeto = sc.next();
                    System.out.println("Infome a data fim no formato dd/MM/yyy: ");
                    String dataFimProjeto = sc.next();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date dateInicioProjeto = dateFormat.parse(dataInicioProjeto);
                    Date dateFimProjeto = dateFormat.parse(dataFimProjeto);

                    Projeto projeto1 = new Projeto(nomeProjeto, descricaoProjeto, dateInicioProjeto, dateFimProjeto);

                    System.out.println("\n**** PROJETO CRIADO COM SUCESSO ****");
                    int z = 1;
                    System.out.println("Vamos fazer um controle de tarefa? ");
                    System.out.println("SIM");
                    System.out.println("NÃO");
                    String simNao = sc.next();
                    sc.nextLine();
                    if (simNao.equals("SIM")) {
                        for (int i = 0; i < 20; i++) {
                            System.out.println("\n Infome a descrição da sua tarefa a ser controlada: ");
                            String descricaoTarefa = sc.nextLine();
                            System.out.println("infome a data de inicio no formato dd/MM/yyyy: ");
                            String dataInicioTarefa = sc.next();
                            System.out.println("Infome a data fim no formato dd/MM/yyyy: ");
                            String dataFimTarefa = sc.next();
                            SimpleDateFormat dateFormatTarefa = new SimpleDateFormat("dd/MM/yyyy");
                            Date dateInicioTarefa = dateFormat.parse(dataInicioTarefa);
                            Date dateFimTarefa = dateFormat.parse(dataFimTarefa);

                            Atividade tarefa = new Atividade(descricaoTarefa, dateInicioTarefa, dateFimTarefa);
                            System.out.println("\n*** TAREFA CRIADA COM SUCESSO ***");

                            System.out.println("É hora de criar as ações pertencentes a essa tarefa");
                            int x = 1;
                            while (x == 1) {
                                sc.nextLine();
                                System.out.println("Entre com a descrição da ação: ");
                                String descricaoAcao = sc.nextLine();
                                System.out.println("Entre com a data início da ação no formato dd/MM/yyyy: ");
                                String dataInicioAcao = sc.next();
                                System.out.println("Entre com a data fim da ação no formato dd/MM/yyyy: ");
                                String dataFimAcao = sc.next();
                                Status status1 = Status.A_EXECULTAR;
                                SimpleDateFormat dateFormatAcao = new SimpleDateFormat("dd/MM/yyyy");
                                Date dateInicioAcao = dateFormat.parse(dataInicioAcao);
                                Date dateFimAcao = dateFormat.parse(dataFimAcao);

                                Acao acao1 = new Acao(descricaoAcao, dateInicioAcao, dateFimAcao);
                                acao1.InformarStatus(status1);

                                System.out.println("\n" + acao1);
                                int p = 1;
                                System.out.println("\nDeseja atualizar o percentual de conclusão dessa ação?");
                                System.out.println("1- SIM, 2- NÃO");
                                int deciciracaoPercentual = sc.nextInt();
                                Status status2;
                                if (deciciracaoPercentual == 1) {
                                    while (p == 1) {
                                        System.out.println("Infome o novo percentual: ");
                                        Double novoPercentualAcao = sc.nextDouble();
                                        acao1.concluirAcao(novoPercentualAcao);
                                        if (novoPercentualAcao > 0 && novoPercentualAcao < 100) {
                                            status2 = Status.EM_ANDAMENTO;
                                        } else if (novoPercentualAcao == 100) {
                                            status2 = Status.FINALIZADO;
                                        } else {
                                            System.out.println("Percentual invalido");
                                            status2 = Status.A_EXECULTAR;
                                        }
                                        acao1.InformarStatus(status2);
                                        System.out.println(acao1);
                                        System.out.println("Digite 1 para atualizar o percentual novamente ou 0 para sair");
                                        int numeroDigitado = sc.nextInt();
                                        p = numeroDigitado;
                                    }
                                }
                                tarefa.adicionarAcao(acao1);
                                System.out.println("Se dejesa criar outra ação digite 1, se não, digite 2");
                                x = sc.nextInt();
                            }
                            projeto1.adicionarTarefa(tarefa);
                            System.out.println("\n" + tarefa);
                            System.out.println("Deseja criar outra tarefa digite 2 para sair digite 3" +
                                    " LEMBRETE: Só é possível criar 20 tarefas para cada projeto");
                            int num = sc.nextInt();
                            if (num == 3) {
                                System.out.println("Obrigado. Volte mais tarde");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Volte outra hora para registrar tarefas");
                    }
                    System.out.println(projeto1);

                } else {
                    System.out.println("Senha incorreta:(");
                }

            }
        } catch (InputMismatchException e){
            System.out.println("Erro de digitação: " + e);
        } catch (ParseException u){
            System.out.println("Formato de data errada: " + u);
        }

    }
}






