create table pessoas(

    id bigint NOT NULL auto_increment,
    nome VARCHAR(100) NOT NULL,
    cpf FIXED (11) UNIQUE,
    logradouro VARCHAR(100) NOT NULL,
    numero INT,
    complemento VARCHAR(100),
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado ENUM ('AC', 'AL', 'AM', 'AP', 'BA', 'CE', 'DF', 'ES',
    'GO', 'MA', 'MG', 'MT', 'MS', 'PA', 'PB', 'PR', 'PE', 'PI',
    'RJ', 'RN', 'RO', 'RR', 'SC', 'RS', 'SP', 'SE', 'TO') NOT NULL,
    ativo tinyint DEFAULT 1,

    PRIMARY KEY(id)

);