/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_05;
import java.util.Scanner;

/**
 *
 * @author Luiz Fernando
 */
public class TestePagamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o método de pagamento:");
        System.out.println("1 - Cartão");
        System.out.println("2 - Boleto");
        int opcao = scanner.nextInt();

        System.out.print("Digite o valor do pagamento: ");
        double valor = scanner.nextDouble();

        Pagamento pagamento;

        if (opcao == 1) {
            pagamento = new PagamentoCartao(valor);
        } else {
            pagamento = new PagamentoBoleto(valor);
        }

        pagamento.exibirDetalhes();
        scanner.close();
    }
}
