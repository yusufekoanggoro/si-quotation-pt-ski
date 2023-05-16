CREATE TABLE `quotations_management`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT, 
  `name` VARCHAR(255) NOT NULL, 
  `periode` VARCHAR(255) NOT NULL,
  `created_at` DATETIME NOT NULL, 
  `updated_at` DATETIME NOT NULL, 
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;
