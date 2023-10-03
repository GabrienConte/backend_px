create table rede (
    id serial not null primary key
);

ALTER TABLE rede ADD column idUsuarioOrigem integer not null;

ALTER TABLE rede ADD CONSTRAINT fk_idUsuarioOrigem FOREIGN KEY (idUsuarioOrigem) REFERENCES usuario (id);

ALTER TABLE rede ADD column idUsuarioDestino integer not null;

ALTER TABLE rede ADD CONSTRAINT fk_idUsuarioDestino FOREIGN KEY (idUsuarioDestino) REFERENCES usuario (id);