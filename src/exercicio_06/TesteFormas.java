/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_06;

import java.util.Scanner;

public class TesteFormas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione a forma geométrica:");
        System.out.println("1 - Retângulo");
        System.out.println("2 - Triângulo");
        System.out.println("3 - Círculo");
        int opcao = scanner.nextInt();

        Forma forma = null;

        switch (opcao) {
            case 1:
                System.out.print("Digite a base do retângulo: ");
                double baseRet = scanner.nextDouble();
                System.out.print("Digite a altura do retângulo: ");
                double alturaRet = scanner.nextDouble();
                forma = new Retangulo(baseRet, alturaRet);
                break;
            case 2:
                System.out.print("Digite a base do triângulo: ");
                double baseTri = scanner.nextDouble();
                System.out.print("Digite a altura do triângulo: ");
                double alturaTri = scanner.nextDouble();
                forma = new Triangulo(baseTri, alturaTri);
                break;
            case 3:
                System.out.print("Digite o raio do círculo: ");
                double raio = scanner.nextDouble();
                forma = new Circulo(raio);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        if (forma != null) {
            System.out.println("Área calculada: " + forma.calcularArea());
        }

        scanner.close();
    }
}

