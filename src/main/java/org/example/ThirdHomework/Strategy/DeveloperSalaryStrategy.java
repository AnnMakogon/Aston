package org.example.ThirdHomework.Strategy;

import org.example.ThirdHomework.Employee;

// стратегия для разработчиков
public class DeveloperSalaryStrategy implements SalaryStrategy {
    public double calculateSalary(Employee employee) {
        return employee.getBaseSalary() * 1.5 + employee.getExperience() * 500;
    }
}
