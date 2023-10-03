package br.com.api.app.model;
import lombok.Getter;
import lombok.Setter;
import br.com.api.app.control.UsuarioController;
import jakarta.persistence.*;

@Entity
@Table(name = "Acessa")
@Getter
@Setter
public class Acessa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UsuarioController usuario;


    @ManyToOne
    private Produto produto;
}
