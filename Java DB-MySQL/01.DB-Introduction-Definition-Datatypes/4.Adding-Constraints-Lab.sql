ALTER TABLE `categories` 
ADD CONSTRAINT `category_id`
  FOREIGN KEY (`id`)
  REFERENCES `products` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;