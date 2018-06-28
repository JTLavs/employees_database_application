-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema employees_database
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema employees_database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `employees_database` DEFAULT CHARACTER SET latin1 ;
USE `employees_database` ;

-- -----------------------------------------------------
-- Table `employees_database`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employees_database`.`department` (
  `department_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`department_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `employees_database`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employees_database`.`employee` (
  `employee_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `salary` DECIMAL(11,2) NOT NULL,
  `NIN` VARCHAR(11) NOT NULL,
  `account_no` INT(11) NOT NULL,
  `sort_code` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`employee_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `employees_database`.`employee_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employees_database`.`employee_address` (
  `address_id` INT(11) NOT NULL AUTO_INCREMENT,
  `employee_id` INT(11) NOT NULL,
  `address_1` VARCHAR(100) NOT NULL,
  `address_2` VARCHAR(100) NULL DEFAULT NULL,
  `address_3` VARCHAR(100) NOT NULL,
  `postcode` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`address_id`),
  INDEX `employee_address_idx` (`employee_id` ASC),
  CONSTRAINT `employee_address`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employees_database`.`employee` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

