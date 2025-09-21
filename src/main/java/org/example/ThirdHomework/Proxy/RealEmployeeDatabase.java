package org.example.ThirdHomework.Proxy;

import org.example.ThirdHomework.Employee;

// реальная база данных
class RealEmployeeDatabase implements EmployeeDatabase {
    public Employee getEmployeeById(int id) {
        System.out.println("Загрузка данных сотрудника ID: " + id + " из БД");
        // реальная логика доступа к БД
        return new Employee(); // заглушка
    }

    public void updateEmployee(Employee employee) {
        System.out.println("Обновление данных сотрудника в БД");
        // реальная логика обновления
    }
}