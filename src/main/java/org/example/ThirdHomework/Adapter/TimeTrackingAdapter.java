package org.example.ThirdHomework.Adapter;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

// адаптер
public class TimeTrackingAdapter implements ModernTimeTracking {
    private LegacyTimeTrackingSystem legacySystem;

    public TimeTrackingAdapter(LegacyTimeTrackingSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    public void logWorkHours(String employeeId, int hours, LocalDate date) {
        String oldFormatDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        legacySystem.recordTime(employeeId, hours, oldFormatDate);
    }

    public int getWorkedHours(String employeeId, YearMonth period) {
        String month = period.getMonthValue() + "-" + period.getYear();
        return legacySystem.getMonthlyHours(employeeId, month);
    }
}
