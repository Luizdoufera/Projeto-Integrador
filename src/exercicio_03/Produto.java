/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio_03;


public class Produto {
    private GettersSetters produto;

    public Produto(GettersSetters produto) {
        this.produto = produto;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Preço: R$" + produto.getPreco());
        System.out.println("Quantidade em estoque: " + produto.getQuantidadeEstoque());
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidade);
            System.out.println(quantidade + " unidades adicionadas ao estoque.");
        } else {
            System.out.println("Quantidade inválida para adicionar ao estoque.");
        }
    }

    public void removerEstoque(int quantidade) {
        if (quantidade > 0 && quantidade <= produto.getQuantidadeEstoque()) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
            System.out.println(quantidade + " unidades removidas do estoque.");
        } else {
            System.out.println("Quantidade inválida para remoção ou estoque insuficiente.");
        }
    }
}

