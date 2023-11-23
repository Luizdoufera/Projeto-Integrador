//classe Projeto

import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private String nome;
    private String descricao;
    private List<Atividades> atividades;
    private List<Area> areas;

    public Projeto() {
        this.atividades = new ArrayList<>();
        this.areas = new ArrayList<>();
    }

    public Projeto(String nomeProjeto, String descricao) {
        this.nome = nomeProjeto;
        this.descricao = descricao;
        this.atividades = new ArrayList<>();
        this.areas = new ArrayList<>();
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

    public void adicionarAtividade(Atividades atividade) {
        atividades.add(atividade);
    }

    public int getPercentualProjeto() {
        if (atividades.isEmpty()) {
            return 0;  // Se não há ações, a tarefa está automaticamente 0% concluída.
        }

        int somaPercentuais = 0;
        for (Atividades atividade : atividades) {
            somaPercentuais += atividade.getPercentualAtividade();
        }

        return somaPercentuais / atividades.size();  // Média dos percentuais das ações.
    }


    public List<Atividades> getAtividades() {
        return atividades;
    }

    public void adicionarArea(Area area) {
        areas.add(area);
    }

    public List<Area> getAreas() {
        return areas;
    }

    @Override
    public String toString() {
        return "Nome do Projeto: " + nome + "\nDescrição: " + descricao + "\nPercentual concluído:" +
                getPercentualProjeto() + "%";
    }
}



//Classe atividade

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Atividades {

    private String nomeAtividade;
    private int progresso; // Em percentagem de 0 a 100
    private List<Acao> acoes;
    private String descricao;
    private Date dataInicio;  // Modificado para Date
    private Date dataTermino; // Modificado para Date

    public Atividades() {

    }

    public Atividades(String nome, Date dataInicio, Date dataTermino ) {
        this.nomeAtividade = nome;  // Corrigido para usar a descrição
        this.progresso = 0;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.acoes = new ArrayList<>();
    }

    public void adicionarAcao(Acao acao) {
        acoes.add(acao);
    }

    public int getPercentualAtividade() {
        if (acoes.isEmpty()) {
            return 0;  // Se não há ações, a tarefa está automaticamente 0% concluída.
        }

        int somaPercentuais = 0;
        for (Acao acao : acoes) {
            somaPercentuais += acao.progresso();
        }

        return somaPercentuais / acoes.size();  // Média dos percentuais das ações.
    }

    public String getDescricao() {
        return nomeAtividade;
    }

    public void estaConcluida() {
        int percentual = getPercentualAtividade();
        if (new Date().after(dataTermino) && percentual < 100) {
            System.out.println("Aviso: Atividade '" + descricao + "' não foi concluída até a data fim.");
        }
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public List<Acao> getAcoes() {
        return acoes;
    }

    public String getNome() {
        return nomeAtividade;
    }


    @Override
    public String toString() {
        return "\nNome da atividade: " + nomeAtividade +"\nData inicio: " + dataInicio +
                "\nData termino: " + dataTermino + "\nPercentual concluído: " + getPercentualAtividade() + "%";
    }
}


//Classe Acao

import java.util.*;

public class Acao {
    private String nomeAcao;
    private Date dataInicio;
    private Date dataTermino;
    private String areaResponsavel;
    private String usuarioResponsavel;
    private int progresso; // Em percentagem de 0 a 100
    private StatusAcao status;
    private List<Usuario> usuarios;

    public Acao(String nomeAcao, Date dataInicio, Date dataTermino, String areaResponsavel, String usuarioResponsavel) {
        this.nomeAcao = nomeAcao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.areaResponsavel = areaResponsavel;
        this.usuarioResponsavel = usuarioResponsavel;
        this.progresso = 0;
        this.status = StatusAcao.A_FAZER; // Inicializa como A FAZER
        this.usuarios = new ArrayList<>();

    }

    public void adicionarPercentualAcao(int percentual) {
        if (percentual >= 0 && percentual <= 100) {
            this.progresso = percentual;
            verificarDataFim();
            atualizarStatus(); // Atualiza o status ao concluir a ação
        } else {
            System.out.println("Percentual inválido. Deve estar entre 0 e 100.");
        }
    }

    private void verificarDataFim() {
        if (new Date().after(dataTermino) && progresso < 100) {
            System.out.println("Aviso: Ação '" + nomeAcao + "' não foi concluída até a data fim.");
        }
    }

    private void atualizarStatus() {
        if (progresso == 0) {
            status = StatusAcao.A_FAZER;
        } else if (progresso > 0 && progresso < 100) {
            status = StatusAcao.EM_PROGRESSO;
        } else {
            status = StatusAcao.CONCLUIDO;
        }
    }

    public int progresso() {
        return progresso;
    }

    public String getNome() {
        return nomeAcao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataTermino;
    }

    public StatusAcao getStatus() {
        return status;
    }

    public String getAreaResponsavel() {
        return areaResponsavel;
    }

    public String getUsuarioResponsavel() {
        return usuarioResponsavel;
    }
    // Método para adicionar usuário associado à ação
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Métodos getter para a lista de usuários
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @Override
    public String toString() {
        return "Ação: " + nomeAcao + "\nPercentual concluído: " + progresso + "%" +
                "\nData de início: " + dataInicio + "\nData Fim: " + dataTermino + "\nStatus: " + status;
    }
}


//Classe Area
public class Area {
    private String nomeArea;
    private String nome;

    public Area(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    public String getNomeArea() {
        return nomeArea;
    }
    public String getNome() {
        return nome;
    }
}


//Classe Empresa

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private List<Projeto> projetos;
    private List<Area> areas;

    public Empresa() {
        this.projetos = new ArrayList<>();
        this.areas = new ArrayList<>();
    }

    public Empresa(String nome) {
        this.nome = nome;
        this.projetos = new ArrayList<>();
        this.areas = new ArrayList<>();
    }

    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void adicionarArea(Area area) {
        areas.add(area);
    }

    public List<Area> getAreas() {
        return areas;
    }
}


// enum statusAcao 
public enum StatusAcao {
    A_FAZER,
    EM_PROGRESSO,
    CONCLUIDO
}


//Classe Usuario

public class Usuario {
    private String nome;
    private String perfilUsuario;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(String perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }
}


//Classe Menu

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Menu {
    private Scanner scanner;
    private Empresa empresa;
    private Map<String, Acao> acoesCadastradas;
    private String perfilUsuario;
    private String perfilUsuarioAnterior;
    private Map<String, Area> areasCadastradas;
    private Map<String, Usuario> usuariosCadastrados;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.empresa = new Empresa();
        this.acoesCadastradas = new HashMap<>();
        this.perfilUsuario = definirPerfilUsuario();
        this.perfilUsuarioAnterior = perfilUsuario;
        this.areasCadastradas = new HashMap<>();
        this.usuariosCadastrados = new HashMap<>();
    }

    public void exibirMenu() {
        int escolha;
        try {
            do {
                exibirOpcoes();
                System.out.print("Escolha uma opção: ");
                escolha = scanner.nextInt();
                scanner.nextLine();  // Limpar o buffercatch (InputMismatchException i){
                System.out.println();

                if (escolha == 9) {
                    solicitarPerfilUsuario();  // Opção para voltar e escolher novo perfil
                    // Verificar se o perfil foi alterado
                    if (!perfilUsuarioAnterior.equals(perfilUsuario)) {
                        // Se o perfil foi alterado, ajuste as opções do menu de acordo com o novo perfil
                        System.out.println("Perfil de usuário alterado. Atualizando opções do menu.");
                        exibirOpcoes();
                    }
                } else {
                    // Distribua as opções do menu com base no perfil do usuário
                    switch (perfilUsuario) {
                        case "administrador":
                            processarOpcaoAdministrador(escolha);
                            break;
                        case "lider_projeto":
                            processarOpcaoLiderProjeto(escolha);
                            break;
                        case "usuario":
                            processarOpcaoUsuario(escolha);
                            break;
                        default:
                            System.out.println("Perfil de usuário não reconhecido.");break;
                    }
                }
            } while (escolha != 0);
        }catch (InputMismatchException e){
            System.out.println("Entrada diferente do esperado, entre com um numero de 0 a 9");
        }
    }

    private void exibirOpcoes() {
        System.out.println("==== Menu ====");

        switch (perfilUsuario) {
            case "administrador":
                System.out.println("1. Cadastrar Empresa");
                System.out.println("2. Cadastrar área");
                System.out.println("3. Cadastrar Usuário");
                System.out.println("8. Visualizar quadro Kanban");
                break;
            case "lider_projeto":
                System.out.println("4. Cadastrar Projeto");
                System.out.println("5. Cadastrar Atividade");
                System.out.println("6. Cadastrar Ação");
                System.out.println("8. Visualizar quadro Kanban");
                break;
            case "usuario":
                System.out.println("7. Atualizar status da Ação");
                System.out.println("8. Visualizar quadro Kanban");
                break;
            default:
                System.out.println("Perfil de usuário não reconhecido.");
                break;
        }

        System.out.println("9. Voltar ao menu anterior.");
        System.out.println("0. Encerrar o programa.");
    }


    private void processarOpcaoAdministrador(int escolha) {
        switch (escolha) {
            case 1:
                cadastrarEmpresa();
                break;
            case 2:
                cadastrarArea();
                break;
            case 3:
                cadastrarUsuario();
                break;
            case 8:
                visualizarQuadroKanban();
                break;
            case 9:
                System.out.println("Voltar ao menu anterior.");
                solicitarPerfilUsuario();
                break;
            case 0:
                System.out.println("Encerrar o programa.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    private void processarOpcaoLiderProjeto(int escolha) {
        switch (escolha) {
            case 4:
                cadastrarProjeto();
                break;
            case 5:
                cadastrarAtividade();
                break;
            case 6:
                cadastrarAcao();
                break;
            case 8:
                visualizarQuadroKanban();
                break;
            case 9:
                System.out.println("Voltar ao menu anterior.");
                solicitarPerfilUsuario();
                break;
            case 0:
                System.out.println("Encerrar o programa.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    private void processarOpcaoUsuario(int escolha) {
        switch (escolha) {
            case 7:
                atualizarStatusDaAcao();
                break;
            case 8:
                visualizarQuadroKanban();
                break;
            case 9:
                System.out.println("Voltar ao menu anterior.");
                solicitarPerfilUsuario();
                break;
            case 0:
                System.out.println("Encerrar o programa.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    private void cadastrarArea() {
        System.out.print("Digite o nome da área: ");
        String nomeArea = scanner.nextLine();
        Area area = new Area(nomeArea);
        areasCadastradas.put(nomeArea, area);
        System.out.println("Área cadastrada com sucesso!");
    }

    public Map<String, Area> getAreasCadastradas() {
        return areasCadastradas;
    }

    private void cadastrarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        Usuario usuario = new Usuario(nomeUsuario);
        usuariosCadastrados.put(nomeUsuario, usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private void exibirUsuariosCadastrados() {
        System.out.println("Lista de Usuários Cadastrados:");
        for (String nomeUsuario : usuariosCadastrados.keySet()) {
            System.out.println(nomeUsuario);
        }
    }

    private String definirPerfilUsuario() {
        System.out.print("Digite o perfil de usuário (administrador/lider_projeto/usuario): ");
        String perfil = scanner.nextLine().toLowerCase();

        while (!perfil.equals("administrador") && !perfil.equals("lider_projeto") && !perfil.equals("usuario")) {
            System.out.println("Perfil de usuário não reconhecido. Tente novamente.");
            System.out.print("Digite o perfil de usuário (administrador/lider_projeto/usuario): ");
            perfil = scanner.nextLine().toLowerCase();
        }

        return perfil;
    }

    private void solicitarPerfilUsuario() {
        System.out.print("Digite o perfil de usuário (administrador/lider_projeto/usuario): ");
        perfilUsuarioAnterior = perfilUsuario;  // Adicione esta linha
        perfilUsuario = scanner.nextLine().toLowerCase();
        while (!perfilUsuario.equals("administrador") && !perfilUsuario.equals("lider_projeto") && !perfilUsuario.equals("usuario")) {
            System.out.println("Perfil de usuário não reconhecido. Tente novamente.");
            System.out.print("Digite o perfil de usuário (administrador/lider_projeto/usuario): ");
            perfilUsuario = scanner.nextLine().toLowerCase();
        }
    }


    private void cadastrarEmpresa() {
        System.out.print("Digite o nome da empresa: ");
        String nomeEmpresa = scanner.nextLine();
        empresa.setNome(nomeEmpresa);
        System.out.println("Empresa cadastrada com sucesso!");
    }

    private void cadastrarProjeto() {
        System.out.print("Digite o nome do projeto: ");
        String nomeProjeto = scanner.nextLine();
        System.out.print("Digite a descrição do projeto: ");
        String descricao = scanner.nextLine();

        Projeto projeto = new Projeto(nomeProjeto, descricao);

        // Exibir lista de áreas cadastradas
        System.out.println("Lista de Áreas Cadastradas:");
        for (String nomeArea : areasCadastradas.keySet()) {
            System.out.println(nomeArea);
        }

        // Associar projeto a uma área
        System.out.print("Digite o nome da área em que o projeto será cadastrado: ");
        String nomeAreaProjeto = scanner.nextLine();
        Area areaProjeto = areasCadastradas.get(nomeAreaProjeto);

        if (areaProjeto != null) {
            projeto.adicionarArea(areaProjeto);
            System.out.println("Projeto cadastrado na área '" + nomeAreaProjeto + "' com sucesso!");
            empresa.adicionarProjeto(projeto);
        } else {
            System.out.println("Área não encontrada. Cadastre a área primeiro.");
        }

        System.out.println("Você tem um novo projeto!");
    }

    private Area encontrarAreaPorNome(String nomeArea) {
        for (Area area : empresa.getAreas()) {
            if (area.getNome().equals(nomeArea)) {
                return area;
            }
        }
        return null;
    }

    private void cadastrarAtividade() {
        Projeto projeto = escolherProjeto();
        if (projeto != null) {
            try {
                System.out.print("Digite o nome da atividade: ");
                String nomeAtividade = scanner.nextLine();
                System.out.println("Digite a data de inivio no formato: dd/MM/yyyy");
                String dataInicioAtividade = scanner.nextLine();
                System.out.println("Infome a data termino no formato: dd/MM/yyyy");
                String dataTerminoAtividada = scanner.nextLine();

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dateInicioAtividade = dateFormat.parse(dataInicioAtividade);
                Date dateTerminoAtividade = dateFormat.parse(dataTerminoAtividada);

                // Cria uma nova atividade com o nome fornecido pelo usuário
                Atividades atividade = new Atividades(nomeAtividade, dateInicioAtividade, dateTerminoAtividade);
                projeto.adicionarAtividade(atividade);

                System.out.println("Atividade '" + nomeAtividade + "' cadastrada com sucesso!");
            }catch (ParseException e){
                System.out.println("Erro na digitação da data");
            }
        }
    }


    private Projeto escolherProjeto() {
        System.out.print("Digite o nome do projeto: ");
        String nomeProjeto = scanner.nextLine();
        for (Projeto projeto : empresa.getProjetos()) {
            if (projeto.getNome().equals(nomeProjeto)) {
                return projeto;
            }
        }
        System.out.println("Projeto não encontrado. Cadastre o projeto primeiro.");
        return null;
    }

    private Atividades escolherAtividade(Projeto projeto) {
        System.out.print("Digite o nome da atividade: ");
        String nomeAtividade = scanner.nextLine();
        for (Atividades atividade : projeto.getAtividades()) {
            if (atividade.getDescricao().equals(nomeAtividade)) {
                return atividade;
            }
        }
        System.out.println("Atividade não encontrada. Cadastre a atividade primeiro.");
        return null;
    }

    private void cadastrarAcao() {
        Projeto projeto = escolherProjeto();
        if (projeto != null) {
            Atividades atividade = escolherAtividade(projeto);
            if (atividade != null) {
                System.out.print("Digite o nome da ação: ");
                String nomeAcao = scanner.nextLine();

                System.out.print("Digite a área responsável: ");
                String areaResponsavel = scanner.nextLine();

                // Solicitar o nome do usuário responsável
                System.out.print("Digite o nome do usuário responsável pela ação: ");
                String usuarioResponsavel = scanner.nextLine();

                // Solicitar a data de início
                System.out.print("Digite a data de início (formato dd/MM/yyyy): ");
                String dataInicioStr = scanner.nextLine();
                Date dataInicio;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicio = dateFormat.parse(dataInicioStr);
                } catch (ParseException e) {
                    System.out.println("Erro ao converter a data. Utilizando a data atual.");
                    dataInicio = new Date();
                }

                // Solicitar a data de término
                System.out.print("Digite a data de término (formato dd/MM/yyyy): ");
                String dataTerminoStr = scanner.nextLine();
                Date dataTermino;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dataTermino = dateFormat.parse(dataTerminoStr);
                } catch (ParseException e) {
                    System.out.println("Erro ao converter a data. Utilizando a data atual.");
                    dataTermino = new Date();
                }

                // Cria o usuário associado à ação
                Usuario usuario = new Usuario(usuarioResponsavel);

                // Cria a ação e associa o mesmo usuário como responsável e associado
                Acao acao = new Acao(nomeAcao, dataInicio, dataTermino, areaResponsavel, usuarioResponsavel);
                acao.adicionarUsuario(usuario);

                // Adiciona a ação à atividade
                atividade.adicionarAcao(acao);

                System.out.println("Ação cadastrada com sucesso!");
            }
        }
    }

    private Acao encontrarAcaoPorNome(String nomeAcao) {
        for (Projeto projeto : empresa.getProjetos()) {
            for (Atividades atividade : projeto.getAtividades()) {
                for (Acao acao : atividade.getAcoes()) {
                    if (acao.getNome().equals(nomeAcao)) {
                        return acao;
                    }
                }
            }
        }
        return null;  // Retorna null se a ação não for encontrada
    }

    private void atualizarStatusDaAcao() {
        System.out.println("Digite o nome da ação que deseja atualizar: ");
        String nomeAcaoAtualizar = scanner.nextLine();

        // Verificar se a ação com o nome fornecido existe
        Acao acaoAtualizar = encontrarAcaoPorNome(nomeAcaoAtualizar);

        if (acaoAtualizar != null) {
            System.out.println("Ação encontrada. Digite o percentual de conclusão: ");
            int percentual = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            // Atualizar o status da ação
            acaoAtualizar.adicionarPercentualAcao(percentual);
            System.out.println("Status da ação '" + nomeAcaoAtualizar + "' atualizado com sucesso!");
        } else {
            System.out.println("Ação não encontrada.");
        }
    }


    private void visualizarQuadroKanban() {
        System.out.println("==== Quadro Kanban ====");

        for (Projeto projeto : empresa.getProjetos()) {
            System.out.println("Projeto: " + projeto);

            for (Atividades atividade : projeto.getAtividades()) {
                System.out.println("\tAtividade: " + atividade);

                for (Acao acao : atividade.getAcoes()) {
                    System.out.println("\t\tAção: " + acao.getNome());
                    System.out.println("\t\t\tStatus: " + acao.getStatus());
                    System.out.println("\t\t\tProgresso: " + acao.progresso() + "%");
                    System.out.println("\t\t\tData de Início: " + acao.getDataInicio());
                    System.out.println("\t\t\tData de Término: " + acao.getDataFim());
                    System.out.println("\t\t\tÁrea Responsável: " + acao.getAreaResponsavel());
                    System.out.println("\t\t\tUsuário Responsável: " + acao.getUsuarioResponsavel());
                }
            }
        }

        System.out.println("======================");
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenu();
    }
}


import java.text.ParseException;

public class Principal {
    public static void main(String[] args) throws ParseException {
        Menu menu = new Menu();
        menu.exibirMenu();

    }
}
