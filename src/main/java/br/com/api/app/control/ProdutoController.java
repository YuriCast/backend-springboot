package br.com.api.app.control;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.api.app.model.Produto;
import br.com.api.app.repository.ProdutoRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;
    @GetMapping
    public List<Produto> listarProduto() {
        return produtoRepository.findAll();
    }
    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

}
