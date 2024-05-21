
-- Criação das tabelas 
create table Produtos(
ID_Produto int auto_increment not null,
Nome varchar(100), 
Valor double(5,2),
Descricao varchar(200),
Estoque int,
Fornecedor varchar(100),
Marca varchar (50),
Validade date,
primary key(ID_Produto)
);

create table Profissionais(
ID_Profissional int auto_increment not null,
Nome varchar(100),
Email varchar(100),
Funcao varchar(60),
Telefone varchar(40),
Senha varchar(50),
primary key (ID_Profissional)
);


create table Servicos(
ID_Servico int auto_increment not null,
Nome varchar(100), 
Valor double(5,2),
Descricao varchar(200),
ProfissionalResponsavel int,
Categoria varchar(100),
Gasto double(5,2),
TempoDeExecucao int,
Disponibilidade varchar(50),
primary key (ID_Servico),
foreign key (ProfissionalResponsavel) references Profissionais(ID_Profissional)
);

create table Clientes(
ID_Cliente int auto_increment not null,
Nome varchar(100),
email varchar(100),
senha varchar(50),
telefone varchar(50),
primary key (ID_Cliente)
);

-- INSERÇÃO DOS DADOS

insert into Clientes (Email, Senha) values ("admin", "admin");
insert into Profissionais (Email, Senha) values ("admin", "admin");


insert into Produtos (Nome, Valor, Descricao, Estoque, Fornecedor, Marca, Validade) values 
('Shampoo', 19.99, 'Shampoo para todos os tipos de cabelo', 50, 'Fornecedor A', 'Marca A', '2024-12-31'),
('Condicionador', 22.50, 'Condicionador hidratante', 30, 'Fornecedor B', 'Marca B', '2024-11-30'),
('Creme para pentear', 15.75, 'Creme para pentear com proteção térmica', 40, 'Fornecedor C', 'Marca C', '2025-01-15'),
('Máscara de tratamento', 35.00, 'Máscara de tratamento profundo', 20, 'Fornecedor D', 'Marca D', '2024-10-15'),
('Óleo capilar', 25.90, 'Óleo capilar nutritivo', 25, 'Fornecedor E', 'Marca E', '2024-09-25'),
('Gel fixador', 12.00, 'Gel fixador forte', 60, 'Fornecedor F', 'Marca F', '2025-02-28'),
('Spray fixador', 18.45, 'Spray fixador de longa duração', 35, 'Fornecedor G', 'Marca G', '2024-08-20'),
('Tônico capilar', 29.99, 'Tônico capilar revitalizante', 15, 'Fornecedor H', 'Marca H', '2024-11-15'),
('Leave-in', 17.25, 'Leave-in para cabelos cacheados', 50, 'Fornecedor I', 'Marca I', '2025-03-05'),
('Sérum capilar', 45.50, 'Sérum capilar reparador', 10, 'Fornecedor J', 'Marca J', '2024-12-10');

insert into Profissionais (Nome, Email, Funcao, Telefone, Senha) values 
('Ana Silva', 'ana.silva@exemplo.com', 'Cabeleireira', '11999999991', 'senha123'),
('Carlos Pereira', 'carlos.pereira@exemplo.com', 'Manicure', '11999999992', 'senha123'),
('Beatriz Santos', 'beatriz.santos@exemplo.com', 'Esteticista', '11999999993', 'senha123'),
('Diego Oliveira', 'diego.oliveira@exemplo.com', 'Barbeiro', '11999999994', 'senha123'),
('Fernanda Lima', 'fernanda.lima@exemplo.com', 'Depiladora', '11999999995', 'senha123'),
('Gustavo Souza', 'gustavo.souza@exemplo.com', 'Massoterapeuta', '11999999996', 'senha123'),
('Helena Costa', 'helena.costa@exemplo.com', 'Maquiadora', '11999999997', 'senha123'),
('Isabela Ribeiro', 'isabela.ribeiro@exemplo.com', 'Podóloga', '11999999998', 'senha123');


INSERT INTO Servicos (Nome, Valor, Descricao, ProfissionalResponsavel, Categoria, Gasto, TempoDeExecucao, Disponibilidade) VALUES 
('Corte de Cabelo Masculino', 30.00, 'Corte de cabelo para homens', 4, 'Cabelos', 5.00, 45, 'Seg-Sex 09:00-18:00'),
('Corte de Cabelo Feminino', 50.00, 'Corte de cabelo para mulheres', 1, 'Cabelos', 8.00, 60, 'Seg-Sex 09:00-18:00'),
('Manicure', 25.00, 'Serviço de manicure completo', 2, 'Unhas', 3.00, 30, 'Seg-Sex 10:00-19:00'),
('Pedicure', 30.00, 'Serviço de pedicure completo', 2, 'Unhas', 4.00, 45, 'Seg-Sex 10:00-19:00'),
('Limpeza de Pele', 60.00, 'Limpeza de pele profunda', 3, 'Estética', 10.00, 90, 'Ter-Qui 12:00-20:00'),
('Depilação Completa', 80.00, 'Depilação corporal completa', 5, 'Depilação', 15.00, 60, 'Seg-Sex 09:00-17:00'),
('Massagem Relaxante', 70.00, 'Massagem para relaxamento', 6, 'Massagens', 12.00, 60, 'Seg-Sex 09:00-20:00'),
('Maquiagem para Festas', 90.00, 'Maquiagem profissional para festas', 7, 'Maquiagem', 20.00, 90, 'Sab-Dom 08:00-18:00'),
('Pintura de Cabelo', 150.00, 'Pintura de cabelo com tintura especial', 1, 'Cabelos', 30.00, 120, 'Seg-Sex 09:00-18:00'),
('Design de Sobrancelhas', 40.00, 'Design de sobrancelhas com henna', 3, 'Estética', 5.00, 30, 'Seg-Sex 09:00-19:00');

select * from clientes;
select * from servicos;
select * from profissionais;
select * from produtos;