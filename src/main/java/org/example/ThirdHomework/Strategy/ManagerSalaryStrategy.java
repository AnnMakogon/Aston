package org.example.ThirdHomework.Strategy;

import org.example.ThirdHomework.Employee;

// стратегия для менеджеров
class ManagerSalaryStrategy implements SalaryStrategy {
    public double calculateSalary(Employee employee) {
        return employee.getBaseSalary() * 1.8 + employee.getTeamSize() * 300;
    }
}
