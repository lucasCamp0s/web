use formula1;
select * from ingresso;

-- criando procedure para inserir novos ingressos
DELIMITER $$
CREATE PROCEDURE inserir_ingresso(in nome varchar(45),
                                  in data_evento datetime,
                                  in cidade varchar(45),
                                  in pais varchar(45),
                                  in preco float(6,2),
                                  in descricao varchar(300),
                                  in arquibancada_id_arquibancada int(11))
BEGIN
	insert into ingresso values(null,nome,data_evento,cidade,pais,preco,descricao,arquibancada_id_arquibancada);
END $$
DELIMITER ;

-- drop procedure inserir_ingresso;

-- criando uma visão para mostrar no pagina index as proximas corridas
create view proximasCorridas (imagem,nome,data)
as
Select autodromo.imagem,autodromo.nome,circuito.data from autodromo,autodromo_has_circuito,circuito
    where autodromo.id_autodromo = autodromo_id_autodromo and
		circuito_id_circuito = id_circuito and 
			circuito.data >= now() -- now retorna a data de hoje
				group by circuito.data;
                
select * from proximasCorridas;