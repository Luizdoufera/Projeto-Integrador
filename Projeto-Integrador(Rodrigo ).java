// classe principal
public class Principal {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenu();
    }
}

//______________________________________________________
// classe projeto
import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private String nome;
    private String descricao;
    private List<Atividades> atividades;

    public Projeto() {
        this.atividades = new ArrayList<>();
    }

    public Projeto(String nomeProjeto, String descricao) {
        this.nome = nomeProjeto;
        this.descricao = descricao;
        this.atividades = new ArrayList<>();
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
    
    public List<Atividades> getAtividades() {
        return atividades;
    }

}


//______________________________________________________
// classe empresa
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private List<Projeto> projetos;

    public Empresa() {
        this.projetos = new ArrayList<>();
    }

    public Empresa(String nome) {
        this.nome = nome;
        this.projetos = new ArrayList<>();
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
}


//______________________________________________________
// classe atividades
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

    public Atividades(String descricao) {
        this.nomeAtividade = descricao;  // Corrigido para usar a descrição
        this.progresso = 0;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.acoes = new ArrayList<>();
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
            somaPercentuais += acao.progresso();
        }

        return somaPercentuais / acoes.size();  // Média dos percentuais das ações.
    }

    public String getDescricao() {
        return descricao;
    }

    public void estaConcluida() {
        int percentual = getPercentualConcluido();
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
        return """
               Informação geral da tarefa
               Atividade: """ + nomeAtividade + "\nAções: " + acoes +
                "\nData de início da tarefa: " + dataInicio + "\nData Fim da tarefa: " + dataTermino;
    }
}



//______________________________________________________
// classe açao
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public void concluirAcao(int percentual) {
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



//______________________________________________________
// classe area
public class Area {
    private String nomeArea;

    public Area(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    public String getNomeArea() {
        return nomeArea;
    }
}



//______________________________________________________
// classe usuario
public class Usuario {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}


//______________________________________________________
// classe statusAcao Enum
public enum StatusAcao {
    A_FAZER,
    EM_PROGRESSO,
    CONCLUIDO
}


//______________________________________________________
// classe menu
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Empresa empresa;
    private Map<String, Acao> acoesCadastradas;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.empresa = new Empresa();
        this.acoesCadastradas = new HashMap<>();
    }

    public void exibirMenu() {
        int escolha;

        do {
            System.out.println("1. Cadastrar Empresa");
            System.out.println("2. Cadastrar Projeto");
            System.out.println("3. Cadastrar Atividade");
            System.out.println("4. Cadastrar Ação");
            System.out.println("5. Cadastrar Usuário");
            System.out.println("6. Atualizar status da Ação");
            System.out.println("7. Visualizar quadro Kanban");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (escolha) {
                case 1:
                    cadastrarEmpresa();
                    break;
                case 2:
                    cadastrarProjeto();
                    break;
                case 3:
                    cadastrarAtividade();
                    break;
                case 4:
                    cadastrarAcao();
                    break;
                case 5:
                    cadastrarUsuario();
                    break;
                case 6:
                    atualizarStatusDaAcao();
                    break;
                case 7:
                    visualizarQuadroKanban();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 0);
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
        empresa.adicionarProjeto(projeto);

        System.out.println("Projeto cadastrado com sucesso!");
    }

    private void cadastrarAtividade() {
    Projeto projeto = escolherProjeto();
    if (projeto != null) {
        System.out.print("Digite o nome da atividade: ");
        String nomeAtividade = scanner.nextLine();

        // Cria uma nova atividade com o nome fornecido pelo usuário
        Atividades atividade = new Atividades(nomeAtividade);
        projeto.adicionarAtividade(atividade);

        System.out.println("Atividade '" + nomeAtividade + "' cadastrada com sucesso!");
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

    private void cadastrarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        // Você pode decidir como associar o usuário ao projeto, empresa, ou ação escolhida
        // Se precisar, pode incluir lógica aqui para escolher o projeto, empresa ou ação
        Usuario usuario = new Usuario(nomeUsuario);
        // Adiciona o usuário ao projeto, empresa ou ação escolhida
        // Exemplo: empresa.getProjetos().get(0).getAtividades().get(0).getAcoes().get(0).adicionarUsuario(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
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
        acaoAtualizar.concluirAcao(percentual);
        System.out.println("Status da ação '" + nomeAcaoAtualizar + "' atualizado com sucesso!");
    } else {
        System.out.println("Ação não encontrada.");
    }
}

    
    private void visualizarQuadroKanban() {
        System.out.println("==== Quadro Kanban ====");

        for (Projeto projeto : empresa.getProjetos()) {
            System.out.println("Projeto: " + projeto.getNome());

            for (Atividades atividade : projeto.getAtividades()) {
                System.out.println("\tAtividade: " + atividade.getDescricao());

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




