package org.example.ThirdHomework.Decorator;

public class BasicBenefits implements EmployeeBenefits {
    public String getDescription() {
        return "Медицинская страховка, отпуск";
    }

    public double getCost() {
        return 1000;
    }
}
