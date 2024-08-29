INSERT INTO tb_cliente ( nome, tipo, documento, endereco, telefone, email) VALUES( 'João Silva', 'Comerciante', '123.456.789-00', 'Rua A, 123', '(11) 1234-5678', 'joao@example.com');
INSERT INTO tb_cliente ( nome, tipo, documento, endereco, telefone, email) VALUES( 'Maria Souza', 'Fabricante', '987.654.321-00', 'Avenida B, 456', '(22) 9876-5432', 'maria@example.com');
INSERT INTO tb_cliente ( nome, tipo, documento, endereco, telefone, email) VALUES( 'Tapajós', 'Fabricante', '65.456.789/0001-80', 'Av. campo belo, 789', '(33) 3461-1264', 'tapajos@example.com');
INSERT INTO tb_cliente ( nome, tipo, documento, endereco, telefone, email) VALUES( 'Carlos Santos', 'Fornecedor', '456.789.123-00', 'Praça C, 789', '(33) 5555-1234', 'carlos@example.com');
INSERT INTO tb_cliente ( nome, tipo, documento, endereco, telefone, email) VALUES( 'Copasul', 'Fornecedor', '55.241.691/0005-96', 'Zona rural(sede)', '(33) 5555-1234', 'carlos@example.com');

INSERT INTO tb_motorista ( nome, CNH, CPF, endereco, telefone, email) VALUES ('Carlos Santos', '123456789', '456.789.123-00', 'Praça C, 789', '(33) 5555-1234', 'carlos@example.com');
INSERT INTO tb_motorista ( nome, CNH, CPF, endereco, telefone, email) VALUES ('João da Silva', '12345678901', '123.456.789-01', 'Rua A 123', '(11) 1234-5678', 'joao.silva@example.com');
INSERT INTO tb_motorista ( nome, CNH, CPF, endereco, telefone, email) VALUES ('Maria Souza', '98765432100', '987.654.321-00', 'Avenida B 456', '(22) 9876-5432', 'maria.souza@example.com');
INSERT INTO tb_motorista ( nome, CNH, CPF, endereco, telefone, email) VALUES ('Pedro Oliveira', '54321098765', '543.210.987-65', 'Rua C 789', '(33) 2345-6789', 'pedro.oliveira@example.com');
INSERT INTO tb_motorista ( nome, CNH, CPF, endereco, telefone, email) VALUES ('Lucia Oliveira', '45678901234', '456.789.012-34', 'Rua F 567', '(55) 1234-5678', 'lucia.oliveira@example.com');
INSERT INTO tb_motorista ( nome, CNH, CPF, endereco, telefone, email) VALUES ('Eduardo Souza', '78901234567', '789.012.345-67', 'Avenida G 876', '(66) 3456-7890', 'eduardo.souza@example.com');
INSERT INTO tb_motorista ( nome, CNH, CPF, endereco, telefone, email) VALUES ('Fernanda Santos', '21098765432', '210.987.654-32', 'Rua H 234', '(77) 6789-0123', 'fernanda.santos@example.com');
INSERT INTO tb_motorista ( nome, CNH, CPF, endereco, telefone, email) VALUES ('Ricardo Silva', '54321098765', '543.210.987-65', 'Avenida I 789', '(88) 9012-3456', 'ricardo.silva@example.com');


INSERT INTO tb_veiculo (placa, renavam, modelo, capacidade, id_motorista_fk) VALUES ('XYZ-3333', '987654321', 'F-1500', '1500 kg', 8);
INSERT INTO tb_veiculo (placa, renavam, modelo, capacidade, id_motorista_fk) VALUES ('BBB-4444', '123456789', 'Van', '1000 kg', 7);
INSERT INTO tb_veiculo (placa, renavam, modelo, capacidade, id_motorista_fk) VALUES ('CCC-5555', '987654321', 'CARROÇA', '2000 kg', 6);
INSERT INTO tb_veiculo (placa, renavam, modelo, capacidade, id_motorista_fk) VALUES ('DDD-6666', '123456789', 'Furgão', '800 kg', 5);
INSERT INTO tb_veiculo (placa, renavam, modelo, capacidade, id_motorista_fk) VALUES ('CCC-5555', '987654321', 'Picape', '200 kg', 4);
INSERT INTO tb_veiculo (placa, renavam, modelo, capacidade, id_motorista_fk) VALUES ('DDD-6666', '123456789', 'Furgão', '800 kg', 3);
INSERT INTO tb_veiculo (placa, renavam, modelo, capacidade, id_motorista_fk) VALUES ('EEE-7777', '987654321', 'Caminhão', '1200 kg', 2);
INSERT INTO tb_veiculo (placa, renavam, modelo, capacidade, id_motorista_fk) VALUES ('FFF-8888', '123456789', 'Van', '900 kg', 2);
INSERT INTO tb_veiculo (placa, renavam, modelo, capacidade, id_motorista_fk) VALUES ('GGG-9999', '987654321', 'Furgão', '700 kg', 2);
INSERT INTO tb_veiculo (placa, renavam, modelo, capacidade, id_motorista_fk) VALUES( 'CCC-9999', '123456789', 'Caminhão Bau', '50 kg',1);


INSERT INTO tb_pedido_entrega (mercadoria, origem, destino, emissao, data_entrega, status_pedido, id_cliente_fk, id_veiculo_fk) VALUES ('Soja', 'Fazenda 2S', 'Silos', '2023-11-15 14:00:00', '2023-11-16 16:30:00', 'PENDENTE', 5, 7);
INSERT INTO tb_pedido_entrega (mercadoria, origem, destino, emissao, data_entrega, status_pedido, id_cliente_fk, id_veiculo_fk) VALUES ('Imoveis', 'Rua A, 123', 'Rua B, 456', '2023-10-25 10:00:00', '2023-10-26 15:00:00', 'PENDENTE', 1, 1);
INSERT INTO tb_pedido_entrega (mercadoria, origem, destino, emissao, data_entrega, status_pedido, id_cliente_fk, id_veiculo_fk) VALUES ('Mercadoria ABC', 'Rua C, 789', 'Rua D, 012', '2023-11-01 12:30:00', '2023-11-02 14:45:00', 'EM_TRANSITO', 3, 2);
INSERT INTO tb_pedido_entrega (mercadoria, origem, destino, emissao, data_entrega, status_pedido, id_cliente_fk, id_veiculo_fk) VALUES ('Trelissa de Ferro', 'Avenida E, 345', 'Avenida F, 678', '2023-11-05 08:15:00', '2023-11-06 10:30:00', 'ATRASADO', 3, 3);
INSERT INTO tb_pedido_entrega (mercadoria, origem, destino, emissao, data_entrega, status_pedido, id_cliente_fk, id_veiculo_fk) VALUES ('Mercadoria GHI', 'Rua H, 901', 'Rua I, 234', '2023-11-10 18:00:00', '2023-11-11 20:15:00', 'CONCLUIDO', 4, 4);


INSERT INTO tb_administrador (foto, email, senha) VALUES ('assets/dev.jpg', 'andrei.vinicius@ifms.edu.br', '123456');
