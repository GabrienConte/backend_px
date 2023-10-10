create table projeto (
   id serial not null primary key,
   nome varchar not null,
   descricao varchar,
   link varchar,
   dataPublicacao date,
   resumo varchar
);

ALTER TABLE projeto ADD column idUsuario integer not null;

ALTER TABLE projeto ADD CONSTRAINT fk_idUsuario FOREIGN KEY (idUsuario) REFERENCES usuario (id);
