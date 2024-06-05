CREATE TABLE `funcionario` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(150) NOT NULL,
    `cpf` VARCHAR(14) UNIQUE NOT NULL,
    `tel` VARCHAR(20) NOT NULL,
    `salario` DECIMAL(10, 2) NOT NULL
);

CREATE TABLE `gerente` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(150) NOT NULL,
    `cpf` VARCHAR(14) UNIQUE NOT NULL,
    `tel` VARCHAR(20) NOT NULL,
    `salario` DECIMAL(10, 2) NOT NULL
);