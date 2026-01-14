DELIMITER $$

CREATE PROCEDURE GetBudgetUtilization()
BEGIN
    SELECT p.project_name,
           p.budget,
           SUM(e.salary * a.hours_allocated / 2080) AS salary_cost,
           p.budget - SUM(e.salary * a.hours_allocated / 2080) AS remaining,
           ROUND((SUM(e.salary * a.hours_allocated / 2080) / p.budget) * 100, 2) AS utilization_pct
    FROM projects p
    JOIN assignments a ON p.project_id = a.project_id
    JOIN employees e ON a.employee_id = e.employee_id
    GROUP BY p.project_id, p.project_name, p.budget;
END$$

DELIMITER ;

CALL GetBudgetUtilization();
