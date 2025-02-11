/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_07;
import java.util.Scanner;

/**
 *
 * @author Luiz Fernando
 */
public class TesteFuncionarios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o tipo de funcionário:");
        System.out.println("1 - Gerente");
        System.out.println("2 - Desenvolvedor");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o salário do funcionário: ");
        double salario = scanner.nextDouble();

        Funcionario funcionario = null;

        switch (opcao) {
            case 1:
                funcionario = new Gerente(nome, salario);
                break;
            case 2:
                funcionario = new Desenvolvedor(nome, salario);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        if (funcionario != null) {
            funcionario.exibirDetalhes();
            System.out.println("Bônus: R$ " + funcionario.calcularBonus());
        }

        scanner.close();
    }
}

