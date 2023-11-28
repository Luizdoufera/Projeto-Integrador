//Classe Menu

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Menu {
    
    // Empuxo das classes auxiliares
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


    public Menu() {
        //Iniciação do Scanner 
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

    private void exibirOpcoes() {
        // Switch cases resposaveis por exibir a opções do menu pricipal
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

    //Opções que seram apresentadas no nivel de usuairo Administrador 
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

    private void cadastrarArea() {
        System.out.println("Digite o nome da área: ");
        String nomeArea = scanner.nextLine();
        Area area = new Area(nomeArea);
        areasCadastradas.put(nomeArea, area);
        System.out.println("\nÁrea cadastrada com sucesso!");
    }

    public Map<String, Area> getAreasCadastradas() {
        return areasCadastradas;
    }

    private void cadastrarUsuario() {
        System.out.println("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        Usuario usuario = new Usuario(nomeUsuario);
        nomeUsuarios.put(nomeUsuario, usuario);
        System.out.println("\nUsuário cadastrado com sucesso!");
    }

    private void exibirUsuariosCadastrados() {
        System.out.println("\nLista de Usuários Cadastrados:");
        for (String nomeUsuario : usuariosCadastrados.keySet()) {
            System.out.println(nomeUsuario);
        }
    }

    private int definirPerfilUsuario() {
        int perfil;
        try {
            System.out.println("\n** Vamos cadastrar uma conta de entrada **");
            System.out.println("\nInforme o nome: ");
            String nome = scanner.nextLine();
            System.out.println("Informe a senha: ");
            String senha = scanner.nextLine();

            Valida valida = new Valida(nome, senha);
            System.out.println("\nConta cadastrada!\n");

            int x = 1;
            while (x == 1) {
                System.out.println("Fazer longin\nInforme a senha cadastrada: ");
                String validaSenha = scanner.nextLine();

                if (valida.validarSenha(validaSenha)) {
                    System.out.println("Senha correta!!");
                    System.out.println("\n*** Bem vindo ao Kanban ***\n");

                    System.out.println("Digite o perfil de usuário\n1 - Administrador\n2 - Líder do projeto" +
                            "\n3 - Usuário");
                    perfil = scanner.nextInt();
                    scanner.nextLine();

                    while (perfil != 1 && perfil != 2 && perfil != 3) {
                        System.out.println("Perfil de usuário não reconhecido.\nTente novamente.");
                        System.out.println("Digite o perfil de usuário:\n1- Administrador\n2 - Líder do projeto" +
                                "\n3 - Usuário");
                        perfil = scanner.nextInt();
                    }
                    return perfil;

                } else {
                    System.out.println("Senha incorreta!!");
                    System.out.println("\nPara tentar novamente digite 1 ou para sair digite 2: ");
                    x = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            if (x == 2) {
                fimDaLinha();
            }
            return 0;
        }catch (InputMismatchException e){
            System.out.println("Entrada incorreta.\nUtilizando entrada padrão 1 - administrador!");
            perfil = 1;
            return perfil;
        }
    }

    private void solicitarPerfilUsuario() {
        System.out.println("Digite o perfil de usuário\n1 - Administrador\n2 - Líder do projeto\n3 - Usuário");
        perfilUsuarioAnterior = perfilUsuario;  // Adicione esta linha
        perfilUsuario = scanner.nextInt();
        while (perfilUsuario != 1 && perfilUsuario != 2 && perfilUsuario != 3) {
            System.out.println("\nPerfil de usuário não reconhecido.\nTente novamente.");
            System.out.println("Digite o perfil de usuário\n1 - Administrador\n2 - Líder do projeto\n3 - Usuário");
            perfilUsuario = scanner.nextInt();
        }
    }


    private void cadastrarEmpresa() {
        System.out.println("Digite o nome da empresa: ");
        String nomeEmpresa = scanner.nextLine();
        empresa.setNome(nomeEmpresa);
        System.out.println("\nEmpresa cadastrada com sucesso!");
    }

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


    private void visualizarQuadroKanban() {
        System.out.println("========================== Quadro Kanban ==============================");

        for (Projeto projeto : empresa.getProjetos()) {
            System.out.println(projeto);

            for (Atividades atividade : projeto.getAtividades()) {
                System.out.println(atividade);

                for (Acao acao : atividade.getAcoes()) {
                    System.out.println("\t\tAção: " + acao.getNome());
                    System.out.println("\t\t\tstatus: " + acao.getStatus());
                    System.out.println("\t\t\tProgresso: " + acao.progresso() + "%");
                    System.out.println("\t\t\tData de Início: " + acao.getDataInicio());
                    System.out.println("\t\t\tData de Término: " + acao.getDataFim());
                    System.out.println("\t\t\tÁrea Responsável: " + acao.getAreaResponsavel());
                    System.out.println("\t\t\tUsuário Responsável: " + acao.getUsuarioResponsavel());
                }
            }
        }

        System.out.println("==================================================================================");
    }
    public void fimDaLinha(){
        System.out.println("Fim da linha");
        System.exit(0);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenu();
    }
}
