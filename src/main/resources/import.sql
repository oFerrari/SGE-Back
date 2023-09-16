INSERT INTO tb_cliente (id, nome, tipo, documento, endereco, telefone, email) VALUES(1, 'João Silva', 'Cliente', '123.456.789-00', 'Rua A, 123', '(11) 1234-5678', 'joao@example.com');
INSERT INTO tb_cliente (id, nome, tipo, documento, endereco, telefone, email) VALUES(2, 'Maria Souza', 'Cliente', '987.654.321-00', 'Avenida B, 456', '(22) 9876-5432', 'maria@example.com');
INSERT INTO tb_cliente (id, nome, tipo, documento, endereco, telefone, email) VALUES(3, 'Carlos Santos', 'Fornecedor', '456.789.123-00', 'Praça C, 789', '(33) 5555-1234', 'carlos@example.com');



INSERT INTO tb_motorista (id, nome, CNH, CPF, endereco, telefone, email, id_veiculo_fk) VALUES (1, 'Carlos Santos', '123456789', '456.789.123-00', 'Praça C, 789', '(33) 5555-1234', 'carlos@example.com');
INSERT INTO tb_motorista (id, nome, CNH, CPF, endereco, telefone, email, id_veiculo_fk) VALUES (2, 'João da Silva', '12345678901', '123.456.789-01', 'Rua A 123', '(11) 1234-5678', 'joao.silva@example.com',1);
INSERT INTO tb_motorista (id, nome, CNH, CPF, endereco, telefone, email, id_veiculo_fk) VALUES (3, 'Maria Souza', '98765432100', '987.654.321-00', 'Avenida B 456', '(22) 9876-5432', 'maria.souza@example.com',3);
INSERT INTO tb_motorista (id, nome, CNH, CPF, endereco, telefone, email, id_veiculo_fk) VALUES (4, 'Pedro Oliveira', '54321098765', '543.210.987-65', 'Rua C 789', '(33) 2345-6789', 'pedro.oliveira@example.com',2);

INSERT INTO tb_veiculo (id, placa, documento, modelo) VALUES(1, 'AAA-1111', '123456789', 'CARROÇA');
INSERT INTO tb_veiculo (id, placa, documento, modelo) VALUES(2, 'AAA-2222', '123456789', 'CARROÇA');
INSERT INTO tb_veiculo (id, placa, documento, modelo) VALUES(3, 'AAA-3333', '123456789', 'CARROÇA');
INSERT INTO tb_veiculo (id, placa, documento, modelo) VALUES(4, 'AAA-4444', '123456789', 'CARROÇA');