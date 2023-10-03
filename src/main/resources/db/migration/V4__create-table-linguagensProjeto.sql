create table linguagensProjeto (
     id serial not null primary key
);

ALTER TABLE linguagensProjeto ADD column idLinguagem integer not null;

ALTER TABLE linguagensProjeto ADD CONSTRAINT fk_idLinguagem FOREIGN KEY (idLinguagem) REFERENCES linguagem (id);

ALTER TABLE linguagensProjeto ADD column idProjeto integer not null;

ALTER TABLE linguagensProjeto ADD CONSTRAINT fk_idProjeto FOREIGN KEY (idProjeto) REFERENCES projeto (id);