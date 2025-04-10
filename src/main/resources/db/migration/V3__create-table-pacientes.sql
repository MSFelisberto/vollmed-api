CREATE TABLE pacientes
(
    id          BIGINT       not null auto_increment,
    nome        VARCHAR(100) not null,
    email       VARCHAR(100) not null unique,
    telefone    VARCHAR(20)  not null,
    cpf         VARCHAR(11)  not null unique,
    logradouro  varchar(100) not null,
    bairro      varchar(100) not null,
    cep         varchar(9)   not null,
    complemento varchar(100),
    numero      varchar(20),
    uf          char(2)      not null,
    cidade      varchar(100) not null,

    primary key (id)
);