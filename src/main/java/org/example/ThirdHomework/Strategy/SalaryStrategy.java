package org.example.ThirdHomework.Strategy;

import org.example.ThirdHomework.Employee;

// интерфейс стратегии расчета зарплаты
public interface SalaryStrategy {
    double calculateSalary(Employee employee);
}
