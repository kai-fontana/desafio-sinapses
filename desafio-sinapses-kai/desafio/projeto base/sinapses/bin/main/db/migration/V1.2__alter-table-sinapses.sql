ALTER TABLE sinapses RENAME COLUMN data TO data_criacao;
ALTER TABLE sinapses ADD COLUMN data_atualizacao DATE;