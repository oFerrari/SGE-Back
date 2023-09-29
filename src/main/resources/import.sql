INSERT INTO tb_cliente ( nome, tipo, documento, endereco, telefone, email) VALUES( 'João Silva', 'Cliente', '123.456.789-00', 'Rua A, 123', '(11) 1234-5678', 'joao@example.com');
INSERT INTO tb_cliente ( nome, tipo, documento, endereco, telefone, email) VALUES( 'Maria Souza', 'Cliente', '987.654.321-00', 'Avenida B, 456', '(22) 9876-5432', 'maria@example.com');
INSERT INTO tb_cliente ( nome, tipo, documento, endereco, telefone, email) VALUES( 'Carlos Santos', 'Fornecedor', '456.789.123-00', 'Praça C, 789', '(33) 5555-1234', 'carlos@example.com');

INSERT INTO tb_motorista ( nome, CNH, CPF, endereco, telefone, email) VALUES ( 'Carlos Santos', '123456789', '456.789.123-00', 'Praça C, 789', '(33) 5555-1234', 'carlos@example.com');
INSERT INTO tb_motorista ( nome, CNH, CPF, endereco, telefone, email) VALUES ( 'João da Silva', '12345678901', '123.456.789-01', 'Rua A 123', '(11) 1234-5678', 'joao.silva@example.com');
INSERT INTO tb_motorista ( nome, CNH, CPF, endereco, telefone, email) VALUES ( 'Maria Souza', '98765432100', '987.654.321-00', 'Avenida B 456', '(22) 9876-5432', 'maria.souza@example.com');
INSERT INTO tb_motorista ( nome, CNH, CPF, endereco, telefone, email) VALUES ( 'Pedro Oliveira', '54321098765', '543.210.987-65', 'Rua C 789', '(33) 2345-6789', 'pedro.oliveira@example.com');

INSERT INTO tb_veiculo ( placa, renavam, modelo, capacidade, id_motorista_fk) VALUES( 'AAA-1111', '123456789', 'CARROÇA', '250 kg',1);
INSERT INTO tb_veiculo ( placa, renavam, modelo, capacidade, id_motorista_fk) VALUES( 'AAA-2222', '123456789', 'CARROÇA', '690 kg',2);
INSERT INTO tb_veiculo ( placa, renavam, modelo, capacidade, id_motorista_fk) VALUES( 'AAA-3333', '123456789', 'CARROÇA', '500 kg',3);
INSERT INTO tb_veiculo ( placa, renavam, modelo, capacidade, id_motorista_fk) VALUES( 'AAA-4444', '123456789', 'CARROÇA', '650 kg',4);