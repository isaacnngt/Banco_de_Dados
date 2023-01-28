CREATE TABLE IF NOT EXISTS public.produto_tb (
id_produto SERIAL PRIMARY KEY,
desc_produto varchar(45),
valor numeric (10,2),
data_inclusao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS public.equipe_tb(
id_equipe SERIAL PRIMARY KEY,
desc_equipe varchar(45),
data_inclusao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS public.vendedor_tb(
id_vendedor SERIAL PRIMARY KEY,
nome varchar(45),
id_equipe integer not null,
data_inclusao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (id_equipe) REFERENCES equipe_tb (id_equipe)
);

CREATE TABLE IF NOT EXISTS public.venda_tb(
id_venda SERIAL PRIMARY KEY,
id_vendedor integer not null,
id_produto integer not null,
id_equipe integer not null,
data_inclusao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (id_vendedor) REFERENCES vendedor_tb (id_vendedor),
FOREIGN KEY (id_produto) REFERENCES produto_tb (id_produto),
FOREIGN KEY (id_equipe) REFERENCES equipe_tb (id_equipe)
);

INSERT INTO
  produto_tb
  (desc_produto, valor)
VALUES
  ('Xiaomi note 12', 2250.53),
  ('Xiaomi note 11', 1750.83),
  ('Iphone 14 Pro Max', 12250.74),
  ('Notebook Lenovo ThinkPad', 5863.25),
  ('Notebook Chromebok',1863.45),
  ('Play Station 4',2800.65),
  ('Play Station 5',3600.44);

INSERT INTO
  equipe_tb 
  (desc_equipe)
VALUES
  ('On-line'),
  ('Televendas'),
  ('Reclame Aqui'),
  ('Loja 1'),
  ('Loja 2'),
  ('Loja 3'),
  ('Loja 4');

INSERT INTO
  vendedor_tb 
  (nome,id_equipe)
VALUES
  ('Isaac',1),
  ('Marcelo',2),
  ('Monica',3),
  ('Rubens',1),
  ('Laura', 4),
  ('Pedro',3),
  ('Iago',5);

INSERT INTO
  venda_tb 
  (id_vendedor, id_produto, id_equipe)
VALUES
  (1,3,1),
  (2,2,2),
  (1,2,1),
  (5,4,4);