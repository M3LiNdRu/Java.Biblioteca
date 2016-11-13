SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Coleccio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Coleccio` (
  `Id` INT NOT NULL AUTO_INCREMENT ,
  `Nom` VARCHAR(45) NOT NULL ,
  `Descripcio` VARCHAR(45) NULL ,
  `Nvolums` INT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Idioma`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Idioma` (
  `Id` INT NOT NULL AUTO_INCREMENT ,
  `Nom` VARCHAR(45) NOT NULL ,
  `Referencia` VARCHAR(8) NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Genere`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Genere` (
  `Id` INT NOT NULL AUTO_INCREMENT ,
  `Nom` VARCHAR(45) NOT NULL ,
  `Descripcio` VARCHAR(45) NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Llibres`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Llibres` (
  `Id` INT NOT NULL AUTO_INCREMENT ,
  `Titol` VARCHAR(100) NOT NULL ,
  `Autor` VARCHAR(45) NOT NULL ,
  `Editorial` VARCHAR(45) NULL ,
  `Any` INT NULL ,
  `Edicio` INT NULL ,
  `Coleccio` INT NULL ,
  `Descripcio` VARCHAR(200) NULL ,
  `ISBN` VARCHAR(20) NULL ,
  `Genere` INT NOT NULL ,
  `Idioma` INT NOT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `Coleccio_idx` (`Coleccio` ASC) ,
  INDEX `Idioma_idx` (`Idioma` ASC) ,
  INDEX `Genere_idx` (`Genere` ASC) ,
  CONSTRAINT `Coleccio`
    FOREIGN KEY (`Coleccio` )
    REFERENCES `mydb`.`Coleccio` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Idioma`
    FOREIGN KEY (`Idioma` )
    REFERENCES `mydb`.`Idioma` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Genere`
    FOREIGN KEY (`Genere` )
    REFERENCES `mydb`.`Genere` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
