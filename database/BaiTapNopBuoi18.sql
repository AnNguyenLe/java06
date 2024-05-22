-- 1. Hiển thị tất cả thông tin của bảng "employees"
SELECT *
FROM employees;

-- 2. Hiển thị tên và lương của tất cả nhân viên
SELECT employee_name, salary
FROM employees;

-- 3. Hiển thị thông tin của những nhân viên có lương lớn hơn 50000
SELECT *
FROM employees
WHERE salary > 50000;

-- 4. Hiển thị số lượng nhân viên trong mỗi phòng ban
SELECT d.department_id, d.department_name, COUNT(*) as total_employee
FROM employees e 
JOIN departments d ON e.department_id = d.department_id 
GROUP BY d.department_id;

-- 5. Sắp xếp danh sách nhân viên theo tên từ A-Z
SELECT employee_name 
FROM employees
ORDER BY employee_name;

-- 6. Hiển thị tên, lương và phòng ban của những nhân viên có lương từ 40000 đến 60000, sắp xếp theo lương giảm dần
SELECT e.employee_id, e.employee_name, e.salary, d.department_name
FROM employees e 
JOIN departments d ON e.department_id = d.department_id 
WHERE e.salary BETWEEN 40000 AND 60000
ORDER BY e.salary DESC;

-- 7. Tính tổng lương của tất cả nhân viên
SELECT SUM(salary) as total_salary
FROM employees;

-- 8. Hiển thị tên của nhân viên và tên phòng ban của họ
SELECT e.employee_id, e.employee_name, d.department_name
FROM employees e 
JOIN departments d ON e.department_id = d.department_id;

-- 9. Tìm những phòng ban có ít nhất 3 nhân viên
SELECT d.department_id, d.department_name, COUNT(*) as total_employees
FROM employees e 
JOIN departments d ON e.department_id = d.department_id 
GROUP BY d.department_id 
HAVING total_employees >= 3;

-- 10. Hiển thị tên nhân viên và lương của những nhân viên ở phòng ban "IT" hoặc "Sales"
SELECT e.employee_name, d.department_name, e.salary 
FROM employees e 
JOIN departments d ON e.department_id = d.department_id 
WHERE d.department_name IN ('IT', 'Sales');

-- 11. Hiển thị tên và ngày bắt đầu làm việc của những nhân viên được tuyển dụng sau năm 2020
SELECT employee_name, start_date 
FROM employees
WHERE YEAR(start_date) > 2020;

-- 12. Tính trung bình lương của nhân viên
SELECT AVG(salary) as avg_salary
FROM employees;

-- 13. Hiển thị danh sách các phòng ban và số lượng nhân viên trong mỗi phòng ban, kể cả những phòng ban không có nhân viên
SELECT d.department_id, d.department_name, COUNt(*) as total_employees
FROM departments d 
LEFT JOIN employees e ON d.department_id = e.department_id 
GROUP BY d.department_id;

-- 14. Hiển thị 5 nhân viên có lương cao nhất
SELECT employee_id, employee_name, salary 
FROM employees
ORDER BY salary DESC
LIMIT 5;

-- 15. Tìm những nhân viên có tên bắt đầu bằng chữ "A"
SELECT *
FROM employees
WHERE employee_name LIKE 'A%';

-- 16. Hiển thị tên nhân viên và tên quyền truy cập của những người có quyền là "Admin"
SELECT e.employee_id, e.employee_name, ar.access_level 
FROM employees e 
JOIN access_rights ar ON e.employee_id = ar.employee_id 
WHERE ar.access_level = 'Admin';

-- 17. Tính tổng lương cho mỗi phòng ban và sắp xếp theo tổng lương giảm dần
SELECT d.department_id, d.department_name, CASE WHEN SUM(e.salary) IS NULL THEN 0 ELSE SUM(e.salary) END AS total_salary
FROM departments d 
LEFT JOIN employees e ON e.department_id = d.department_id
GROUP BY d.department_id
ORDER BY total_salary DESC;

-- 18. Hiển thị danh sách nhân viên và ngày bắt đầu làm việc, sắp xếp theo ngày bắt đầu làm việc tăng dần
SELECT employee_id, employee_name, start_date 
FROM employees
ORDER BY start_date;

-- 19. Tìm những nhân viên có lương cao nhất trong từng phòng ban
SELECT e.employee_id, e.employee_name, t.department_id, t.department_name, e.salary
FROM (
	SELECT d.department_id, d.department_name, MAX(e.salary) as max_salary
	FROM departments d 
	LEFT JOIN employees e ON d.department_id = e.department_id
	GROUP BY d.department_id
) as t
JOIN employees e ON e.department_id = t.department_id
WHERE e.salary = t.max_salary;

-- 20.	Hiển thị danh sách nhân viên và tên quyền truy cập của họ, bao gồm những nhân viên không có quyền truy cập
SELECT e.employee_id, e.employee_name, CASE WHEN ar.access_level IS NULL THEN 'Unauthorized' ELSE ar.access_level END as access_level
FROM employees e 
LEFT JOIN access_rights ar ON e.employee_id = ar.employee_id;

