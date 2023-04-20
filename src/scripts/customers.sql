CREATE TABLE `quotations_management`.`customers` (
  `id` INT NOT NULL AUTO_INCREMENT, 
  `name` INT(100) NOT NULL, 
  `segment_id` VARCHAR(20) NOT NULL,
  `person_in_charge` VARCHAR(50) NOT NULL, 
  `phone_number` VARCHAR(15) NOT NULL, 
  `created_at` DATETIME NOT NULL, 
  `updated_at` DATETIME NOT NULL, 
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;
