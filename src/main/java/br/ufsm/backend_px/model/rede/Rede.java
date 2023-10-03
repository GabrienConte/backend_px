package br.ufsm.backend_px.model.rede;

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
    private Long UsuarioId;
    private Long SeguidorId;
}
