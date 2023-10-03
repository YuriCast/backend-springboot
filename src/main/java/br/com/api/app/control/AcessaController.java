package br.com.api.app.control;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.api.app.model.Acessa;
import br.com.api.app.repository.AcessaRepository;

import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/acessa")
public class AcessaController {

    @Autowired
    private AcessaRepository acessaRepository;
    @GetMapping
    public List<Acessa> listarAcessas() {
        return acessaRepository.findAll();
    }
    @PostMapping
    public Acessa criarAcessa(@RequestBody Acessa acessa) {
        return acessaRepository.save(acessa);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAcessa(@PathVariable String id) {
        try {
            acessaRepository.deleteById(id);
            return ResponseEntity.ok("Acessa deletado com sucesso.");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Acessa> atualizarAcessa(@PathVariable String id, @RequestBody Acessa acessaAtualizado) {
        if (acessaRepository.existsById(id)) {
            Acessa acessa = acessaRepository.findById(id).get();
            acessa.setId(acessaAtualizado.getId());
            acessa.setUsuario(acessaAtualizado.getUsuario());
            acessa.setProduto(acessaAtualizado.getProduto());
            Acessa acessaAtualizadoBD = acessaRepository.save(acessa);
            return ResponseEntity.ok(acessaAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
