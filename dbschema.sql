-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema otog
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema otog
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `otog` DEFAULT CHARACTER SET utf8 ;
USE `otog` ;

-- -----------------------------------------------------
-- Table `otog`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `otog`.`user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `otog`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `otog`.`game` (
  `game_id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `year` INT(4) NOT NULL,
  `price` DECIMAL(15,2) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `score` INT(11) NOT NULL,
  `photo` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`game_id`, `user_id`),
  UNIQUE INDEX `game_id_UNIQUE` (`game_id` ASC) VISIBLE,
  INDEX `fk_game_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_game_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `otog`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `otog`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `otog`.`review` (
  `review_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `game_id` INT(11) NOT NULL,
  `time` TIMESTAMP NOT NULL,
  `score` INT(11) NOT NULL,
  `comment` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`review_id`, `user_id`, `game_id`),
  INDEX `fk_user_has_game_game1_idx` (`game_id` ASC) VISIBLE,
  INDEX `fk_user_has_game_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_game_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `otog`.`game` (`game_id`),
  CONSTRAINT `fk_user_has_game_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `otog`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `otog`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `otog`.`role` (
  `role_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(120) NULL DEFAULT NULL,
  PRIMARY KEY (`role_name`),
  UNIQUE INDEX `role_name_UNIQUE` (`role_name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `otog`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `otog`.`user_role` (
  `role_name` VARCHAR(45) NOT NULL DEFAULT 'user',
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_name`, `username`),
  INDEX `fk_role_has_user_role1_idx` (`role_name` ASC) VISIBLE,
  INDEX `asd_idx` (`username` ASC) VISIBLE,
  CONSTRAINT `fk_role_has_user_role1`
    FOREIGN KEY (`role_name`)
    REFERENCES `otog`.`role` (`role_name`),
  CONSTRAINT `fk_user_role_user_username`
    FOREIGN KEY (`username`)
    REFERENCES `otog`.`user` (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
