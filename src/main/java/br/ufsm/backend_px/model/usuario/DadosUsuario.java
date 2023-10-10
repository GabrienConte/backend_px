package br.ufsm.backend_px.model.usuario;

public record DadosUsuario(Long id, String login, String nome,
                           String permissao, String descricao, String github, String instagram, String linkedin,
                           String facebook, String senha) {
    public DadosUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getLogin(), usuario.getNome(),
                usuario.getPermissao(), usuario.getDescricao(), usuario.getGithub(),
                usuario.getInstagram(), usuario.getLinkedin(), usuario.getFacebook(), usuario.getSenha());
    }
}
