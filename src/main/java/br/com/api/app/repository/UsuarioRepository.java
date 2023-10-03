package br.com.api.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.app.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
