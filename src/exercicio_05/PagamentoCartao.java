/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_05;

/**
 *
 * @author Luiz Fernando
 */
class PagamentoCartao extends Pagamento {
    private static final double TAXA_CARTAO = 0.02;

    public PagamentoCartao(double valor) {
        super(valor);
    }

    @Override
    public double calcularValor() {
        return valor + (valor * TAXA_CARTAO);
    }
}

