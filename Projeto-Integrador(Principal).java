//classe Projeto

//Importando classes e bibliotecas
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projeto {
    //declarando atributos
    private String nome;
    private String descricao;
    private List<Atividades> atividades;
    private List<Area> areas;
    private Date dataIncioProjeto;
    private Date dataFimProjeto;

    //Utilizando o construtor sem parametros para instanciar as classes ArrayList atividades e areas
    public Projeto() {
        this.atividades = new ArrayList<>();
        this.areas = new ArrayList<>();
    }

    //Utilizando o construtor com parametros para instanciar as classes arraysLists e inicializar os atributos
    public Projeto(String nomeProjeto, String descricao, Date dataIncioProjeto, Date dataFimProjeto) {
        this.nome = nomeProjeto;
        this.descricao = descricao;
        this.dataIncioProjeto = dataIncioProjeto;
        this.dataFimProjeto = dataFimProjeto;
        this.atividades = new ArrayList<>();
        this.areas = new ArrayList<>();
    }

    //Declarando getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDataIncioProjeto(Date dataIncioProjeto) {
        this.dataIncioProjeto = dataIncioProjeto;
    }

    public Date getDataIncioProjeto() {
        return dataIncioProjeto;
    }

    public void setDataFimProjeto(Date dataFimProjeto) {
        this.dataFimProjeto = dataFimProjeto;
    }

    public Date getDataFimProjeto() {
        return dataFimProjeto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //Adicionando as atividades para dentro do ArrayList
    public void adicionarAtividade(Atividades atividade) {
        atividades.add(atividade);
    }

    //Calculando o percentual concluido do projeto
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

    //Adicionando as classes areas para dentro do arrayList de areas
    public void adicionarArea(Area area) {
        areas.add(area);
    }

    public List<Area> getAreas() {
        return areas;
    }

    @Override
    //Informações do projeto
    public String toString() {
        return "\nProjeto: " + nome + "\nDescrição: " + descricao + "\nData Início do Projeto: " + dataIncioProjeto
                + "\nData Final do Projeto" + dataFimProjeto + "\n" + getAreas() + "\nPercentual concluído:"
                + getPercentualProjeto() + "%";
    }
}


//Classe atividades

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Atividades {
    //Declarando os atributos
    private String nomeAtividade;
    private int progresso; // Em percentagem de 0 a 100
    private List<Acao> acoes;
    private String descricao;
    private Date dataInicio;  // Modificado para Date
    private Date dataTermino; // Modificado para Date

    //Construtor sem parametros
    public Atividades() {

    }

    //Utilizando o construtor com parametros para inicializar os atributos e instanciar o ArrayList ações
    public Atividades(String nome, Date dataInicio, Date dataTermino) {
        this.nomeAtividade = nome;  // Corrigido para usar a descrição
        this.progresso = 0;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.acoes = new ArrayList<>();
    }

    //Adicionando ações dentro do ArrayList ações
    public void adicionarAcao(Acao acao) {
        acoes.add(acao);
    }

    //Calculando o percentual de conclusão da atividade
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

    //Metodo para checar se a atividade foi concluída dentro da data estipulada
    public void estaConcluida() {
        int percentual = getPercentualAtividade();
        if (new Date().after(dataTermino) && percentual < 100) {
            System.out.println("Aviso: Atividade '" + descricao + "' não foi concluída até a data fim.");
        }
    }

    //Getters e Setters
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
    //Informações da atividade
    public String toString() {
        return "\nAtividade: " + nomeAtividade +"\nData Início: " + dataInicio +
                "\nData Final: " + dataTermino + "\nPercentual Concluído: " + getPercentualAtividade() + "%";
    }
}


//Class Acao.

import java.util.*;

public class Acao {

    //Atributos da class.
    private String nomeAcao;
    private Date dataInicio;
    private Date dataTermino;
    private String usuarioResponsavel;
    private int progresso; // Em percentagem de 0 a 100.
    private StatusAcao status;
    private String aviso;
    private List<Usuario> usuarios;

    //Construtor onde já recebe como parâmetros: nome da ação, data início, data fim e usuário responsável
    public Acao(String nomeAcao, Date dataInicio, Date dataTermino, String usuarioResponsavel) {
        this.nomeAcao = nomeAcao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.usuarioResponsavel = usuarioResponsavel;
        this.progresso = 0;
        this.status = StatusAcao.A_FAZER; // Inicializa como A FAZER
        this.usuarios = new ArrayList<>();

    }

    //Adicionando o percentual de conclusão de cada açõa manualmente
    public void adicionarPercentualAcao(int percentual) {
        if (percentual >= 0 && percentual <= 100) {
            this.progresso = percentual;
            verificarDataFim();
            atualizarStatus(); // Atualiza o status ao concluir a ação
        } else {
            System.out.println("Percentual inválido. Deve estar entre 0 e 100.");
        }
    }

    //Método que verifica se a ação foi concluída dentro do prazo
    private void verificarDataFim() {
        if (new Date().after(dataTermino) && progresso < 100) {
            System.out.println(aviso = "Aviso: Ação '" + nomeAcao + "' não foi concluída até a data fim.");
        }
    }

    //Método que atualiza o status automaticamente de acordo com a porcentagem da ação
    private void atualizarStatus() {
        if (progresso == 0) {
            status = StatusAcao.A_FAZER;
        } else if (progresso > 0 && progresso < 100) {
            status = StatusAcao.EM_PROGRESSO;
        } else {
            status = StatusAcao.CONCLUIDO;
        }
    }

    //Retorna o progresso da ação
    public int progresso() {
        return progresso;
    }

    //gettes e settes
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


    public String getUsuarioResponsavel() {
        return usuarioResponsavel;
    }
    public String getAviso() {
        return aviso;
    }
    // Método para adicionar usuário associado à ação
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Métodos getters para a lista de usuários
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    //Informações da ação
    @Override
    public String toString() {
        return "\n\nAção: " + nomeAcao + "\nPercentual Concluído: " + progresso + "%" +
                "\nData de Início: " + dataInicio + "\nData Final: " + dataTermino + "\nStatus: " + status;
    }
}


//Classe Area

public class Area {
    private String nomeArea;
    private String nome;

    //Construtor que recebe o  nomem da area como parâmetro
    public Area(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    //Getters e setters
    public String getNomeArea() {
        return nomeArea;
    }
    public String getNome() {
        return nome;
    }
    //Informações da área
    @Override
    public String toString() {
        return "Área: " + nomeArea;
    }
}


//Classe Empresa

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    //Declarando atributos da empresa
    private String nome;
    private List<Projeto> projetos;
    private List<Area> areas;

    //Construtor sem parâmetros
    public Empresa() {
        this.projetos = new ArrayList<>();
        this.areas = new ArrayList<>();
    }

    //Construtor que recebe um parâmtro e instância arrays de projeto e area
    public Empresa(String nome) {
        this.nome = nome;
        this.projetos = new ArrayList<>();
        this.areas = new ArrayList<>();
    }

    //Adicionando projetos dentro da arrayList
    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }

    //Getters e setters
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
    //Atributos da classe
    private String nome;
    private String senha;
    private String perfilUsuario;

    //Construtor que recebe dois parâmetros
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    //Construtor que recebe apenas um parâmtro
    public Usuario(String nomeUsuario){
        this.nome = nomeUsuario;
    }

    //Getters e setters
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    //Método para validar o nome de usuário
    public boolean validarNome(String validaNome){
        return validaNome.equals(nome);
    }

    //Método para validar a senha de usuário
    public boolean validarSenha(String validaSenha){
        return validaSenha.equals(senha);
    }
}



//Classe Menu

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Menu {
    //Atributos da classe Menu
    Usuario usuario;
    private Scanner scanner;
    private Empresa empresa;
    private int perfilUsuario;
    private int perfilUsuarioAnterior;
    private Map<String, Area> areasCadastradas;
    private Map<String, Usuario> usuariosCadastrados;
    private Map<String, Projeto> nomesProjetos;
    private Map<String, Atividades> nomesAtividades;
    private Map<String, Acao> nomesAções;
    private Map<String, Usuario> nomeUsuarios;

    //Construtor sem parâmetros da classe menu que instância objetos e inicializa atributos
    public Menu() {
        this.scanner = new Scanner(System.in);
        this.empresa = new Empresa();
        this.perfilUsuario = definirPerfilUsuario();
        this.perfilUsuarioAnterior = perfilUsuario;
        this.areasCadastradas = new HashMap<>();
        this.usuariosCadastrados = new HashMap<>();
        this.nomesProjetos = new HashMap<>();
        this.nomesAtividades = new HashMap<>();
        this.nomesAções = new HashMap<>();
        this.nomeUsuarios = new HashMap<>();

    }

    //Método principal que chama outras classes e métodos pertencentes a classe Menu
    public void exibirMenu() {
        int escolha;
        try {
            do {
                exibirOpcoes();
                try {
                    System.out.print("Escolha uma opção: ");
                    escolha = scanner.nextInt();
                    scanner.nextLine();  // Limpar o buffercatch (InputMismatchException i){
                    System.out.println();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada incorreta.\nUtilizando entrada padrão 1!\n");
                    escolha = 1;
                    scanner.nextLine();
                }


                if (escolha == 9) {
                    solicitarPerfilUsuario();  // Opção para voltar e escolher novo perfil
                    // Verificar se o perfil foi alterado
                    if (perfilUsuarioAnterior != perfilUsuario) {
                        // Se o perfil foi alterado, ajuste as opções do menu de acordo com o novo perfil
                        System.out.println("\nPerfil de usuário alterado.\nAtualizando opções do menu.");
                        exibirOpcoes();
                    }
                } else {
                    // Distribua as opções do menu com base no perfil do usuário
                    switch (perfilUsuario) {
                        case 1:
                            processarOpcaoAdministrador(escolha);
                            break;
                        case 2:
                            processarOpcaoLiderProjeto(escolha);
                            break;
                        case 3:
                            processarOpcaoUsuario(escolha);
                            break;
                        default:
                            System.out.println("Perfil de usuário não reconhecido.");
                            break;
                    }
                }
            } while (escolha != 0);
        }catch (ParseException e){
            System.out.println(e);
        }

    }

    //Exibir opções de acordo com o perfil do usuário
    private void exibirOpcoes() {

        switch (perfilUsuario) {
            case 1:
                System.out.println("\n========== Menu do Administrador do sistema ===========");
                System.out.println("1. Cadastrar Empresa");
                System.out.println("2. Cadastrar área");
                System.out.println("3. Cadastrar Usuário");
                System.out.println("4. Visualizar quadro Kanban");
                break;
            case 2:
                System.out.println("\n========== Menu do Líder do projeto ===========");
                System.out.println("1. Cadastrar Projeto");
                System.out.println("2. Cadastrar Atividade");
                System.out.println("3. Cadastrar Ação");
                System.out.println("4. Visualizar quadro Kanban");
                break;
            case 3:
                System.out.println("\n========== Menu do Usuário resposável pelas ações do projeto ===========");
                System.out.println("1. Atualizar status da Ação");
                System.out.println("2. Visualizar quadro Kanban");
                break;
            default:
                System.out.println("Perfil de usuário não reconhecido.");
                break;
        }

        System.out.println("9. Voltar ao menu anterior.");
        System.out.println("0. Encerrar o programa.");
        System.out.println();
    }

    //Opções do administrador
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
            case 4:
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
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
    }

    //Opções do lider do projeto
    private void processarOpcaoLiderProjeto(int escolha) throws ParseException {
        switch (escolha) {
            case 1:
                cadastrarProjeto();
                break;
            case 2:
                cadastrarAtividade();
                break;
            case 3:
                cadastrarAcao();
                break;
            case 4:
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
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
    }

    //Opções do usuário
    private void processarOpcaoUsuario(int escolha) {
        switch (escolha) {
            case 1:
                atualizarStatusDaAcao();
                break;
            case 2:
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
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
    }
    //Cadastro da area que pertence as opções do administrador
    private void cadastrarArea() {
        System.out.println("Digite o nome da área: ");
        String nomeArea = scanner.nextLine();
        Area area = new Area(nomeArea);
        areasCadastradas.put(nomeArea, area);
        System.out.println("\nÁrea cadastrada com sucesso!");
    }
    //ArrayList de areas cadastradas
    public Map<String, Area> getAreasCadastradas() {
        return areasCadastradas;
    }

    //Cadastro do usuário que pertencem as opções do administrador
    private void cadastrarUsuario() {
        System.out.println("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.println("Digite a senha do usuário: ");
        String senhaUsuario = scanner.nextLine();
        usuario = new Usuario(nomeUsuario, senhaUsuario);
        nomeUsuarios.put(nomeUsuario, usuario);
        System.out.println("\nUsuário cadastrado com sucesso!");
        exibirMenu();
    }

    //Lista para exibir os usuários cadastrados
    private void exibirUsuariosCadastrados() {
        System.out.println("\nLista de Usuários Cadastrados:");
        for (String nomeUsuario : usuariosCadastrados.keySet()) {
            System.out.println(nomeUsuario);
        }
    }

    //Metodo para definir o tipo de usário sendo 1 - administrador 2- lider do projeto 3- Funcionário
    private int definirPerfilUsuario() {
        int perfil;
        try {
            System.out.println("Digite o perfil de usuário\n1 - Administrador\n2 - Líder do projeto" +
                    "\n3 - Funicionário");
            perfil = scanner.nextInt();

            //Validando perfil do funcionário
            if(perfil == 3){
                try {
                    scanner.nextLine();
                    System.out.println("Infome o nome do funcionário: ");
                    String validaNome = scanner.nextLine();
                    System.out.println("Infome a senha de funcionário: ");
                    String validaSenhaa = scanner.nextLine();

                    if (usuario.validarNome(validaNome)) {
                        if (usuario.validarSenha(validaSenhaa)) {
                            System.out.println("Nome e senha corretos!");
                        } else {
                            System.out.println("Senha incorreta!!");
                        }
                    } else {
                        System.out.println("Nome incorreto!!");
                    }
                }catch (NullPointerException e){
                    System.out.println("Não há funcionário cadastrado!");
                    return solicitarPerfilUsuario();
                }

            }

            while (perfil != 1 && perfil != 2 && perfil != 3) {
                System.out.println("\nPerfil de usuário não reconhecido.\nTente novamente.");
                System.out.println("Digite o perfil de usuário:\n1- Administrador\n2 - Líder do projeto" +
                        "\n3 - Usuário");
                perfil = scanner.nextInt();
            }
            return perfil;

        }catch (InputMismatchException e){
            System.out.println("Entrada incorreta\n");
            return solicitarPerfilUsuario();
        }
    }

    //Outro método para definir o tipo de usuário
    private int solicitarPerfilUsuario() {
        try {
            scanner.nextLine();
            System.out.println("Digite o perfil de usuário\n1 - Administrador\n2 - Líder do projeto\n3 - Funcionário");
            perfilUsuarioAnterior = perfilUsuario;  // Adicione esta linha
            perfilUsuario = scanner.nextInt();

            if (perfilUsuario == 3) {
                scanner.nextLine();
                System.out.println("Infome o nome do funcionário: ");
                String validaNome = scanner.nextLine();
                System.out.println("Infome a senha de funcionário: ");
                String validaSenha = scanner.nextLine();

                if (usuario.validarNome(validaNome)) {
                    if (usuario.validarSenha(validaSenha)) {
                        System.out.println("Nome e senha corretos!");
                    } else {
                        System.out.println("Senha incorreta!!");
                        solicitarPerfilUsuario();
                    }
                } else {
                    System.out.println("Nome incorreta!!");
                    solicitarPerfilUsuario();
                }
            }

            while (perfilUsuario != 1 && perfilUsuario != 2 && perfilUsuario != 3) {
                System.out.println("\nPerfil de usuário não reconhecido.\nTente novamente.");
                System.out.println("Digite o perfil de usuário\n1 - Administrador\n2 - Líder do projeto\n3 - Funcionário");
                perfilUsuario = scanner.nextInt();
                //validando perfil do funcionário

                if (perfilUsuario == 3) {
                    scanner.nextLine();
                    System.out.println("Infome o nome do funcionário: ");
                    String validaNome = scanner.nextLine();
                    System.out.println("Infome a senha de funcionário: ");
                    String validaSenha = scanner.nextLine();

                    if (usuario.validarNome(validaNome)) {
                        if (usuario.validarSenha(validaSenha)) {
                            System.out.println("Nome e senha corretos!");
                        } else {
                            System.out.println("Senha incorreta!!");
                            solicitarPerfilUsuario();
                        }
                    } else {
                        System.out.println("Nome incorreto!!");
                        solicitarPerfilUsuario();
                    }

                }
                return perfilUsuario;

            }
            return perfilUsuario;
        }catch (InputMismatchException u){
            System.out.println("Entrada incorreta\n");
            solicitarPerfilUsuario();
        }
        return perfilUsuario;
    }

    //Método que cadastra empresa pertencente as opções do administrador
    private void cadastrarEmpresa() {
        System.out.println("Digite o nome da empresa: ");
        String nomeEmpresa = scanner.nextLine();
        empresa.setNome(nomeEmpresa);
        System.out.println("\nEmpresa cadastrada com sucesso!");
    }

    //Método que cadastra projetos pertencente as apções do lider do projeto
    private void cadastrarProjeto() {
        try {
            System.out.println("Digite o nome do projeto: ");
            String nomeProjeto = scanner.nextLine();
            System.out.println("Digite a descrição do projeto: ");
            String descricao = scanner.nextLine();
            System.out.println("Digite a data início do projeto, no formato dd/MM/yyyy: ");
            String dataInicioProjeto = scanner.nextLine();
            System.out.println("Digite a data Final do projeto, no formato dd/MM/yyyy: ");
            String dataFinalProjeto = scanner.nextLine();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dateInicioProjeto = dateFormat.parse(dataInicioProjeto);
            Date dateFinalProjeto = dateFormat.parse(dataFinalProjeto);

            Projeto projeto = new Projeto(nomeProjeto, descricao, dateInicioProjeto, dateFinalProjeto);
            nomesProjetos.put(nomeProjeto, projeto);

            // Exibir lista de áreas cadastradas
            System.out.println("\nLista de Áreas Cadastradas:");
            for (String nomeArea : areasCadastradas.keySet()) {
                System.out.println(nomeArea);
            }

            // Associar projeto a uma área
            System.out.println("Digite o nome da área em que o projeto será cadastrado: ");
            String nomeAreaProjeto = scanner.nextLine();
            Area areaProjeto = areasCadastradas.get(nomeAreaProjeto);

            if (areaProjeto != null) {
                projeto.adicionarArea(areaProjeto);
                System.out.println("\nProjeto cadastrado na área '" + nomeAreaProjeto + "' com sucesso!");
                empresa.adicionarProjeto(projeto);
            } else {
                System.out.println("Área não encontrada!\nCadastre a área primeiro.");
            }

            System.out.println("\nVocê tem um novo projeto!");
        }catch (InputMismatchException e){
            System.out.println("Entrada errada!");
        }catch (ParseException u){
            System.out.println("Formato de data errada\nUtilizando data atual!");
            Date dateInicioProjeto = new Date();
            Date dateFinalProjeto = new Date();
        }
    }

    //Método para encontrar área
    private Area encontrarAreaPorNome(String nomeArea) {
        for (Area area : empresa.getAreas()) {
            if (area.getNome().equals(nomeArea)) {
                return area;
            }
        }
        return null;
    }

    //Método para cadastrar a atividade pertencente as opções do lider do projeto
    private void cadastrarAtividade() {
        Projeto projeto = escolherProjeto();
        if (projeto != null) {
            try {
                System.out.println("Digite o nome da atividade: ");
                String nomeAtividade = scanner.nextLine();
                System.out.println("Digite a data de início no formato: dd/MM/yyyy");
                String dataInicioAtividade = scanner.nextLine();
                System.out.println("Infome a data termino no formato: dd/MM/yyyy");
                String dataTerminoAtividada = scanner.nextLine();

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dateInicioAtividade = dateFormat.parse(dataInicioAtividade);
                Date dateTerminoAtividade = dateFormat.parse(dataTerminoAtividada);


                // Cria uma nova atividade com o nome fornecido pelo usuário
                Atividades atividade = new Atividades(nomeAtividade, dateInicioAtividade, dateTerminoAtividade);
                projeto.adicionarAtividade(atividade);
                nomesAtividades.put(nomeAtividade, atividade);


                System.out.println("\nAtividade '" + nomeAtividade + "' cadastrada com sucesso!");
            }catch (ParseException e){
                System.out.println("Erro na digitação da data\nUtilizando data atual!");
                Date dateInicioAtividade = new Date();
                Date dateTerminoAtividade = new Date();
            }
        }
    }

    //Metodo para vincular o projeto as atividades e ações
    private Projeto escolherProjeto() {
        System.out.println("\nLista de projetos cadastrados:");
        for (String nomeProjeto : nomesProjetos.keySet()) {
            System.out.println(nomeProjeto);
        }

        System.out.println("Digite o nome do projeto: ");
        String nomeProjeto = scanner.nextLine();
        for (Projeto projeto : empresa.getProjetos()) {
            if (projeto.getNome().equals(nomeProjeto)) {
                return projeto;
            }
        }
        System.out.println("Projeto não encontrado!\nCadastre o projeto primeiro.");
        return null;
    }

    //Método para vincular a atividade as ações
    private Atividades escolherAtividade(Projeto projeto) {
        System.out.println("\nLista de Atividades cadastradas:");
        for (String nomeAtividade: nomesAtividades.keySet()) {
            System.out.println(nomeAtividade);
        }
        System.out.println("Digite o nome da atividade: ");
        String nomeAtividade = scanner.nextLine();
        for (Atividades atividade : projeto.getAtividades()) {
            if (atividade.getDescricao().equals(nomeAtividade)) {
                return atividade;
            }
        }
        System.out.println("Atividade não encontrada!\nCadastre a atividade primeiro.");
        return null;
    }

    //Método para cadastrar ações referente as opções do lider do projeto
    private void cadastrarAcao() {
        Projeto projeto = escolherProjeto();
        if (projeto != null) {
            Atividades atividade = escolherAtividade(projeto);
            if (atividade != null) {

                System.out.println("Digite o nome da ação: ");
                String nomeAcao = scanner.nextLine();

                // Solicitar o nome do usuário responsável
                System.out.println("\nLista de Usuários Cadastrados:");
                for (String nomeUsuario : nomeUsuarios.keySet()) {
                    System.out.println(nomeUsuario);
                }

                System.out.println("Digite o nome do usuário responsável pela ação: ");
                String usuarioResponsavel = scanner.nextLine();


                // Solicitar a data de início
                System.out.println("Digite a data de início (formato dd/MM/yyyy): ");
                String dataInicioStr = scanner.nextLine();
                Date dataInicio;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicio = dateFormat.parse(dataInicioStr);
                } catch (ParseException e) {
                    System.out.println("Erro ao converter a data!\nUtilizando a data atual.");
                    dataInicio = new Date();
                }

                // Solicitar a data de término
                System.out.println("Digite a data de término (formato dd/MM/yyyy): ");
                String dataTerminoStr = scanner.nextLine();
                Date dataTermino;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dataTermino = dateFormat.parse(dataTerminoStr);
                } catch (ParseException e) {
                    System.out.println("Erro ao converter a data\nUtilizando a data atual!");
                    dataTermino = new Date();
                }

                // Cria o usuário associado à ação
                Usuario usuario = new Usuario(usuarioResponsavel);

                // Cria a ação e associa o mesmo usuário como responsável e associado
                Acao acao = new Acao(nomeAcao, dataInicio, dataTermino, usuarioResponsavel);
                nomesAções.put(nomeAcao, acao);
                acao.adicionarUsuario(usuario);

                // Adiciona a ação à atividade
                atividade.adicionarAcao(acao);

                System.out.println("\nAção cadastrada com sucesso!");
            }
        }
    }
    //Método para encontras as ações por nome
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

    //Método para atualizar o status da açõa pertencente as opções do funcionário
    private void atualizarStatusDaAcao() {
        //Lista de ações cadastradas
        System.out.println("\nLista de Ações Cadastradas:");
        for (String nomeAcao : nomesAções.keySet()) {
            System.out.println(nomeAcao);
        }

        System.out.println("\nDigite o nome da ação que deseja atualizar: ");
        String nomeAcaoAtualizar = scanner.nextLine();

        // Verificar se a ação com o nome fornecido existe
        Acao acaoAtualizar = encontrarAcaoPorNome(nomeAcaoAtualizar);

        if (acaoAtualizar != null) {
            System.out.println("Ação encontrada!\nAltere o percentual de conclusão: ");
            int percentual = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            // Atualizar o status da ação
            acaoAtualizar.adicionarPercentualAcao(percentual);
            System.out.println("Status da ação '" + nomeAcaoAtualizar + "' atualizado com sucesso!");
        } else {
            System.out.println("Ação não encontrada.");
        }
    }

    //Método para vizualizar as informações do quadro kanban, onde visualizamos o projetos, atividades e ações
    private void visualizarQuadroKanban() {
    System.out.println("\t============================== Relatório ==============================\n");

    for (Projeto projeto : empresa.getProjetos()) {
        System.out.println("\tProjeto: " + projeto.getNome() + "= " + projeto.getPercentualProjeto() + "% concluído.\n");

        for (Atividades atividade : projeto.getAtividades()) {
            System.out.println("\tAtividade: " + atividade.getDescricao() + "= " + atividade.getPercentualAtividade() + "% concluído.\n");

            // Listar ações cadastradas
            System.out.println("\tAções cadastradas:\n");
            for (Acao acao : atividade.getAcoes()) {
                System.out.println("\t-> " + acao.getNome() + "= " + acao.progresso() + "% concluído" + " | Data inicial: " + acao.getDataInicio() + " | Data limite: " + acao.getDataFim() + "| Responsavel: " + acao.getUsuarioResponsavel());
            }

            System.out.println("\n\t========================== Quadro Kanban ==========================");
            System.out.println("\tStatus:");
            System.out.println("\t|            A FAZER            |            EM ANDAMENTO            |            FEITO             |\n");

            // Exibir as ações com base no status
            for (Acao acao : atividade.getAcoes()) {
                StatusAcao statusAcao = acao.getStatus();
                String tabulacao = "\t";

                // Determinar a tabulação com base no status
                if (acao.progresso() == 0) {
                    tabulacao += "";
                } else if (acao.progresso() < 100) {
                    tabulacao += "                                ";
                } else {
                    tabulacao += "                                                                     ";
                }

                // Exibir o nome da ação na posição correta
                System.out.println(tabulacao + " " + acao.getNome());
            }
        }
    }

    System.out.println("\t===================================================================");
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenu();
    }
}


//classe Principal
import java.text.ParseException;

public class Principal {
    public static void main(String[] args) throws ParseException {
        //Instanciando a classe Menu
        Menu menu = new Menu();
        //Chamando o metodo exibirMenu da classe Menu
        menu.exibirMenu();

    }
}
