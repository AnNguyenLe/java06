-- 1. Liệt kê tên sản phẩm và tên nhà cung cấp cho tất cả các sản phẩm có giá lớn hơn 15.00
SELECT p.ProductName, s.SupplierName
FROM Products p 
JOIN Suppliers s ON p.SupplierID = s.SupplierID
WHERE p.Price > 15;

-- 2. Tìm tất cả các đơn hàng được thực hiện bởi khách hàng ở "Mexico"
SELECT o.OrderID, c.CustomerName, c.ContactName, c.Country, o.OrderDate
FROM Orders o 
JOIN Customers c ON o.CustomerID = c.CustomerID 
WHERE c.Country = 'Mexico';

-- 3. Tìm số lượng đơn hàng được thực hiện trong mỗi quốc gia
SELECT c.Country , COUNT(*) as total_orders 
FROM Orders o 
JOIN Customers c ON o.CustomerID = c.CustomerID
GROUP BY c.Country;

-- 4. Liệt kê tất cả các nhà cung cấp và số lượng sản phẩm mà họ cung cấp
SELECT p.ProductName, s.SupplierName
FROM Suppliers s 
JOIN Products p ON s.SupplierID = p.SupplierID;

-- 5. Liệt kê tên sản phẩm và giá của các sản phẩm đắt hơn sản phẩm "Chang"
SELECT ProductName, Price 
FROM Products
WHERE Price > (
	SELECT Price 
	FROM Products
	WHERE ProductName = 'Chang'
);

-- 6. Tìm tổng số lượng sản phẩm bán ra trong tháng 5 năm 2024
SELECT SUM(od.Quantity) as total_quantity
FROM Orders o
JOIN OrderDetails od ON o.OrderID = od.OrderID 
WHERE EXTRACT(YEAR_MONTH FROM o.OrderDate) = 202405;

-- 7. Tìm tên của các khách hàng chưa từng đặt hàng
SELECT c.CustomerID, c.CustomerName
FROM Customers c 
LEFT JOIN Orders o ON c.CustomerID = o.CustomerID
WHERE o.OrderID IS NULL;

-- 8. Liệt kê các đơn hàng với tổng số tiền lớn hơn 200.00
SELECT od.OrderID, SUM(p.Price * od.Quantity) as total_price
FROM OrderDetails od
JOIN Products p ON p.ProductID = od.ProductID
GROUP BY od.OrderID
HAVING total_price > 200;

-- 9. Tìm tên sản phẩm và số lượng trung bình được đặt hàng cho mỗi đơn hàng
SELECT p.ProductID, p.ProductName, AVG(od.Quantity) as avg_quantity_per_order 
FROM OrderDetails od 
JOIN Products p ON od.ProductID = p.ProductID 
GROUP BY p.ProductID;

-- 10. Tìm khách hàng có tổng giá trị đơn hàng cao nhất
WITH customer_expenses AS (
	SELECT o.CustomerID, SUM(od.Quantity * p.Price) as total_expense
	FROM Orders o 
	JOIN OrderDetails od ON o.OrderID = od.OrderID 
	JOIN Products p ON od.ProductID = p.ProductID
	GROUP BY o.CustomerID
)

SELECT c.CustomerID, c.CustomerName, ce.total_expense
FROM Customers c 
JOIN customer_expenses ce ON c.CustomerID = ce.CustomerID
WHERE ce.total_expense = (
	SELECT MAX(total_expense)
	FROM customer_expenses
);

-- 11. Tìm các đơn hàng có tổng giá trị nằm trong top 10 cao nhất
SELECT od.OrderID, SUM(od.Quantity * p.Price) as total_price
FROM OrderDetails od 
JOIN Products p ON od.ProductID = p.ProductID 
GROUP BY od.OrderID
ORDER BY total_price DESC
LIMIT 10;

-- 12. Tìm tên khách hàng và số lượng đơn hàng của họ, chỉ bao gồm các khách hàng có số lượng đơn hàng lớn hơn mức trung bình
WITH total_orders_per_customer AS(
	SELECT COUNT(*) as total_orders
	FROM Orders o 
	JOIN Customers c ON o.CustomerID = c.CustomerID
	GROUP BY c.CustomerID
)

SELECT c.CustomerID, c.CustomerName, COUNT(*) as total_orders
FROM Customers c 
JOIN Orders o ON c.CustomerID = o.CustomerID 
GROUP BY c.CustomerID
HAVING total_orders > (
	SELECT AVG(total_orders)
	FROM total_orders_per_customer
);

-- 13. Tìm sản phẩm có giá trị đơn hàng trung bình cao nhất (dựa trên giá sản phẩm và số lượng).
WITH avg_order_cost AS(
	SELECT p.ProductID, AVG(p.Price * od.Quantity) as avg_cost
	FROM OrderDetails od 
	JOIN Products p ON od.ProductID = p.ProductID
	GROUP BY p.ProductID
)

SELECT p.ProductID, p.ProductName, aoc.avg_cost
FROM Products p 
JOIN avg_order_cost aoc ON p.ProductID = aoc.ProductID
WHERE aoc.avg_cost = (
	SELECT MAX(avg_cost)
	FROM avg_order_cost
);

-- 14. Liệt kê các sản phẩm chưa bao giờ được đặt hàng bởi khách hàng đến từ "USA"
SELECT ProductID, ProductName 
FROM Products
WHERE ProductID NOT IN (
	SELECT p.ProductID 
	FROM Products p 
	LEFT JOIN OrderDetails od ON p.ProductID = od.ProductID 
	LEFT JOIN Orders o ON od.OrderID = o.OrderID 
	LEFT JOIN Customers c ON o.CustomerID = c.CustomerID 
	GROUP BY c.Country, p.ProductID 
	HAVING c.Country = 'USA'
);

-- 15. Tìm nhà cung cấp có số lượng sản phẩm cung cấp nhiều nhất.
WITH suppliers_total_products AS (
	SELECT s.SupplierID, SUM(od.Quantity) as total_products
	FROM Suppliers s 
	JOIN Products p ON s.SupplierID = p.SupplierID
	JOIN OrderDetails od ON p.ProductID = od.ProductID 
	GROUP BY s.SupplierID
)

SELECT s.SupplierID, s.SupplierName, s.ContactName, stp.total_products
FROM Suppliers s
JOIN suppliers_total_products stp ON s.SupplierID = stp.SupplierID
WHERE total_products = (
	SELECT MAX(total_products)
	FROM suppliers_total_products
);
