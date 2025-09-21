package org.example.ThirdHomework.Adapter;

import java.time.LocalDate;
import java.time.YearMonth;

// новая система учета времени (целевой интерфейс)
public interface ModernTimeTracking {
    void logWorkHours(String employeeId, int hours, LocalDate date);
    int getWorkedHours(String employeeId, YearMonth period);
}
