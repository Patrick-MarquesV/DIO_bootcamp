CREATE TABLE IF NOT EXISTS banco (
	numero INTEGER NOT NULL,
	nome VARCHAR(50) NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT TRUE,
	data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (numero)
);

CREATE TABLE IF NOT EXISTS agencia (
	banco_numero INTEGER NOT NULL,
	numero INTEGER NOT NULL,
	nome VARCHAR(80) NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT TRUE,
	data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (banco_numero,numero),
	FOREIGN KEY (banco_numero) REFERENCES banco (numero)
);

CREATE TABLE IF NOT EXISTS cliente (
	numero BIGSERIAL PRIMARY KEY,
	nome VARCHAR(120) NOT NULL,
	email VARCHAR(250) NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT TRUE,
	data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS conta_corrente (
	banco_numero INTEGER NOT NULL,
	agencia_numero INTEGER NOT NULL,
	numero BIGINT NOT NULL,
	digito SMALLINT NOT NULL,
	cliente_numero BIGINT NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT TRUE,
	data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (banco_numero,agencia_numero,numero,digito,cliente_numero),
	FOREIGN KEY (banco_numero,agencia_numero) REFERENCES agencia (banco_numero,numero),
	FOREIGN KEY (cliente_numero) REFERENCES cliente (numero)
);

CREATE TABLE IF NOT EXISTS tipo_transacao (
	id SMALLSERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT TRUE,
	data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS cliente_transacoes (
	id BIGSERIAL PRIMARY KEY,
	banco_numero INTEGER NOT NULL,
	agencia_numero INTEGER NOT NULL,
	conta_corrente_numero BIGINT NOT NULL,
	conta_corrente_digito SMALLINT NOT NULL,
	cliente_numero BIGINT NOT NULL,
	tipo_transacao_id SMALLINT NOT NULL,
	valor NUMERIC(15,2) NOT NULL,
	data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (banco_numero,agencia_numero,conta_corrente_numero,conta_corrente_digito,cliente_numero) REFERENCES conta_corrente(banco_numero,agencia_numero,numero,digito,cliente_numero)
);

--SELECTS PARA VISUALIZAÇÃO DOS DADOS:

SELECT numero, nome FROM banco;
SELECT banco_numero, numero, nome FROM agencia;
SELECT numero, nome, email FROM cliente;
SELECT banco_numero, agencia_numero, cliente_numero FROM cliente_transacoes;    

--EXIBE AS INFORMAÇÕES DAS COLUNAS DE DADA TABELA
SELECT * FROM information_schema.columns WHERE table_name = 'banco';
SELECT column_name FROM information_schema.columns WHERE table_name = 'banco';

--FUNÇÃO AVG (MÉDIA):
SELECT AVG(valor) FROM cliente_transacoes;

--FUNÇÃO COUNT (CONTAGEM):
SELECT COUNT(numero) FROM cliente;

SELECT COUNT(numero), email FROM cliente WHERE email ILIKE '%gmail.com' GROUP BY email;

--adicionando o having fazemos um filtro:
SELECT COUNT(id), tipo_transacao_id FROM cliente_transacoes GROUP BY tipo_transacao_id HAVING COUNT(id) > 150;

SELECT COUNT(1) FROM cliente_transacoes; -- O 1 é apenas um inteiro, o que permite a contagem do numero de linhas da tabela

--o distinct conta apenas os diferentes:

SELECT COUNT(numero) FROM banco;
SELECT COUNT(distinct numero) FROM banco;


--FUNÇÃO MAX (MAXIMO) E MIN (MINIMO):
SELECT MAX(valor) FROM cliente_transacoes;
SELECT MIN(valor) FROM cliente_transacoes;

SELECT MAX(valor),tipo_transacao_id FROM cliente_transacoes GROUP BY tipo_transacao_id;

SELECT MIN(valor),tipo_transacao_id FROM cliente_transacoes GROUP BY tipo_transacao_id;

--FUNÇÂO SUM (SOMA):
SELECT SUM(valor) FROM cliente_transacoes;
SELECT SUM(valor), tipo_transacao_id FROM cliente_transacoes GROUP BY tipo_transacao_id ORDER BY SUM(valor) DESC;

--JOINS

--JOIN ou INNER JOIN (pega apenas as linhas que possuem relação nas duas tabelas):
SELECT * FROM banco;
SELECT * FROM agencia;

SELECT banco.numero, banco.nome, agencia.numero, agencia.nome FROM banco JOIN agencia ON banco.numero = agencia.banco_numero;

SELECT COUNT(1), banco.numero FROM banco JOIN agencia ON banco.numero = agencia.banco_numero GROUP BY banco.numero;

-- LEFT JOIN (pega todos os valores da tabela a esquerda e relaciona as linhas que forem possiveis, deixando o restante NULL):

SELECT banco.numero, banco.nome, agencia.numero, agencia.nome FROM banco LEFT JOIN agencia ON banco.numero = agencia.banco_numero;

-- RIGHT JOIN (pega todos os valores da tabela a direita e relaciona as linhas que forem possiveis, deixando o restante NULL):

SELECT banco.numero, banco.nome, agencia.numero, agencia.nome FROM banco RIGHT JOIN agencia ON banco.numero = agencia.banco_numero; --nesse caso o resultado é igual ao JOIN pois não há agencia alguma sem banco!

SELECT banco.numero, banco.nome, agencia.numero, agencia.nome FROM agencia RIGHT JOIN banco ON banco.numero = agencia.banco_numero; --invertido banco por agencia para dar null

-- FULL JOIN (pega todos os valores de ambas as tabelas e relaciona as linhas que forem possiveis, deixando o restante NULL):

SELECT banco.numero, banco.nome, agencia.numero, agencia.nome FROM banco FULL JOIN agencia ON banco.numero = agencia.banco_numero;

-- CROSS JOIN (Relaciona cada linha da primeira talabela com todas as linhas da segunda, como uma matriz):

SELECT banco.numero, banco.nome, agencia.numero, agencia.nome FROM banco CROSS JOIN agencia ORDER BY banco.numero;

-- CTE (commom table expressions):

--WITH armazena tabelas temporarias
WITH tbl_tmp_banco AS (
	SELECT numero, nome FROM banco

)
SELECT numero, nome FROM tbl_tmp_banco;

--FILTRANDO POR NUMERO DO BANCO USANDO WITH:
WITH params AS (
	SELECT	213 AS banco_numero
), tbl_tmp_banco AS (
	SELECT numero, nome FROM banco JOIN params ON params.banco_numero = banco.numero	

)

SELECT numero, nome FROM tbl_tmp_banco;

WITH clientes_e_transacoes AS (
	SELECT 	cliente.nome AS cliente_nome, 
			tipo_transacao.nome AS tipo_transacao_nome, 
			cliente_transacoes.valor AS cliente_transacoes_valor
	FROM cliente_transacoes
	JOIN cliente ON cliente.numero = cliente_transacoes.cliente_numero
	JOIN tipo_transacao ON tipo_transacao.id = cliente_transacoes.tipo_transacao_id
)

SELECT cliente_nome, tipo_transacao_nome, cliente_transacoes_valor FROM clientes_e_transacoes;

--VIEWS:

SELECT numero, nome, ativo FROM banco;

CREATE OR REPLACE VIEW vw_bancos AS (
	SELECT numero, nome, ativo
	FROM banco
)

SELECT numero, nome, ativo FROM vw_bancos;

CREATE OR REPLACE VIEW vw_bancos_2 (banco_numero, banco_nome, banco_ativo) AS (
	SELECT numero, nome, ativo
	FROM banco
)

SELECT banco_numero, banco_nome, banco_ativo
FROM vw_bancos_2;

--Usando o insert na View, adiciona a informação na tabela original
INSERT INTO vw_bancos_2(banco_numero, banco_nome, banco_ativo) VALUES (51, 'Banco Boa Ideia', TRUE);

SELECT banco_numero, banco_nome, banco_ativo
FROM vw_bancos_2
WHERE banco_numero=51;

SELECT numero, nome, ativo
FROM Banco
WHERE numero = 51;

UPDATE vw_bancos_2 SET banco_ativo = FALSE WHERE banco_numero=51;

DELETE FROM vw_bancos_2 WHERE banco_numero = 51;

--TEMPORARY cria uma view que dura somente enquanto a sessão atual permanecer ativa

CREATE OR REPLACE TEMPORARY VIEW vw_agencia AS (
	SELECT nome FROM agencia
);

SELECT nome FROM agencia;

--WITH LOCAL CHECK OPTION impede a inserção de valores que não condizem com o WHERE
CREATE OR REPLACE VIEW vw_bancos_ativos AS (
	SELECT numero, nome, ativo
	FROM banco
	WHERE ativo = TRUE
) WITH LOCAL CHECK OPTION;

INSERT INTO vw_bancos_ativos (numero, nome, ativo) VALUES (51, 'Banco Boa Ideia', FALSE); --FALHA

CREATE OR REPLACE VIEW vw_bancos_com_a AS (
	SELECT numero, nome, ativo
	FROM vw_bancos_ativos
	WHERE nome ILIKE 'a%'
)WITH LOCAL CHECK OPTION; 

SELECT numero, nome, ativo
FROM vw_bancos_com_a;

INSERT INTO vw_bancos_com_a(numero, nome, ativo) VALUES (51, 'Alfa Omega', TRUE); --OK
INSERT INTO vw_bancos_com_a(numero, nome, ativo) VALUES (51, 'Alfa Omega', FALSE); 
--FALHA POIS HERDA O WHERE ativo = true da view que ele chama vw_bancos_ativos, removendo o WITH LOCAL CHECK OPTION do vw_bancos_ativos resolve
--TROCANDO O WITH LOCAL POR WITH CASCADE tambem da ERRO, pois ele herda todas as restrições (WHERE) das views que estão relacionadas em cascata

DELETE FROM vw_bancos_com_a WHERE numero = 51;

--Usando o RECURSIVE:

CREATE TABLE IF NOT EXISTS funcionarios(
	id SERIAL,
	nome VARCHAR(50),
	gerente INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY (gerente) REFERENCES funcionarios(id)
);

INSERT INTO funcionarios(nome, gerente) VALUES ('Ancelmo', null);
INSERT INTO funcionarios(nome, gerente) VALUES ('Beatriz', 1);
INSERT INTO funcionarios(nome, gerente) VALUES ('Magno', 1);
INSERT INTO funcionarios(nome, gerente) VALUES ('Cremilda', 2);
INSERT INTO funcionarios(nome, gerente) VALUES ('Wagner', 3);

SELECT id, nome, gerente FROM funcionarios;

--aqui que rola a recusividade no Join, exibindo em ordem hierarquica 
CREATE OR REPLACE RECURSIVE VIEW vw_func(id, gerente, funcionario) AS (
	SELECT id, gerente, nome
	FROM funcionarios
	WHERE gerente IS null
	UNION ALL
	SELECT funcionarios.id, funcionarios.gerente, funcionarios.nome
	FROM funcionarios
	JOIN vw_func ON vw_func.id = funcionarios.gerente
);

SELECT id, gerente, funcionario
FROM vw_func;

DROP TABLE funcionarios CASCADE;

--TRANSAÇÕES:

SELECT numero, nome, ativo FROM banco ORDER BY numero;

UPDATE banco SET ativo = false WHERE numero = 0;

BEGIN; --inicia uma alteração controlada!
UPDATE banco SET ativo = TRUE WHERE numero = 0; --altera
ROLLBACK; --retorna para o estado anterior

BEGIN; --inicia uma alteração controlada!
UPDATE banco SET ativo = TRUE WHERE numero = 0; --altera
COMMIT; --retorna para o begin em caso de erro

--na tabela funcionarios

SELECT id, gerente, nome
FROM funcionarios;

BEGIN;
UPDATE funcionarios SET gerente = 2 WHERE id = 3;
SAVEPOINT sp_func;
UPDATE funcionarios SET gerente = null;
ROLLBACK TO sp_func;
UPDATE funcionarios SET gerente = 3 WHERE id = 5;
COMMIT;


--FUNÇÕES:

--SQL não permite transações
CREATE OR REPLACE FUNCTION func_somar(INTEGER, INTEGER)
	RETURNS INTEGER 
	SECURITY DEFINER
	-- RETURNS NULL ON NULL INPUT -- NAO PERMITE Q A FUNÇÃO POSSUA INPUT NULL
	CALLED ON NULL INPUT -- PERMITE INPUT NULL
	LANGUAGE SQL
	AS $$
		SELECT COALESCE($1,0) + COALESCE($2,0) --COALESCE caso algum valor seja nulo, retorna o primeiro que não for nulo
	$$;

SELECT func_somar(1,100);

--PGSQL permite transações
CREATE OR REPLACE FUNCTION banco_add(p_numero INTEGER, p_nome VARCHAR, p_ativo BOOLEAN)
RETURNS INTEGER
SECURITY INVOKER
LANGUAGE PLPGSQL
CALLED ON NULL INPUT
AS $$
DECLARE variavel_id INTEGER;
BEGIN

	IF p_nome IS null OR p_ativo IS null OR p_nome IS null THEN
		RETURN 0;
	END IF;

	SELECT INTO variavel_id NUMERO
	FROM banco 
	WHERE numero = p_numero;

	IF variavel_id IS NULL THEN 
		INSERT INTO banco(numero, nome, ativo)
		VALUES(p_numero, p_nome, p_ativo);
	ELSE
		RETURN variavel_id;
	END IF;

	RETURN variavel_id;
END; $$;

SELECT banco_add(5432, 'Banco Novo', FALSE);

SELECT numero, nome, ativo FROM banco WHERE numero = 5432;


