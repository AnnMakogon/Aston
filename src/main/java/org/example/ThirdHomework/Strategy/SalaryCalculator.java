package org.example.ThirdHomework.Strategy;

import org.example.ThirdHomework.Employee;

// для контекста
public class SalaryCalculator {
    private SalaryStrategy strategy;

    public void setStrategy(SalaryStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(Employee employee) {
        return strategy.calculateSalary(employee);
    }
}
