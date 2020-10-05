
CREATE TABLE `ubs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vlr_latitude` varchar(100) DEFAULT NULL,
  `vlr_longitude` varchar(100) DEFAULT NULL,
  `cod_munic` varchar(100) DEFAULT NULL,
  `cod_cnes` varchar(100) DEFAULT NULL,
  `nom_estab` varchar(300) DEFAULT NULL,
  `dsc_endereco` varchar(300) DEFAULT NULL,
  `dsc_bairro` varchar(100) DEFAULT NULL,
  `dsc_cidade` varchar(100) DEFAULT NULL,
  `dsc_telefone` varchar(40) DEFAULT NULL,
  `dsc_estrut_fisic_ambiencia` varchar(100) DEFAULT NULL,
  `dsc_adap_defic_fisic_idosos` varchar(100) DEFAULT NULL,
  `dsc_equipamentos` varchar(100) DEFAULT NULL,
  `dsc_medicamentos` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
)