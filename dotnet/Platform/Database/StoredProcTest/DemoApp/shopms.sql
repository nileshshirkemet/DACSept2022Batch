CREATE DATABASE Shop
GO

USE Shop
GO

CREATE TABLE CustomerInfo(
	UserName VARCHAR(16) NOT NULL,
	Password VARCHAR(16),
	Address VARCHAR(128),
	Credit DECIMAL NOT NULL,
	CONSTRAINT PK_CustomerInfo PRIMARY KEY (UserName)
);

INSERT INTO CustomerInfo VALUES('CU201', 'PW201', 'Mumbai 400099', 1000);
INSERT INTO CustomerInfo VALUES('CU202', 'PW202', 'Delhi 110047', 2000);
INSERT INTO CustomerInfo VALUES('CU203', 'PW203', 'Chennai 600027', 3000);
INSERT INTO CustomerInfo VALUES('CU204', 'PW204', 'Kolkata 700072', 4000);
GO

CREATE TABLE ProductInfo(
	ProductNo INT NOT NULL,
	Price DECIMAL NOT NULL,
	Stock INT NOT NULL,
	CONSTRAINT PK_ProductInfo PRIMARY KEY (ProductNo),
	CONSTRAINT CK_ProductInfo_Stock CHECK (Stock >= 0)
);

INSERT INTO ProductInfo VALUES(201, 350, 40);
INSERT INTO ProductInfo VALUES(202, 550, 60);
INSERT INTO ProductInfo VALUES(203, 750, 80);
INSERT INTO ProductInfo VALUES(204, 650, 50);
INSERT INTO ProductInfo VALUES(205, 450, 30);
GO

CREATE TABLE OrderDetail(
	OrderNo INT NOT NULL,
	OrderDate DATE NOT NULL,
	CustomerId VARCHAR(16) NOT NULL,
	ProductNo INT NOT NULL,
	Quantity INT NOT NULL,
	CONSTRAINT PK_OrderDetail PRIMARY KEY (OrderNo),
	CONSTRAINT FK_OrderDetail_CustomerInfo FOREIGN KEY (CustomerId) REFERENCES CustomerInfo (UserName),
	CONSTRAINT FK_OrderDetail_ProductInfo FOREIGN KEY (ProductNo) REFERENCES ProductInfo (ProductNo),
	CONSTRAINT CK_OrderDetail_Quantity CHECK (Quantity > 0)
);

INSERT INTO OrderDetail VALUES(2001, '2020-09-12', 'CU201', 203, 4);
INSERT INTO OrderDetail VALUES(2002, '2020-10-13', 'CU202', 204, 6);
INSERT INTO OrderDetail VALUES(2003, '2020-11-14', 'CU203', 205, 8);
INSERT INTO OrderDetail VALUES(2004, '2020-12-15', 'CU204', 201, 10);
INSERT INTO OrderDetail VALUES(2005, '2021-01-16', 'CU201',	201, 9);
INSERT INTO OrderDetail VALUES(2006, '2021-02-17', 'CU202', 202, 7);
INSERT INTO OrderDetail VALUES(2007, '2021-03-18', 'CU203', 203, 5);
INSERT INTO OrderDetail VALUES(2008, '2021-04-19', 'CU201', 205, 3);
GO

CREATE TABLE Counters(
	Id VARCHAR(8) PRIMARY KEY NOT NULL,
	SeedValue INT NOT NULL,
	CurrentValue INT NOT NULL);

INSERT INTO Counters VALUES('product', 200, 5);
INSERT INTO Counters VALUES('order', 2000, 8);
GO

CREATE PROCEDURE PlaceOrder(
	@Customer VARCHAR(16),
	@Product INT,
	@Quantity INT,
	@OrderId INT OUTPUT) AS
BEGIN
	BEGIN TRAN
	UPDATE Counters SET CurrentValue=CurrentValue+1 WHERE Id='order'
	SELECT @OrderId=CurrentValue+SeedValue FROM Counters WHERE Id='order'
	INSERT INTO OrderDetail VALUES(@OrderId, GetDate(), @Customer, @Product, @Quantity)
	IF @@error = 0 COMMIT TRAN
	ELSE
	BEGIN
		ROLLBACK TRAN
		SET @OrderId=0
	END
END

GO
