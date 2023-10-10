INSERT INTO tipoLinguagem (nome) VALUES
    ('Programação'),
    ('Web'),
    ('Mobile');

INSERT INTO linguagem (nome, idTipoLinguagem) VALUES
    ('Java', 1),
    ('Python', 1),
    ('JavaScript', 2),
    ('React', 2),
    ('Swift', 3),
    ('Kotlin', 3);

INSERT INTO projeto (nome, descricao, link, dataPublicacao, resumo) VALUES
    ('Projeto A', 'Descrição do Projeto A', 'https://projetoa.com', '2023-01-15', 'Resumo do Projeto A'),
    ('Projeto B', 'Descrição do Projeto B', 'https://projetob.com', '2023-02-20', 'Resumo do Projeto B'),
    ('Projeto C', 'Descrição do Projeto C', 'https://projetoc.com', '2023-03-25', 'Resumo do Projeto C');

INSERT INTO linguagensProjeto (idLinguagem, idProjeto) VALUES
    (1, 1),
    (2, 1),
    (3, 2),
    (4, 2),
    (5, 3),
    (6, 3);

INSERT INTO usuario (nome, login, senha, permissao, descricao, foto, facebook, instagram, linkedin, github) VALUES
    ('Usuário 1', 'usuario1', 'senha1', 'Normal', 'Descrição do Usuário 1', 'https://facebook.com/usuario1', 'https://instagram.com/usuario1', 'https://linkedin.com/usuario1', 'https://github.com/usuario1'),
    ('Usuário 2', 'usuario2', 'senha2', 'Admin', 'Descrição do Usuário 2', 'https://facebook.com/usuario2', 'https://instagram.com/usuario2', 'https://linkedin.com/usuario2', 'https://github.com/usuario2'),
    ('Usuário 3', 'usuario3', 'senha3', 'Normal', 'Descrição do Usuário 3', 'https://facebook.com/usuario3', 'https://instagram.com/usuario3', 'https://linkedin.com/usuario3', 'https://github.com/usuario3');

INSERT INTO rede (idUsuarioOrigem, idUsuarioDestino) VALUES
    (1, 2),
    (1, 3),
    (2, 3);
