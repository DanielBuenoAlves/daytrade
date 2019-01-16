    SELECT ordO.pregao, ordO.hora, cor.nome, ordO.quantidade, ordO.valor, ordO.agressor
      FROM ordem_original ordO
INNER JOIN corretora cor ON ordO.corretora = cor.id
     WHERE ordO.quantidade >= 250
       AND ordO.agressor IN('C', 'V')
       AND ordO.pregao = '2019-01-02'
  ORDER BY ordO.pregao, ordO.hora;



SELECT COUNT(*) FROM ordem_original 
WHERE quantidade >= 100
AND agressor = 'V'
ORDER BY pregao, hora;