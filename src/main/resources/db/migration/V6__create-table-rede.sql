create table rede (
    id serial not null primary key,
    idUsuarioOrigem int not null,
    idUsuarioDestino int not null ,
    FOREIGN KEY (idUsuarioOrigem) REFERENCES usuario (id),
    FOREIGN KEY (idUsuarioDestino) REFERENCES usuario (id)
);