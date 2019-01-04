-- MySQL Script generated by MySQL Workbench
-- Fri Jan  4 14:49:47 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Corretora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Corretora` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Corretora` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `corPrimaria` VARCHAR(45) NOT NULL,
  `corSecundaria` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OrdemOriginal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`OrdemOriginal` ;

CREATE TABLE IF NOT EXISTS `mydb`.`OrdemOriginal` (
  `id` BIGINT NOT NULL,
  `pregao` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `corretora` INT NULL,
  `valor` DECIMAL NOT NULL,
  `agressor` CHAR(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_OrdOrig_SaldoCo_idx` (`corretora` ASC) VISIBLE,
  CONSTRAINT `FK_OrdOrig_SaldoCo`
    FOREIGN KEY (`corretora`)
    REFERENCES `mydb`.`Corretora` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SaldoCorretora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`SaldoCorretora` ;

CREATE TABLE IF NOT EXISTS `mydb`.`SaldoCorretora` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `pregao` DATE NOT NULL,
  `corretora` INT NOT NULL,
  `volumeFinanceiro` VARCHAR(45) NOT NULL,
  `volumeQuantidade` BIGINT NOT NULL,
  `media` DECIMAL NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_SaldoCo_Corretora_idx` (`corretora` ASC) VISIBLE,
  CONSTRAINT `FK_SaldoCo_Corretora`
    FOREIGN KEY (`corretora`)
    REFERENCES `mydb`.`Corretora` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Frequencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Frequencia` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Frequencia` (
  `pregao` DATE NOT NULL,
  `abertura` DECIMAL(7,2) NOT NULL,
  `maxima` DECIMAL(7,2) NOT NULL,
  `minima` DECIMAL(7,2) NOT NULL,
  `fechamento` DECIMAL(7,2) NOT NULL,
  `media` DECIMAL(4,2) NOT NULL,
  PRIMARY KEY (`pregao`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
