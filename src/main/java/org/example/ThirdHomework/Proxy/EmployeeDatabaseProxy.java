package org.example.ThirdHomework.Proxy;

import org.example.ThirdHomework.Employee;

// прокси для контроля доступа
public class EmployeeDatabaseProxy implements EmployeeDatabase {
    private RealEmployeeDatabase realDatabase;
    private String userRole;

    public EmployeeDatabaseProxy(String userRole) {
        this.userRole = userRole;
    }

    public Employee getEmployeeById(int id) {
        if (hasReadAccess()) {
            if (realDatabase == null) {
                realDatabase = new RealEmployeeDatabase();
            }
            return realDatabase.getEmployeeById(id);
        } else {
            throw new SecurityException("Доступ запрещен");
        }
    }

    public void updateEmployee(Employee employee) {
        if (hasWriteAccess()) {
            if (realDatabase == null) {
                realDatabase = new RealEmployeeDatabase();
            }
            realDatabase.updateEmployee(employee);
        } else {
            throw new SecurityException("Доступ на запись запрещен");
        }
    }

    private boolean hasReadAccess() {
        return "HR".equals(userRole) || "Manager".equals(userRole) || "Admin".equals(userRole);
    }

    private boolean hasWriteAccess() {
        return "HR".equals(userRole) || "Admin".equals(userRole);
    }
}
