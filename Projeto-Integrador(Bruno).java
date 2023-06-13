package filme;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cinema {
    private final List<Filme> filmes;
    private final List<Sala> salas;
    private final List<Sessao> sessoes;

    public Cinema() {
        filmes = new ArrayList<>();
        salas = new ArrayList<>();
        sessoes = new ArrayList<>();
    }

    public void cadastrarFilme(String titulo, int duracao) {
        Filme filme = new Filme(titulo, duracao);
        filmes.add(filme);
        System.out.println("Filme cadastrado com sucesso!");
    }

    public void cadastrarSala(String nome) {
        Sala sala = new Sala(nome);
        salas.add(sala);
        System.out.println("Sala cadastrada com sucesso!");
        
    }
    public void cadastrarSessao(String tituloFilme, String nomeSala, LocalDateTime dataHora) {
        Filme filmeEncontrado = null;
        Sala salaEncontrada = null;
        
        // Procurar o filme pelo título
        for (Filme filme : filmes) {
            if (filme.getTitulo().equals(tituloFilme)) {
                filmeEncontrado = filme;
                break;
            }
        }

        // Procurar a sala pelo nome
        for (Sala sala : salas) {
            if (sala.getNome().equals(nomeSala)) {
                salaEncontrada = sala;
                break;
            }
        }

        if (filmeEncontrado != null && salaEncontrada != null) {
            Sessao sessao = new Sessao(filmeEncontrado, salaEncontrada, dataHora);
            sessoes.add(sessao);
            System.out.println("Sessão cadastrada com sucesso!");
        } else {
            System.out.println("Filme ou sala não encontrados. Certifique-se de cadastrar corretamente.");
        }
    }

    public void exibirFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
        } else {
            System.out.println("Filmes cadastrados:");
            for (Filme filme : filmes) {
                System.out.println("Título: " + filme.getTitulo() + ", Duração: " + filme.getDuracao() + " minutos");
            }
        }
    }

    public void exibirSalas() {
        if (salas.isEmpty()) {
           System.out.println("Nenhuma sala cadastrada.");
        } else {
           System.out.println("Salas cadastradas:");
              for (Sala sala : salas) {
                 System.out.println("Nome: " + sala.getNome());
            }
        }
    }
    
    public void exibirSessoes() {
    if (sessoes.isEmpty()) {
        System.out.println("Nenhuma sessão cadastrada.");
        } else {
         System.out.println("Sessões cadastradas:");
            for (Sessao sessao : sessoes) {
               System.out.println("Filme: " + sessao.getFilme().getTitulo());
               System.out.println("Sala: " + sessao.getSala().getNome());
               System.out.println("Data e Hora: " + sessao.getDataHora());
               System.out.println("---------------------------");
            }
        }
    }
     
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            
            do {
                System.out.println("\n===== Menu =====");
                System.out.println("1. Cadastrar filme");
                System.out.println("2. Cadastrar sala");
                System.out.println("3. Cadastrar sessão");
                System.out.println("4. Exibir filmes cadastrados");
                System.out.println("5. Exibir salas cadastradas"); 
                System.out.println("6. Exibir sessões cadastradas");
                System.out.println("7. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                
                switch (opcao) {
                case 1 -> {
                    scanner.nextLine();
                    System.out.print("Digite o título do filme: ");
                    String tituloFilme = scanner.nextLine();
                    System.out.print("Digite a duração do filme em minutos: ");
                    int duracao = scanner.nextInt();
                    cinema.cadastrarFilme(tituloFilme, duracao);
                    }
                case 2 -> {
                    scanner.nextLine();
                    System.out.print("Digite o nome da sala: ");
                    String nomeSala = scanner.nextLine();
                    cinema.cadastrarSala(nomeSala);
                    }
                case 3 -> {
                    scanner.nextLine();
                    System.out.print("Digite o título do filme: ");
                    String tituloSessao = scanner.nextLine();
                    System.out.print("Digite o nome da sala: ");
                    String salaSessao = scanner.nextLine();
                    System.out.print("Digite a data e hora da sessão (yyyy-mm-dd hh:mm): ");
                    String dataHoraSessao = scanner.nextLine();
                    LocalDateTime dataHora = LocalDateTime.parse(dataHoraSessao, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    cinema.cadastrarSessao(tituloSessao, salaSessao, dataHora);
                    }
                case 4 -> cinema.exibirFilmes();
                case 5 -> cinema.exibirSalas();
                case 6 -> cinema.exibirSessoes();
                case 7 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 7);

        scanner.close();
        }
    }
}

