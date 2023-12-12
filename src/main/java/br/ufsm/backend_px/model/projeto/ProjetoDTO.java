package br.ufsm.backend_px.model.projeto;

import br.ufsm.backend_px.model.linguagem.Linguagem;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
public class ProjetoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String link;
    private Timestamp datapublicacao;
    private String resumo;

    private List<String> linguagens;

    private String criador;

    public ProjetoDTO(Long id, String nome, String descricao, String link, Timestamp datapublicacao, String resumo, List<String> linguagens, String criador) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.link = link;
        this.datapublicacao = datapublicacao;
        this.resumo = resumo;
        this.linguagens = linguagens;
        this.criador = criador;
    }
}
