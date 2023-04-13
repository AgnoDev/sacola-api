INSERT INTO restaurante (id, cep, complemento, name) VALUES
(1L, 'cep1', 'Endereço Restaurante 1', 'Restaurante 1'),
(2L, 'cep2', 'Endereço Restaurante 2', 'Restaurante 2');

INSERT INTO cliente (id, cep, complemento, name) VALUES
(1L, 'cep1', 'Endereço Cliente 1', 'Cliente 1');

INSERT INTO produto (id, disponivel, name, valor_unitario, restaurante_id) VALUES
(1L, true, 'Produto 1', 5.0, 1L),
(2L, true, 'Produto 2', 6.0, 1L),
(3L, true, 'Produto 3', 10.0, 2L);

INSERT INTO sacola (id, forma_pagto, fechada, valor_total, cliente_id) VALUES
(1L, 0, false, 0.0, 1L);