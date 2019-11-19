-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema clockwork
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema clockwork
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clockwork` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `clockwork` ;

-- -----------------------------------------------------
-- Table `clockwork`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clockwork`.`employee` ;

CREATE TABLE IF NOT EXISTS `clockwork`.`employee` (
  `User_Id` INT(11) NOT NULL,
  `First_Name` VARCHAR(255) NOT NULL,
  `Last_Name` VARCHAR(255) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  `Role_Id` INT(11) NOT NULL,
  PRIMARY KEY (`User_Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `clockwork`.`hours`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clockwork`.`hours` ;

CREATE TABLE IF NOT EXISTS `clockwork`.`hours` (
  `User_Id` INT(11) NOT NULL,
  `End_Date` DATE NOT NULL,
  `Mon_Hours` INT(11) NOT NULL,
  `Tues_Hours` INT(11) NOT NULL,
  `Weds_Hours` INT(11) NOT NULL,
  `Thurs_Hours` INT(11) NOT NULL,
  `Fri_Hours` INT(11) NOT NULL,
  `Total_Hours` INT(11) NOT NULL,
  PRIMARY KEY (`User_Id`),
  CONSTRAINT `FK_UserID`
    FOREIGN KEY (`User_Id`)
    REFERENCES `clockwork`.`employee` (`User_Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `clockwork`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clockwork`.`role` ;

CREATE TABLE IF NOT EXISTS `clockwork`.`role` (
  `Role_ID` INT(11) NOT NULL,
  `Role` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Role_ID`),
  CONSTRAINT `FK_RoleID`
    FOREIGN KEY (`Role_ID`)
    REFERENCES `clockwork`.`employee` (`User_Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

insert into employee (User_id, First_Name, Last_Name, Password, Role_Id ) values (1, 'Shaun','Kolich','test', 1);

insert into employee (User_id, First_Name, Last_Name, Password, Role_Id ) values (2, 'Dan','Pickles','test', 1);

insert into employee (User_id, First_Name, Last_Name, Password, Role_Id ) values (3, 'Bob','Dillon','test', 1);

insert into employee (User_id, First_Name, Last_Name, Password, Role_Id ) values (4, 'Tom','Cruise','test', 1);

insert into employee (User_id, First_Name, Last_Name, Password, Role_Id ) values (5, 'Tommy','Jones','test', 1);

insert into hours (User_Id, End_Date, Mon_Hours, Tues_Hours, Weds_Hours, Thurs_Hours, Fri_Hours,Total_Hours) values (1,'2019-11-15',8,8,8,8,8,40);

insert into hours (User_Id, End_Date, Mon_Hours, Tues_Hours, Weds_Hours, Thurs_Hours, Fri_Hours,Total_Hours) values (2,'2019-11-15',8,8,8,8,8,40);

insert into hours (User_Id, End_Date, Mon_Hours, Tues_Hours, Weds_Hours, Thurs_Hours, Fri_Hours,Total_Hours) values (3,'2019-11-15',8,8,8,8,8,40);

insert into hours (User_Id, End_Date, Mon_Hours, Tues_Hours, Weds_Hours, Thurs_Hours, Fri_Hours,Total_Hours) values (4,'2019-11-15',8,8,8,8,8,40);

insert into hours (User_Id, End_Date, Mon_Hours, Tues_Hours, Weds_Hours, Thurs_Hours, Fri_Hours,Total_Hours) values (5,'2019-11-15',8,8,8,8,8,40);

insert into role (Role_ID, Role) values(1,'Employee');

insert into role (Role_ID, Role) values(2,'Employee');

insert into role (Role_ID, Role) values(3,'Employee');

insert into role (Role_ID, Role) values(4,'Employee');

insert into role (Role_ID, Role) values(5,'Employee');



commit;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
