package br.ufsm.backend_px.model.tipolinguagem;

import br.ufsm.backend_px.model.linguagem.Linguagem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "TipoLinguagem")
@Table(name = "tipolinguagem")
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

    @OneToMany(mappedBy = "tipoLinguagem")
    @JsonIgnore
    private List<Linguagem> tipolinguagem;
}
