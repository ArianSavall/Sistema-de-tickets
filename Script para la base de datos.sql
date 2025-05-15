-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sistema-tickets
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sistema-tickets
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sistema-tickets` DEFAULT CHARACTER SET utf8 ;
USE `sistema-tickets` ;

-- -----------------------------------------------------
-- Table `sistema-tickets`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema-tickets`.`usuario` (
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `cuil` VARCHAR(20) NOT NULL,
  `foto_perfil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cuil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema-tickets`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema-tickets`.`cliente` (
  `cuil` VARCHAR(20) NOT NULL,
  `area` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cuil`),
  CONSTRAINT `cliente-usuario`
    FOREIGN KEY (`cuil`)
    REFERENCES `sistema-tickets`.`usuario` (`cuil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema-tickets`.`soporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema-tickets`.`soporte` (
  `cuil` VARCHAR(20) NOT NULL,
  `fecha_ingreso` DATE NOT NULL,
  `turno` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cuil`),
  CONSTRAINT `soporte-usuario`
    FOREIGN KEY (`cuil`)
    REFERENCES `sistema-tickets`.`usuario` (`cuil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema-tickets`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema-tickets`.`ticket` (
  `id_ticket` BIGINT NOT NULL AUTO_INCREMENT,
  `asunto` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(300) NOT NULL,
  `fecha_alta` DATETIME NOT NULL,
  `fecha_baja` DATETIME NULL,
  `prioridad` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `cliente_cuil` VARCHAR(20) NOT NULL,
  `soporte_cuil` VARCHAR(20) NULL,
  PRIMARY KEY (`id_ticket`),
  INDEX `fk_ticket_cliente1_idx` (`cliente_cuil` ASC) VISIBLE,
  INDEX `fk_ticket_soporte1_idx` (`soporte_cuil` ASC) VISIBLE,
  CONSTRAINT `fk_ticket_cliente1`
    FOREIGN KEY (`cliente_cuil`)
    REFERENCES `sistema-tickets`.`cliente` (`cuil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_soporte1`
    FOREIGN KEY (`soporte_cuil`)
    REFERENCES `sistema-tickets`.`soporte` (`cuil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema-tickets`.`valoracion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema-tickets`.`valoracion` (
  `id_valoracion` BIGINT NOT NULL AUTO_INCREMENT,
  `puntaje` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
  `comentario` VARCHAR(200) NULL,
  PRIMARY KEY (`id_valoracion`),
  CONSTRAINT `fk_valoracion-cliente`
    FOREIGN KEY (`id_valoracion`)
    REFERENCES `sistema-tickets`.`ticket` (`id_ticket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema-tickets`.`tarea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema-tickets`.`tarea` (
  `id_tarea` BIGINT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `completada` TINYINT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `id_ticket` BIGINT NOT NULL,
  PRIMARY KEY (`id_tarea`),
  INDEX `fk_tarea_ticket1_idx` (`id_ticket` ASC) VISIBLE,
  CONSTRAINT `fk_tarea_ticket1`
    FOREIGN KEY (`id_ticket`)
    REFERENCES `sistema-tickets`.`ticket` (`id_ticket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema-tickets`.`comentario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema-tickets`.`comentario` (
  `id_comentario` BIGINT NOT NULL AUTO_INCREMENT,
  `fecha_hora` DATETIME NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `id_ticket` BIGINT NOT NULL,
  `cuil_usuario` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_comentario`),
  INDEX `fk_comentario_ticket1_idx` (`id_ticket` ASC) VISIBLE,
  INDEX `fk_comentario_usuario1_idx` (`cuil_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_comentario_ticket1`
    FOREIGN KEY (`id_ticket`)
    REFERENCES `sistema-tickets`.`ticket` (`id_ticket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comentario_usuario1`
    FOREIGN KEY (`cuil_usuario`)
    REFERENCES `sistema-tickets`.`usuario` (`cuil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema-tickets`.`especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema-tickets`.`especialidad` (
  `id_especialidad` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_especialidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema-tickets`.`especialidad-soporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema-tickets`.`especialidad-soporte` (
  `id_especialidad` BIGINT NOT NULL,
  `soporte_cuil` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_especialidad`, `soporte_cuil`),
  INDEX `fk_especialidad_has_soporte_soporte1_idx` (`soporte_cuil` ASC) VISIBLE,
  INDEX `fk_especialidad_has_soporte_especialidad1_idx` (`id_especialidad` ASC) VISIBLE,
  CONSTRAINT `fk_especialidad_has_soporte_especialidad1`
    FOREIGN KEY (`id_especialidad`)
    REFERENCES `sistema-tickets`.`especialidad` (`id_especialidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_especialidad_has_soporte_soporte1`
    FOREIGN KEY (`soporte_cuil`)
    REFERENCES `sistema-tickets`.`soporte` (`cuil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
