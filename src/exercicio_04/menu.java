/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_04;

import java.util.Scanner;
        
public class menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("1 - Cadastrar Carro");
            System.out.println("2 - Cadastrar Moto");
            System.out.println("3 - Exibir Detalhes de um Veículo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a marca do carro: ");
                    String marcaCarro = scanner.nextLine();
                    System.out.print("Digite o modelo do carro: ");
                    String modeloCarro = scanner.nextLine();
                    System.out.print("Digite o ano do carro: ");
                    int anoCarro = scanner.nextInt();
                    System.out.print("Digite o número de portas: ");
                    int portas = scanner.nextInt();
                    Carro carro = new Carro(marcaCarro, modeloCarro, anoCarro, portas);
                    System.out.println("\nDetalhes do Carro:");
                    carro.exibirDetalhes();
                    break;
                case 2:
                    System.out.print("Digite a marca da moto: ");
                    String marcaMoto = scanner.nextLine();
                    System.out.print("Digite o modelo da moto: ");
                    String modeloMoto = scanner.nextLine();
                    System.out.print("Digite o ano da moto: ");
                    int anoMoto = scanner.nextInt();
                    System.out.print("Digite as cilindradas: ");
                    int cilindradas = scanner.nextInt();
                    Moto moto = new Moto(marcaMoto, modeloMoto, anoMoto, cilindradas);
                    System.out.println("\nDetalhes da Moto:");
                    moto.exibirDetalhes();
                    break;
                case 3:
                    System.out.println("Ainda não implementado.");
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