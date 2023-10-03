create table usuario (
 id serial not null primary key,
 nome varchar not null,
 login varchar not null,
 senha varchar not null,
 permissao varchar not null,
 descricao varchar,
 foto varchar,
 facebook varchar,
 instagram varchar,
 linkedin varchar,
 github varchar
);