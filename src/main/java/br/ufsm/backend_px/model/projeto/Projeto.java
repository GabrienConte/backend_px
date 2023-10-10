package br.ufsm.backend_px.model.projeto;

import br.ufsm.backend_px.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "Projeto")
@Table(name = "projeto")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String link;
    private Timestamp datapublicacao;
    private String resumo;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
}
