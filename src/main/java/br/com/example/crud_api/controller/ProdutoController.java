package br.com.example.crud_api.controller;

import br.com.example.crud_api.model.Produto;
import br.com.example.crud_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Combinação das anotações @Controller e @ResponseBody, indicando que os métodos retornarão dados JSON.
@RequestMapping("/api/produtos") // Define o prefixo da URL para todos os endpoints neste controlador
public class ProdutoController {

    @Autowired // Injeta a dependência do ProdutoRepository.
    private ProdutoRepository produtoRepository;

    // Criar um novo produto (Create)
    @PostMapping // Mapeiam as requisições HTTP para os métodos correspondentes.
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) { // @RequestBody (Converte o corpo da requisição JSON em um objeto Produto)
        Produto novoProduto = produtoRepository.save(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    // Listar todos os produtos (Read)
    @GetMapping // Mapeiam as requisições HTTP para os métodos correspondentes.
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    // Buscar um produto por ID (Read)
    @GetMapping("/{id}") // Mapeiam as requisições HTTP para os métodos correspondentes.
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) { // @PathVariable (Extrai valores da URL)
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Atualizar um produto (Update)
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoAtualizado.getNome());
                    produto.setDescricao(produtoAtualizado.getDescricao());
                    produto.setPreco(produtoAtualizado.getPreco());
                    Produto produtoSalvo = produtoRepository.save(produto);
                    return new ResponseEntity<>(produtoSalvo, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Deletar um produto (Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarProduto(@PathVariable Long id) {
        try {
            produtoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}