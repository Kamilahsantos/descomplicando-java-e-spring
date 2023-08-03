package com.linuxtips.produtosapi.controller;


import com.linuxtips.produtosapi.model.Produto;
import com.linuxtips.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/produtos")
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoRepository.salvar(produto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/produtos/{id}")
    public Produto buscarProdutoPeloId(@PathVariable("id") String produtoId) {
        return produtoRepository.buscarProdutoPeloId(produtoId);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/produtos/{id}")
    public String apagarProduto(@PathVariable("id") String produtoId) {
        return produtoRepository.excluir(produtoId);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/produtos/{id}")
    public Produto atualizarProdutos(@PathVariable("id") String produtoId,
                                     @RequestBody Produto produto) {
        return produtoRepository.atualizar(produtoId, produto);
    }

}
