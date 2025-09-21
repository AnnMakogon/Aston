package org.example.ThirdHomework.ChainOfResponsibility;

// обработчик - Менеджер проекта
public class ProjectManagerHandler extends HiringHandler {
    public void handle(Candidate candidate) {
        if (candidate.isManagerInterviewPassed()) {
            System.out.println("Менеджер проекта: Кандидат принят на работу!");
        } else {
            System.out.println("Менеджер проекта: Кандидат не подходит команде");
        }
    }
}
