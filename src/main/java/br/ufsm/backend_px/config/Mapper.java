package br.ufsm.backend_px.config;

import br.ufsm.backend_px.model.linguagem.Linguagem;
import br.ufsm.backend_px.model.linguagem.LinguagemDTO;
import br.ufsm.backend_px.model.projeto.Projeto;
import br.ufsm.backend_px.model.projeto.ProjetoDTO;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public ProjetoDTO toProjetoDto(Projeto projeto) {
        Long id = projeto.getId();
        String nome = projeto.getNome();
        String descricao = projeto.getDescricao();
        String link = projeto.getLink();
        Timestamp datapublicacao = projeto.getDatapublicacao();
        String resumo = projeto.getResumo();

        List<String> linguagensDTO = projeto.getLinguagens()
                .stream()
                .map(Linguagem::getNome)
                .collect(Collectors.toList());

        String criador = projeto.getUsuario() != null ? projeto.getUsuario().getNome() : null;

        return new ProjetoDTO(id, nome, descricao, link, datapublicacao, resumo, linguagensDTO, criador);
    }

    public Projeto toProjeto(ProjetoDTO projetoDTO) {

        return new Projeto(
                projetoDTO.getNome(),
                projetoDTO.getDescricao(),
                projetoDTO.getLink(),
                projetoDTO.getDatapublicacao(),
                projetoDTO.getResumo()
        );
    }
}
