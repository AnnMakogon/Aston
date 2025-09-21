package org.example.ThirdHomework.Decorator;

// декоратор - дополнительные benefits
abstract class BenefitsDecorator implements EmployeeBenefits {
    protected EmployeeBenefits decoratedBenefits;

    public BenefitsDecorator(EmployeeBenefits benefits) {
        this.decoratedBenefits = benefits;
    }

    public String getDescription() {
        return decoratedBenefits.getDescription();
    }

    public double getCost() {
        return decoratedBenefits.getCost();
    }
}
