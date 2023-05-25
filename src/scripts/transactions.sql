CREATE TABLE `quotations_management`.`transactions` (
  `id` INT NOT NULL AUTO_INCREMENT, 
  `Qty` INT NOT NULL, 
  `Total` INT NOT NULL, 
  `customer_id` INT NOT NULL, 
  `item_id` INT NOT NULL, 
  `status` VARCHAR(20) NOT NULL, 
  `created_at` DATETIME NOT NULL, 
  `updated_at` DATETIME NOT NULL, 
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;
