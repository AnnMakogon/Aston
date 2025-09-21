package org.example.ThirdHomework.Proxy;

import org.example.ThirdHomework.Employee;

public interface EmployeeDatabase {
    Employee getEmployeeById(int id);
    void updateEmployee(Employee employee);
}