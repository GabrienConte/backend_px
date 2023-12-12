package br.ufsm.backend_px.model.rede;

import br.ufsm.backend_px.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Rede")
@Table(name = "rede")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUsuarioOrigem")
    private Usuario UsuarioOrigem;
    @ManyToOne
    @JoinColumn(name = "idUsuarioDestino")
    private Usuario UsuarioDestino;
}
