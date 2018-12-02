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