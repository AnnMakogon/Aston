package org.example.ThirdHomework;

import lombok.extern.slf4j.Slf4j;
import org.example.Executor;
import org.example.ThirdHomework.Adapter.LegacyTimeTrackingSystem;
import org.example.ThirdHomework.Adapter.ModernTimeTracking;
import org.example.ThirdHomework.Adapter.TimeTrackingAdapter;
import org.example.ThirdHomework.Builder.ITProject;
import org.example.ThirdHomework.ChainOfResponsibility.*;
import org.example.ThirdHomework.Decorator.BasicBenefits;
import org.example.ThirdHomework.Decorator.EmployeeBenefits;
import org.example.ThirdHomework.Decorator.GymMembershipDecorator;
import org.example.ThirdHomework.Decorator.TrainingDecorator;
import org.example.ThirdHomework.Proxy.EmployeeDatabase;
import org.example.ThirdHomework.Proxy.EmployeeDatabaseProxy;
import org.example.ThirdHomework.Strategy.DeveloperSalaryStrategy;
import org.example.ThirdHomework.Strategy.SalaryCalculator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service("thirdExecutorService")
public class ExecutorService implements Executor {

    @Override
    public void execution(){
        // стратегия - расчет зарплаты
        SalaryCalculator calculator = new SalaryCalculator();
        calculator.setStrategy(new DeveloperSalaryStrategy());
        Employee dev = new Employee(1L,"John", "Developer", 3000, 5, 10, 5);
        System.out.println("Зарплата: " + calculator.calculate(dev));

        // цепочка - процесс найма
        HiringHandler hiringProcess = new HRHandler();
        hiringProcess.setNext(new TechnicalHandler())
                .setNext(new ProjectManagerHandler());

        Candidate candidate = new Candidate(true, true, true, true);
        hiringProcess.handle(candidate);

        // билдер - создание проекта
        ITProject project = new ITProject.Builder()
                .setName("AI Platform")
                .setTeamSize(15)
                .build();

        // прокси - доступ к БД
        EmployeeDatabase db = new EmployeeDatabaseProxy("HR");
        Employee employee = db.getEmployeeById(123);

        // декоратор - плюшки
        EmployeeBenefits benefits = new BasicBenefits();
        benefits = new GymMembershipDecorator(benefits);
        benefits = new TrainingDecorator(benefits);
        System.out.println("Benefits: " + benefits.getDescription());

        // адаптер - интеграция систем
        ModernTimeTracking timeTracking = new TimeTrackingAdapter(new LegacyTimeTrackingSystem());
        timeTracking.logWorkHours("EMP123", 8, LocalDate.now());
    }
}
