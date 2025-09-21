package org.example.ThirdHomework.ChainOfResponsibility;

// обработчик - Технический специалист
public class TechnicalHandler extends HiringHandler {
    public void handle(Candidate candidate) {
        if (candidate.isTechnicalInterviewPassed()) {
            System.out.println("Технический специалист: Кандидат прошел техническое собеседование");
            if (next != null) next.handle(candidate);
        } else {
            System.out.println("Технический специалист: Кандидат не прошел техническое собеседование");
        }
    }
}
