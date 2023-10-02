package br.ufsm.backend_px.model.tipolinguagem;

import br.ufsm.backend_px.model.linguagem.Linguagem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipoLinguagem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoLinguagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id")
    private Linguagem linguagem;
}
