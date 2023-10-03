create table linguagem (
  id serial not null primary key,
  nome varchar(50) not null
);

ALTER TABLE linguagem ADD column idTipoLinguagem integer not null;

ALTER TABLE linguagem ADD CONSTRAINT fk_idTipoLinguagem FOREIGN KEY (idTipoLinguagem) REFERENCES tipoLinguagem (id);