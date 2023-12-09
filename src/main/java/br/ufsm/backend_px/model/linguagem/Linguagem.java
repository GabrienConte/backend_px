package br.ufsm.backend_px.model.linguagem;

import br.ufsm.backend_px.model.projeto.Projeto;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "linguagem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Linguagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idtipolinguagem")
    private TipoLinguagem tipoLinguagem;

    @ManyToMany(mappedBy = "linguagens")
    @JsonIgnore
    Set<Projeto> projetos;
}