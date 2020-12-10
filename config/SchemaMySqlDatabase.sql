CREATE DATABASE IF NOT EXISTS HealthCare;


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema HealthCare
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema HealthCare
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `HealthCare` DEFAULT CHARACTER SET utf8 ;
USE `HealthCare` ;

-- -----------------------------------------------------
-- Table `HealthCare`.`Exam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HealthCare`.`Exam` ;

CREATE TABLE IF NOT EXISTS `HealthCare`.`Exam` (
  `IdExam` INT NOT NULL AUTO_INCREMENT,
  `IdHealthcareInstitution` INT NOT NULL,
  `PatientName` VARCHAR(100) NULL,
  `PatientAge` INT NULL,
  `PatientGender` VARCHAR(20) NULL,
  `PhysicianName` VARCHAR(100) NULL,
  `PhysicianCRM` VARCHAR(20) NULL,
  `ProcedureName` VARCHAR(100) NULL,
  PRIMARY KEY (`IdExam`),
  INDEX `fk_Exam_HealthcareInstitution_idx` (`IdHealthcareInstitution` ASC) VISIBLE,
  CONSTRAINT `fk_Exam_HealthcareInstitution`
    FOREIGN KEY (`IdHealthcareInstitution`)
    REFERENCES `HealthCare`.`HealthcareInstitution` (`IdHealthcareInstitution`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HealthCare`.`HealthcareInstitution`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HealthCare`.`HealthcareInstitution` ;

CREATE TABLE IF NOT EXISTS `HealthCare`.`HealthcareInstitution` (
  `IdHealthcareInstitution` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NULL,
  `Cnpj` BIGINT NULL,
  PRIMARY KEY (`IdHealthcareInstitution`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HealthCare`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HealthCare`.`User` ;

CREATE TABLE IF NOT EXISTS `HealthCare`.`User` (
  `login` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `superuser` TINYINT NULL,
  PRIMARY KEY (`login`))
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
