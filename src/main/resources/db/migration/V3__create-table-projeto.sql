create table projeto (
   id serial not null primary key,
   nome varchar not null,
   descricao varchar,
   link varchar,
   dataPublicacao date,
   resumo varchar
);