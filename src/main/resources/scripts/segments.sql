CREATE TABLE `quotations_management`.`segments` (
  `id` INT NOT NULL AUTO_INCREMENT, 
  `name` VARCHAR(100) NOT NULL, 
  `created_at` DATETIME NOT NULL, 
  `updated_at` DATETIME NOT NULL, 
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

INSERT INTO `segments` (
  `id`, `name`, `created_at`, 
  `updated_at`
) 
VALUES 
  (1, 'Pharmaceutical', '2023-05-21 19:17:27', '2023-05-21 03:48:27'), 
  (2, 'Foods & Beverages', '2023-05-21 19:17:27', '2023-05-21 03:48:27'), 
  (3, 'Automotive Parts Industry', '2023-05-21 19:17:27', '2023-05-21 03:48:27'),
  (4, 'Pulp & Paper', '2023-05-21 19:17:27', '2023-05-21 03:48:27'), 
  (5, 'Palm Oil Refinery', '2023-05-21 19:17:27', '2023-05-21 03:48:27'), 
  (6, 'Steel Manufacturer', '2023-05-21 19:17:27', '2023-05-21 03:48:27'),
  (7, 'Water process company', '2023-05-21 19:17:27', '2023-05-21 03:48:27'), 
  (8, 'MARINE/ Diesel', '2023-05-21 19:17:27', '2023-05-21 03:48:27'), 
  (9, 'Power Plants', '2023-05-21 19:17:27', '2023-05-21 03:48:27'),
  (10, 'Water Cooling', '2023-05-21 19:17:27', '2023-05-21 03:48:27'), 
  (11, 'Chemical ,Oil & Gas', '2023-05-21 19:17:27', '2023-05-21 03:48:27')
;