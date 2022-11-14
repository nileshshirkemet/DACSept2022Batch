DROP DATABASE IF EXISTS shop;
CREATE DATABASE shop;
USE shop;

CREATE TABLE `Counters` (
  `Id` varchar(8) NOT NULL,
  `SeedValue` int NOT NULL,
  `CurrentValue` int NOT NULL,
  PRIMARY KEY (`Id`)
);
INSERT INTO `Counters` VALUES ('order', 3000, 4),('product', 300, 4);

CREATE TABLE `CustomerInfo` (
  `UserName` varchar(16) NOT NULL,
  `Password` varchar(16) NOT NULL,
  `Address` varchar(128),
  `Credit` double DEFAULT NULL,
  PRIMARY KEY (`UserName`)
);
INSERT INTO `CustomerInfo` VALUES ('CU301','PWD301','Mumbai 400099',1000),('CU302','PWD302','Delhi 110047',2000),('CU303','PWD303','Chennai 600027',3000);

CREATE TABLE `ProductInfo` (
  `ProductNo` int NOT NULL,
  `Price` double NOT NULL,
  `Stock` int NOT NULL,
  PRIMARY KEY (`ProductNo`),
  CONSTRAINT `ProductInfo_Stock_chk` CHECK ((`Stock` >= 0))
);
INSERT INTO `ProductInfo` VALUES (301,550.65,95),(302,827.45,75),(303,243.15,65),(304,685.35,55);

CREATE TABLE `OrderDetail` (
  `OrderNo` int NOT NULL,
  `OrderDate` date NOT NULL,
  `CustomerId` varchar(16) NOT  NULL,
  `ProductNo` int NOT NULL,
  `Quantity` int NOT NULL,
  PRIMARY KEY (`OrderNo`),
  CONSTRAINT `OrderDetail_CustomerInfo_fk` FOREIGN KEY (`CustomerId`) REFERENCES `CustomerInfo` (`UserName`),
  CONSTRAINT `OrderDetail_ProductInfo_fk` FOREIGN KEY (`ProductNo`) REFERENCES `ProductInfo` (`ProductNo`),
  CONSTRAINT `OrderDetail_Quantity_chk` CHECK ((`Quantity` > 0))
);
INSERT INTO `OrderDetail` VALUES (3001,'2020-01-12','CU301',302,5),(3002,'2020-01-12','CU302',303,8),(3003,'2020-01-12','CU303',301,3),(3004,'2020-04-15','CU301',304,3);

DELIMITER $$
CREATE PROCEDURE PlaceOrder(IN Customer varchar(16), IN Product int, IN Quantity int, OUT OrderId int)
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		ROLLBACK;
		RESIGNAL;
	END;
	START TRANSACTION;
	UPDATE Counters SET CurrentValue=CurrentValue+1 WHERE Id='order';
	SELECT CurrentValue+SeedValue INTO OrderId FROM Counters WHERE Id='order';
	INSERT INTO OrderDetail VALUES(OrderId, SYSDATE(), Customer, Product, Quantity);
	COMMIT;
END$$
DELIMITER ;




