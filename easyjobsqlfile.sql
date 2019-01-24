-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema easyjobs
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema easyjobs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `easyjobs` DEFAULT CHARACTER SET utf8 ;
USE `easyjobs` ;

-- -----------------------------------------------------
-- Table `easyjobs`.`client_data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easyjobs`.`client_data` (
  `id` INT unsigned NOT NULL,
  `name` TEXT NOT NULL,
  `address` TEXT NOT NULL,
  `email_id` TEXT NOT NULL,
  `contact` VARCHAR(13) NOT NULL,
  `web_address` TEXT NULL,
  `user_name` VARCHAR(45) NOT NULL UNIQUE,
  `password` VARCHAR(45) NOT NULL,
  `created_at` VARCHAR(45) NULL,
  `updated_at` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `easyjobs`.`applicant_data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easyjobs`.`applicant_data` (
  `id` INT unsigned NOT NULL,
  `name` TEXT NOT NULL,
  `address` TEXT NOT NULL,
  `contact` VARCHAR(13) NOT NULL,
  `email_id` TEXT NOT NULL,
  `qualification` TEXT NOT NULL,
  `certification_training` TEXT NULL,
  `experience` VARCHAR(45) NOT NULL,
  `resume` TEXT NULL,
  `user_name` VARCHAR(45) NOT NULL UNIQUE,
  `password` VARCHAR(45) NOT NULL,
  `job_type_preference` VARCHAR(45) NULL,
  `open_for_relocation` TINYINT NULL,
  `current_salary` VARCHAR(45) NULL,
  `expected_salary` VARCHAR(45) NULL,
  `created_at` VARCHAR(45) NULL,
  `updated_at` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `easyjobs`.`job_data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easyjobs`.`job_data` (
  `id` INT unsigned NOT NULL,
  `title` TEXT NOT NULL,
  `location` TEXT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `qualification` TEXT NULL,
  `experience` VARCHAR(45) NULL,
  `skills` TEXT NULL,
  `description` TEXT NULL,
  `start_date_time` TEXT NULL,
  `end_date_time` TEXT NULL,
  `budget` VARCHAR(45) NULL,
  `job_client_id` INT unsigned NOT NULL,
  `created_at` VARCHAR(45) NULL,
  `updated_at` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_job` FOREIGN KEY (`job_client_id`) REFERENCES `client_data` (`id`));


-- -----------------------------------------------------
-- Table `easyjobs`.`project_data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easyjobs`.`project_data` (
  `id` INT unsigned NOT NULL	,
  `name` TEXT NOT NULL,
  `start_date_time` TEXT NOT NULL,
  `end_date_time` TEXT NOT NULL,
  `client_name` TEXT NOT NULL,
  `project_duration` TEXT NOT NULL,
  `project_location` TEXT NOT NULL,
  `created_at` VARCHAR(45) NULL,
  `updated_at` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
