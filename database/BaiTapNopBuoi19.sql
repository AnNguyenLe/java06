-- 1. Liệt kê tên nhân viên và tên phòng ban của họ
SELECT e.name, d.department_name 
FROM employees e
JOIN departments d ON e.department_id = d.department_id;

-- 2. Liệt kê tên nhân viên và tên dự án mà họ tham gia
SELECT e.name, p.project_name
FROM employees e 
JOIN employee_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON ep.project_id = p.project_id;

-- 3. Liệt kê tên phòng ban, tên dự án và tên nhân viên tham gia dự án đó.
SELECT d.department_name, p.project_name, e.name
FROM departments d 
JOIN projects p ON d.department_id = p.department_id
JOIN employee_projects ep ON ep.project_id = p.project_id 
JOIN employees e ON e.employee_id = ep.employee_id;

-- 4. Tính tổng lương của nhân viên tham gia từng dự án
SELECT  p.project_id, p.project_name, SUM(e.salary) 
FROM projects p 
JOIN employee_projects ep ON p.project_id = ep.employee_id 
JOIN employees e ON e.employee_id = ep.employee_id
GROUP BY p.project_id, p.project_name;

-- 5. Liệt kê tên nhân viên, tên quản lý của họ và tên dự án họ tham gia
SELECT e.name as employee_name, m.name as manager_name, p.project_name 
FROM employees e 
JOIN employees m ON e.employee_id = m.manager_id
JOIN employee_projects ep ON ep.employee_id = e.employee_id
JOIN projects p ON p.project_id = ep.project_id;

-- 6. Liệt kê tên phòng ban và số lượng nhân viên tham gia dự án của từng phòng ban
SELECT d.department_id, d.department_name, COUNT(*) as total_employees
FROM departments d
JOIN employees e ON d.department_id = e.department_id
GROUP BY d.department_id, d.department_name;

-- 7. Tìm tên nhân viên có lương cao nhất tham gia trong mỗi dự án
SELECT e.name, t.project_name, e.salary 
FROM employees e 
JOIN (
	SELECT p.project_id, p.project_name, MAX(e.salary) max_salary
	FROM projects p 
	JOIN employee_projects ep ON p.project_id = ep.project_id 
	JOIN employees e ON ep.employee_id = e.employee_id
	GROUP BY p.project_id, p.project_name
) as t
WHERE e.salary = t.max_salary;

-- 8. Liệt kê tên dự án và tổng số nhân viên tham gia, sắp xếp theo tổng số nhân viên giảm dần
SELECT p.project_name, p.project_id, COUNT(*) as total_employee 
FROM projects p 
JOIN employee_projects ep ON p.project_id = ep.project_id 
JOIN employees e ON ep.employee_id = e.employee_id
GROUP BY p.project_id, p.project_name
ORDER BY total_employee DESC;

-- 9. Tính lương trung bình của nhân viên trong từng phòng ban tham gia dự án
SELECT d.department_id, d.department_name, AVG(e.salary) as avg_salary
FROM projects p 
JOIN departments d ON p.department_id = p.department_id
JOIN employees e ON d.department_id = e.employee_id
GROUP BY d.department_id, d.department_name;

-- 10. Tìm tên nhân viên và dự án mà họ tham gia ít nhất một lần trong mỗi phòng ban
SELECT e.name, p.project_name, d.department_name 
FROM departments d 
JOIN projects p ON d.department_id = p.department_id
JOIN employee_projects ep ON p.project_id = ep.project_id 
JOIN employees e ON e.employee_id = ep.employee_id;

-- 11. Tìm tên nhân viên và số lượng dự án mà họ tham gia nhiều nhất
SELECT e.name, COUNT(*) as total_projects
FROM employees e 
JOIN employee_projects ep ON e.employee_id = ep.employee_id
GROUP BY e.employee_id;

-- 12.	Tìm tên phòng ban và số lượng dự án mà phòng ban đó quản lý nhiều nhất
SELECT d.department_name, COUNT(*) as total_projects
FROM projects p 
JOIN departments d ON p.department_id = d.department_id
GROUP BY d.department_id;

-- 13.	Tìm tên nhân viên có lương thấp nhất trong từng dự án
WITH project_min_salary AS(
	SELECT p.project_name, MIN(e.salary) as min_salary
	FROM employees e
	JOIN employee_projects ep ON e.employee_id = ep.employee_id
	JOIN projects p ON ep.project_id = p.project_id
	GROUP BY p.project_id
)

SELECT pms.project_name, e.name, pms.min_salary
FROM employees e 
CROSS JOIN project_min_salary pms
WHERE e.salary = pms.min_salary;

-- 14.	Liệt kê tên tất cả các dự án không có nhân viên tham gia
SELECT p.project_name
FROM projects p
LEFT JOIN employee_projects ep ON p.project_id = ep.project_id
WHERE ep.project_id IS NULL;

-- 15.	Tìm tên nhân viên có lương cao nhất và thấp nhất trong mỗi phòng ban
WITH dept_min_max_salary AS (
	SELECT d.department_id, MAX(e.salary) as max_salary, MIN(e.salary) as min_salary
	FROM departments d 
	JOIN employees e ON e.department_id = d.department_id
	GROUP BY d.department_id
)

SELECT 
	d.department_id, 
	d.department_name, 
	e.name, 
	e.salary, 
	CASE 
		WHEN e.salary = dmms.min_salary THEN 'Lowest salary' 
		WHEN e.salary = dmms.max_salary THEN 'Highest salary' 
	END AS salary_status
FROM dept_min_max_salary dmms  
JOIN departments d ON dmms.department_id = d.department_id
JOIN employees e ON e.department_id = d.department_id
WHERE e.salary IN (dmms.min_salary, dmms.max_salary);

-- 16.	Tính tổng lương và số lượng nhân viên cho từng dự án trong mỗi phòng ban
SELECT d.department_id, d.department_name, p.project_id, p.project_name, COUNT(*) as total_employee, SUM(e.salary) as total_salary
FROM departments d
LEFT JOIN projects p ON p.department_id = d.department_id
LEFT JOIN employee_projects ep ON p.project_id = ep.project_id 
LEFT JOIN employees e ON ep.employee_id = e.employee_id
GROUP BY d.department_id, p.project_id;


-- 17.	Tìm tên các nhân viên không tham gia bất kỳ dự án nào
SELECT e.employee_id, e.name
FROM employees e 
LEFT JOIN employee_projects ep ON e.employee_id = ep.employee_id 
LEFT JOIN projects p ON ep.project_id = p.project_id
WHERE p.project_id IS NULL;

-- 18.	Tính tổng số dự án mà mỗi phòng ban đang quản lý
SELECT d.department_id, d.department_name, COUNT(*) as total_projects 
FROM departments d
LEFT JOIN projects p ON p.department_id = d.department_id
GROUP BY d.department_id;

-- 19.	Tìm tên nhân viên và tên dự án mà nhân viên có lương cao nhất tham gia trong từng phòng ban
WITH max_salary_of_dept AS (
	SELECT e.department_id, MAX(e.salary) as max_salary
	FROM employees e 
	GROUP BY e.department_id
)

SELECT p.project_name, e.name, d.department_name
FROM employees e 
JOIN employee_projects ep ON e.employee_id = ep.employee_id 
JOIN projects p ON ep.project_id = p.project_id 
JOIN departments d ON e.department_id = d.department_id 
JOIN max_salary_of_dept msd ON msd.department_id = d.department_id 
WHERE e.salary = msd.max_salary
GROUP BY d.department_id, e.employee_id, p.project_id 
ORDER BY p.project_name;

-- 20.	Tính tổng lương của nhân viên trong mỗi phòng ban theo từng dự án mà không có nhân viên tham gia dự án
SELECT d.department_id, d.department_name, SUM(e.salary) as total_salary
FROM employees e 
LEFT JOIN employee_projects ep ON e.employee_id = ep.employee_id 
JOIN departments d ON e.department_id = d.department_id
WHERE ep.project_id IS NULL
GROUP BY d.department_id;
