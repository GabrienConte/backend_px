package br.ufsm.backend_px.service;

import br.ufsm.backend_px.model.usuario.Usuario;
import br.ufsm.backend_px.model.usuario.UsuarioRepository;
import br.ufsm.backend_px.model.usuario.DadosUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {
    private final
    UsuarioRepository repository;
    public UsuarioService (UsuarioRepository repository){
        this.repository = repository;
    }
    public void cadastrar(Usuario usuario){
        //Criptografa a senha do usuário ANTES desse ser salvo
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        this.repository.save(usuario);
    }
    public DadosUsuario findUsuario(Long id){
        Usuario usuario = this.repository.getReferenceById(id);
        return new DadosUsuario(usuario);
    }

    public DadosUsuario findUsuarioByUsername(String username){
        Usuario usuario = this.repository.findByNome(username);
        return new DadosUsuario(usuario);
    }

    public List<DadosUsuario> findAllUsuarios(){
        return this.repository.findAll().stream().map(DadosUsuario::new).toList();
    }
}
