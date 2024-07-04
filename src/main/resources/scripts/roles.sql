CREATE TABLE `quotations_management`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT, 
  `name` VARCHAR(255) NOT NULL, 
  `periode` VARCHAR(255) NOT NULL,
  `created_at` DATETIME NOT NULL, 
  `updated_at` DATETIME NOT NULL, 
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

INSERT INTO `roles` (
  `id`, `name`, `periode`, `created_at`, 
  `updated_at`
) 
VALUES 
  (
    1, 'ADMINISTRASI', '1 Tahun', 
    '2023-05-14 19:17:27', '2023-05-14 19:17:27'
  ), 
  (
    2, 'ACCOUNTING', '1 Tahun', '2023-05-14 19:17:27', 
    '2023-05-14 19:17:27'
  ), 
  (
    3, 'SALES SUPPORT', '1 Tahun', '2023-05-14 19:17:27', 
    '2023-05-14 19:17:27'
  );
