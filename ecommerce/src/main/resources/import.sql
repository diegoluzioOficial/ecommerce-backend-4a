-- Active: 1790032352769@@127.0.0.1@3306@ecommerce

insert into categoria (nome, descricao) values ('Livros', 'Livros Técnicos');
insert into categoria (nome, descricao) values ('Eletrônicos', 'Equipamentos Eletrônicos');
insert into categoria (nome, descricao) values ('Escritório', 'Material de Escritório');
insert into categoria (nome, descricao) values ('Ginástica', 'Equipamentos de Ginástica');
insert into categoria (nome, descricao) values ('Piscinas', 'Kit piscina 7000L');


insert into produto (nome, descricao, estoque, preco, categoria_id) values ('Código Limpo', 'Livro do Autor Robert Martin', 20, 73.44, 1);
insert into produto (nome, descricao, estoque, preco, categoria_id) values ('Fone de Ouvido Bluetooth', 'Fone de ouvido sem fio com bateria de até 40 horas, cancelamento de ruído passivo, dobrável e compatível com assistentes de voz.', 150, 249.90, 2);
insert into produto (nome, descricao, estoque, preco, categoria_id) values ('Grampeador Metálico Jocar', 'Grampeador de mesa, capacidade para 20 folhas, corpo em metal resistente.', 60, 18.50, 3);
insert into produto (nome, descricao, estoque, preco, categoria_id) values ('Halteres Emborrachados 5kg (Par)', 'Par de halteres revestidos em borracha, empunhadura ergonômica, ideal para treinos de força.', 45, 129.90, 4);
insert into produto (nome, descricao, estoque, preco, categoria_id) values ('Kit Piscina 7000L Completo', 'Piscina estruturada 7000 litros com filtro, bomba, escada e capa de proteção.', 15, 899.90, 5);


insert into cliente (nome, email, telefone) values ('Guilherme', 'GuiGonViado@email.com', '(14) 997341-1263');
insert into cliente (nome, email, telefone) values ('Daniel', 'dinielCos@email.com', '(14) 992358-1273');
insert into cliente (nome, email, telefone) values ('Gabriel', 'Biel_NXP@email.com', '(17) 994518-9873');
insert into cliente (nome, email, telefone) values ('Felipe', 'lipeSequi@email.com', '(11) 990203-8237');
insert into cliente (nome, email, telefone) values ('Luiz', 'Luizini@email.com', '(13) 994093-8237');


insert into pedido (data, status, valor_total, cliente_id) values ('2001-11-07 09:30:00', 'Enviado', 73.44, 1);
insert into pedido (data, status, valor_total, cliente_id) values ('2007-01-12 14:15:00', 'Enviado', 249.90, 2);
insert into pedido (data, status, valor_total, cliente_id) values ('2012-04-17 18:45:00', 'Processando', 18.50, 3);
insert into pedido (data, status, valor_total, cliente_id) values ('2015-08-23 16:45:00', 'Entregue', 129.90, 4);
insert into pedido (data, status, valor_total, cliente_id) values ('2020-02-11 11:20:00', 'Pendente', 899.90, 5);




insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 73.44, 1, 1);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 249.90, 2, 2);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 18.50, 3, 3);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 129.90, 4, 4);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 899.90, 5, 5);


insert into pagamento (valor, data, status, tipo, pedido_id) values (73.44, '2001-11-08 10:00:00', 'Pago', 'Cartão de Crédito', 1);
insert into pagamento (valor, data, status, tipo, pedido_id) values (249.90, '2007-01-13 14:30:00', 'Pago', 'Boleto', 2);
insert into pagamento (valor, data, status, tipo, pedido_id) values (18.50, '2012-04-18 09:15:00', 'Pendente', 'Pix', 3);
insert into pagamento (valor, data, status, tipo, pedido_id) values (129.90, '2015-08-23 17:00:00', 'Pago', 'Cartão de Débito', 4);
insert into pagamento (valor, data, status, tipo, pedido_id) values (899.90, '2020-02-11 11:35:00', 'Pago', 'Cartão de Crédito', 5);


