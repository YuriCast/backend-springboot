package br.com.api.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.app.model.Acessa;
@Repository
public interface AcessaRepository extends JpaRepository<Acessa, String> {
}
