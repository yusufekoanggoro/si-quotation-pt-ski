CREATE TABLE `quotations_management`.`transactions` (
  `id` INT NOT NULL AUTO_INCREMENT, 
  `quote_number` VARCHAR(100) NOT NULL, 
  `Qty` INT NOT NULL, 
  `Total` INT NOT NULL, 
  `employee_id` INT NOT NULL, 
  `customer_id` INT NOT NULL, 
  `item_id` INT NOT NULL, 
  `status` VARCHAR(20) NOT NULL, 
  `custom_date` DATETIME NOT NULL, 
  `created_at` DATETIME NOT NULL, 
  `updated_at` DATETIME NOT NULL, 
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;
