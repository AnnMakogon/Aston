package org.example.ThirdHomework.Decorator;

// конкретный декоратор - абонемент в спортзал
public class GymMembershipDecorator extends BenefitsDecorator {
    public GymMembershipDecorator(EmployeeBenefits benefits) {
        super(benefits);
    }

    public String getDescription() {
        return super.getDescription() + ", абонемент в спортзал";
    }

    public double getCost() {
        return super.getCost() + 100;
    }
}
