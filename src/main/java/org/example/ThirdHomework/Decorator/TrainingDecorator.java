package org.example.ThirdHomework.Decorator;

// конкретный декоратор - занятия на повышение хард скилов
public class TrainingDecorator extends BenefitsDecorator {
    public TrainingDecorator(EmployeeBenefits benefits) {
        super(benefits);
    }

    public String getDescription() {
        return super.getDescription() + ", курсы повышения квалификации";
    }

    public double getCost() {
        return super.getCost() + 500;
    }
}