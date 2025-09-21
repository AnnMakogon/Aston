package org.example.ThirdHomework.Adapter;

// старая система учета рабочего времени (адаптируемый класс)
public class LegacyTimeTrackingSystem {
    public void recordTime(String employeeId, int hours, String date) {
        System.out.println("Записано в старую систему: " + hours + " часов для " + employeeId + " на " + date);
    }

    public int getMonthlyHours(String employeeId, String month) {
        System.out.println("Получение часов из старой системы для " + employeeId);
        return 160; // заглушка
    }
}
