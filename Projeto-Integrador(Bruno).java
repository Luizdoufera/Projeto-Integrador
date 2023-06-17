


package filme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cinema {
    private final List<Filme> filmes;
    private final List<Sala> salas;
    private final List<Sessao> sessoes;
    private final List<Poltrona> poltronas;

    public Cinema() {
        filmes = new ArrayList<>();
        salas = new ArrayList<>();
        sessoes = new ArrayList<>();
        poltronas = new ArrayList<>();
    }

    public void cadastrarFilme(String titulo, int duracao) {
        Filme filme = new Filme(titulo, duracao);
        filmes.add(filme);
        System.out.println("Filme cadastrado com sucesso!");
    }

    public void cadastrarSala(String nome, int numLinhas, int numColunas) {
        try {
            Sala sala = new Sala(nome, numLinhas, numColunas, true);
            salas.add(sala);
             System.out.println("Sala cadastrada com sucesso!");
        } catch (InputMismatchException e) {
             System.out.println("Digite um número válido para o número de linhas e colunas da sala.");
        }
    }
    public void cadastrarSessao(String tituloFilme, String nomeSala, String dataHora) {
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
        try {
            LocalDateTime dataHoraSessao = LocalDateTime.parse(dataHora, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
            int numLinhas = salaEncontrada.getNumLinhas();
            int numColunas = salaEncontrada.getNumColunas();
    
            Poltrona[][] poltronas = new Poltrona[numLinhas][numColunas];
    
            for (int i = 1; i <= numLinhas; i++) {
                for (int j = 1; j <= numColunas; j++) {
                    Poltrona poltrona = new Poltrona((i * numColunas) + j);
                    poltronas[i - 1][j - 1] = poltrona;
                }
            }   
            Sessao sessao = new Sessao(filmeEncontrado, salaEncontrada, dataHoraSessao, poltronas);
            sessoes.add(sessao);
            System.out.println("Sessão cadastrada com sucesso!");
        } catch (DateTimeParseException exception) {
            System.out.println("Formato de data e hora inválido. Certifique-se de inserir no formato dd-MM-yyyy HH:mm.");
        }
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
            System.out.println("Data e Hora: " + sessao.getDataHora().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));

            Poltrona[][] poltronas = sessao.getSala().getPoltronas();
            int numLinhas = sessao.getSala().getNumLinhas();
            int numColunas = sessao.getSala().getNumColunas();

            System.out.println("\nPoltronas:\n");

            // Exibir "Telão" centralizado na primeira linha
            int telaoPadding = (numColunas * 4 + 1 - 12) / 2;
            System.out.printf("%" + telaoPadding + "s    __T e l ã o__\n", "");
            System.out.println();

            // Exibir números das colunas alinhados
            System.out.print("   ");
            for (int col = 1; col <= numColunas; col++) {
                System.out.printf("%4d", col);
            }
            System.out.println();

            // Exibir poltronas
            char rowLabel = 'A';
            for (int row = 0; row < numLinhas; row++) {
                System.out.print(rowLabel + "  ");
                for (int col = 0; col < numColunas; col++) {
                    Poltrona poltrona = poltronas[row][col];
                    String status = poltrona.isDisponivel() ? "(U)" : "(X)";
                    System.out.printf("%4s", status);
                }
                System.out.println();
                rowLabel++;
            }

            System.out.println("---------------------------");
        }
    }
}




     
public void reservarPoltrona(String tituloFilme, String dataHoraSessao, int linha, int coluna) {
    Sessao sessaoEncontrada = null;
    
    try {
        LocalDateTime dataHoraSessaoFormatada = LocalDateTime.parse(dataHoraSessao, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

        // Procurar a sessão pelo título do filme e data/hora
        for (Sessao sessao : sessoes) {
            if (sessao.getFilme().getTitulo().equals(tituloFilme) && sessao.getDataHora().equals(dataHoraSessaoFormatada)) {
                sessaoEncontrada = sessao;
                break;
            }
        }
        
        if (sessaoEncontrada != null) {
            Sala sala = sessaoEncontrada.getSala();
            Poltrona[][] poltronas = sala.getPoltronas();

            if (linha >= 1 && linha < sala.getNumLinhas() && coluna >= 1 && coluna < sala.getNumColunas()) {
                Poltrona poltrona = poltronas[linha][coluna];
                if (!poltrona.isReservada()) {
                    poltrona.reservar();
                    sessaoEncontrada.incrementarQuantidadeIngressosVendidos();
                    System.out.println("Poltrona reservada com sucesso!");
                    imprimirIngresso(sessaoEncontrada, poltrona);
                } else {
                    System.out.println("Poltrona indisponível. Escolha outra poltrona.");
                }
            } else {
                System.out.println("Coordenadas da poltrona inválidas. Verifique a disponibilidade e tente novamente.");
            }
        } else {
            System.out.println("Sessão não encontrada. Certifique-se de informar corretamente o título do filme e a data/hora.");
        }
    } catch (DateTimeParseException e) {
        System.out.println("Formato de data/hora inválido. Certifique-se de informar no formato correto (dd-MM-yyyy HH:mm).");
    }
}


    
    public void imprimirIngresso(Sessao sessao, Poltrona poltrona) {
    System.out.println("||========== Ingresso ==========||");
    System.out.println("||Filme: " + sessao.getFilme().getTitulo());
    System.out.println("||Sala: " + sessao.getSala().getNome());
    System.out.println("||Data e Hora: " + sessao.getDataHora().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
    System.out.println("||Poltrona: " + poltrona.getCoordenada());
    System.out.println("||==============================||");
    }
    
    public void imprimirQuantidadeIngressosVendidos() {
    Map<String, Integer> ingressosVendidosPorFilme = new HashMap<>();

    for (Sessao sessao : sessoes) {
        Filme filme = sessao.getFilme();
        int quantidadeIngressosVendidos = sessao.getQuantidadeIngressosVendidos();

        // Verifica se o filme já está no mapa
        if (ingressosVendidosPorFilme.containsKey(filme.getTitulo())) {
            // Se o filme já está no mapa, incrementa a quantidade de ingressos vendidos
            int quantidadeAtual = ingressosVendidosPorFilme.get(filme.getTitulo());
            ingressosVendidosPorFilme.put(filme.getTitulo(), quantidadeAtual + quantidadeIngressosVendidos);
        } else {
            // Se o filme não está no mapa, adiciona com a quantidade de ingressos vendidos atual
            ingressosVendidosPorFilme.put(filme.getTitulo(), quantidadeIngressosVendidos);
        }
    }
        // Imprime a quantidade de ingressos vendidos por filme
        System.out.println("Quantidade de ingressos vendidos por filme:");
        for (String tituloFilme : ingressosVendidosPorFilme.keySet()) {
            int quantidade = ingressosVendidosPorFilme.get(tituloFilme);
               System.out.println(tituloFilme + ": " + quantidade + " ingressos");
    }
}

    
    public void imprimirOcupacaoPoltronas() {
    Sessao sessaoMaiorOcupacao = null;
    Sessao sessaoMenorOcupacao = null;
    int maiorOcupacao = Integer.MIN_VALUE;
    int menorOcupacao = Integer.MAX_VALUE;

    for (Sessao sessao : sessoes) {
        int ocupacao = sessao.calcularOcupacaoPoltronas();

        if (ocupacao > maiorOcupacao) {
            maiorOcupacao = ocupacao;
            sessaoMaiorOcupacao = sessao;
        }
        if (ocupacao < menorOcupacao) {
            menorOcupacao = ocupacao;
            sessaoMenorOcupacao = sessao;
        }
    }
    System.out.println("\n---- Relatório de Ocupação de Poltronas ----\n");
    System.out.println("Sessão com Maior Ocupação:");
    imprimirDetalhesSessao(sessaoMaiorOcupacao);

    System.out.println("\nSessão com Menor Ocupação:");
    imprimirDetalhesSessao(sessaoMenorOcupacao);
    }
    
    private void imprimirDetalhesSessao(Sessao sessao) {
    if (sessao != null) {
        System.out.println("Filme: " + sessao.getFilme().getTitulo());
        System.out.println("Sala: " + sessao.getSala().getNome());
        System.out.println("Data e Hora: " + sessao.getDataHora());
        System.out.println("Ocupação das Poltronas:");
        for (Poltrona[] linha : sessao.getSala().getPoltronas()) {
            for (Poltrona poltrona : linha) {
                System.out.println("Linha: " + poltrona.getNumeroLinha() + ", Coluna: " + poltrona.getNumeroColuna() + ", Status: " + (poltrona.isReservada() ? "Reservada" : "Disponível"));
            }
        }
    } else {
        System.out.println("Nenhuma sessão encontrada.");
    }
}


    public static void main(String[] args) {
       Cinema cinema = new Cinema();
       try (Scanner scanner = new Scanner(System.in)) {
        int opcao;
        System.out.println("\n=============== CINEMA ABC PRIME ===============\n");
        do {
            System.out.println("\n----- Menu Cinema ABC - Vendas de ingressos -----\n");
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Cadastrar sala");
            System.out.println("3. Cadastrar sessão");
            System.out.println("4. Exibir filmes cadastrados");
            System.out.println("5. Exibir salas cadastradas");
            System.out.println("6. Exibir sessões cadastradas");
            System.out.println("7. Reservar poltrona");
            System.out.println("8. Relátorio de vendas de ingressos");
            System.out.println("9. Relatório de lotação das sessões");
            System.out.println("10. Voltar ao Menu anterior");
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
                    System.out.print("Digite o número de linhas da sala: ");
                    int numLinhas = scanner.nextInt();
                    System.out.print("Digite o número de colunas da sala: ");
                    int numColunas = scanner.nextInt();
                    cinema.cadastrarSala(nomeSala, numLinhas, numColunas);
                }
                case 3 -> {
                    scanner.nextLine();
                    System.out.print("Digite o título do filme: ");
                    String tituloSessao = scanner.nextLine();
                    System.out.print("Digite o nome da sala: ");
                    String salaSessao = scanner.nextLine();
                    System.out.print("Digite a data e hora da sessão (dd-MM-yyyy hh:mm): ");
                    String dataHoraSessao = scanner.nextLine();
                    LocalDateTime dataHora = LocalDateTime.parse(dataHoraSessao, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
                    cinema.cadastrarSessao(tituloSessao, salaSessao, dataHoraSessao);

                }
                case 4 -> cinema.exibirFilmes();
                case 5 -> cinema.exibirSalas();
                case 6 -> cinema.exibirSessoes();
                case 7 -> {
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Digite o título do filme: ");
                    String tituloFilme = scanner.nextLine();
                    System.out.print("Digite a data e hora da sessão (dd-MM-yyyy hh:mm): ");
                    String dataHoraSessao = scanner.nextLine();
                    System.out.print("Digite a coordenada da poltrona (linha coluna): ");
                    int linha = scanner.nextInt();
                    int coluna = scanner.nextInt();
                    cinema.reservarPoltrona(tituloFilme, dataHoraSessao, linha, coluna);
                }
                case 8 -> cinema.imprimirQuantidadeIngressosVendidos();
                case 9 -> cinema.imprimirOcupacaoPoltronas();               
                case 10 -> System.out.println("MENU PRINCIPAL");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 10);

        scanner.close();
    }
  }
}
