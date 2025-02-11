/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_03;

import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Digite a quantidade inicial em estoque: ");
        int quantidade = scanner.nextInt();

        GettersSetters produtoInfo = new GettersSetters(nome, preco, quantidade);
        Produto produto = new Produto(produtoInfo);

        int opcao;
        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("1 - Exibir informações do produto");
            System.out.println("2 - Adicionar unidades ao estoque");
            System.out.println("3 - Remover unidades do estoque");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    produto.exibirInformacoes();
                    break;
                case 2:
                    System.out.print("Digite a quantidade a adicionar: ");
                    int adicionar = scanner.nextInt();
                    produto.adicionarEstoque(adicionar);
                    break;
                case 3:
                    System.out.print("Digite a quantidade a remover: ");
                    int remover = scanner.nextInt();
                    produto.removerEstoque(remover);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

