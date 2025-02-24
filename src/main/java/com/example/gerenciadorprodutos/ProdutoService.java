package com.example.gerenciadorprodutos;

import com.example.gerenciadorprodutos.Produto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private final List<Produto> produtos = new ArrayList<>();

    public List<Produto> listar() {
        return produtos;
    }

    public Produto adicionar(Produto produto) {
        produto.setId((long) (produtos.size() + 1));
        produtos.add(produto);
        return produto;
    }
}