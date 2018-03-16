CREATE TABLE `champion_cliente` (
  `idchampion` int(11) NOT NULL,
  `lane` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idchampion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE assinante_cliente (
  idAssinante int(11) NOT NULL,
   nome varchar(255) DEFAULT NULL,
   nascimento date DEFAULT NULL,
   sexo varchar(255) DEFAULT NULL,
   dataCadastro timestamp DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idAssinante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;