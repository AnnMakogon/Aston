package org.example.ThirdHomework.Strategy;

import org.example.ThirdHomework.Employee;

// стратегия для тестировщиков
class QASalaryStrategy implements SalaryStrategy {
    public double calculateSalary(Employee employee) {
        return employee.getBaseSalary() * 1.3 + employee.getBugsFound() * 10;
    }
}
