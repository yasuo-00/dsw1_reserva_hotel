-- MySQL Script generated by MySQL Workbench
-- Fri Nov 27 01:52:45 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`hotel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`hotel` ;

CREATE TABLE IF NOT EXISTS `mydb`.`hotel` (
  `cnpj` VARCHAR(14) NOT NULL,
  `hotel_name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cnpj`),
  UNIQUE INDEX `telefone_UNIQUE` (`phone` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`booking_site`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`booking_site` ;

CREATE TABLE IF NOT EXISTS `mydb`.`booking_site` (
  `url` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`url`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`user` ;

CREATE TABLE IF NOT EXISTS `mydb`.`user` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`sales_off`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`sales_off` ;

CREATE TABLE IF NOT EXISTS `mydb`.`sales_off` (
  `hotel_cnpj` INT NOT NULL,
  `booking_site_url` VARCHAR(60) NOT NULL,
  `initial_date` DATE NOT NULL,
  `final_date` DATE NOT NULL,
  `discount` INT NOT NULL,
  PRIMARY KEY (`hotel_cnpj`, `booking_site_url`, `initial_date`, `final_date`),
  INDEX `fk_hotel_has_site_reserva_site_reserva1_idx` (`booking_site_url` ASC) VISIBLE,
  INDEX `fk_hotel_has_site_reserva_hotel_idx` (`hotel_cnpj` ASC) VISIBLE,
  CONSTRAINT `fk_hotel_has_site_reserva_hotel`
    FOREIGN KEY (`hotel_cnpj`)
    REFERENCES `mydb`.`hotel` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hotel_has_site_reserva_site_reserva1`
    FOREIGN KEY (`booking_site_url`)
    REFERENCES `mydb`.`booking_site` (`url`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`user` ;

CREATE TABLE IF NOT EXISTS `mydb`.`user` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`table1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`table1` ;

CREATE TABLE IF NOT EXISTS `mydb`.`table1` (
  `idtable1` INT NOT NULL,
  `user_email` VARCHAR(45) NOT NULL,
  `user_hotel_cnpj` VARCHAR(14) NOT NULL,
  `user_booking_site_url` VARCHAR(45) NOT NULL,
  INDEX `fk_table1_user1_idx` (`user_email` ASC, `user_hotel_cnpj` ASC, `user_booking_site_url` ASC) VISIBLE,
  CONSTRAINT `fk_table1_user1`
    FOREIGN KEY (`user_email` , `user_hotel_cnpj` , `user_booking_site_url`)
    REFERENCES `mydb`.`user` (`email` , `hotel_cnpj` , `booking_site_url`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
