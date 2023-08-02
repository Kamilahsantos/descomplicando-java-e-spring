package com.linuxtips.produtosapi.controller;


import com.linuxtips.produtosapi.model.Produto;
import com.linuxtips.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/produtos")
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoRepository.salvar(produto);
    }

    @GetMapping("/produtos/{id}")
    public Produto buscarProdutoPeloId(@PathVariable("id") String produtoId) {
        return produtoRepository.buscarProdutoPeloId(produtoId);
    }

    @DeleteMapping("/produtos/{id}")
    public String apagarProduto(@PathVariable("id") String produtoId) {
        return  produtoRepository.excluir(produtoId);
    }

    @PutMapping("/produtos/{id}")
    public Produto atualizarProdutos(@PathVariable("id") String produtoId,
                                     @RequestBody Produto produto) {
        return produtoRepository.atualizar(produtoId, produto);
    }

}
