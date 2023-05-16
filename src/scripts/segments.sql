CREATE TABLE `quotations_management`.`segments` (
  `id` INT NOT NULL AUTO_INCREMENT, 
  `name` VARCHAR(100) NOT NULL, 
  `created_at` DATETIME NOT NULL, 
  `updated_at` DATETIME NOT NULL, 
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;
