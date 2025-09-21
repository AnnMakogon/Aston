package org.example.ThirdHomework.ChainOfResponsibility;

// обработчик - HR специалист
public class HRHandler extends HiringHandler {
    public void handle(Candidate candidate) {
        if (candidate.isHasResume() && candidate.isMeetsBasicRequirements()) {
            System.out.println("HR: Кандидат прошел первоначальный отбор");
            if (next != null) next.handle(candidate);
        } else {
            System.out.println("HR: Кандидат не прошел отбор");
        }
    }
}
