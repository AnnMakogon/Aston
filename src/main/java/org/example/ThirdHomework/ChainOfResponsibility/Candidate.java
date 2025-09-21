package org.example.ThirdHomework.ChainOfResponsibility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// сам кандидат
@Getter
@Setter
@AllArgsConstructor
public class Candidate {
    private boolean hasResume;
    private boolean meetsBasicRequirements;
    private boolean technicalInterviewPassed;
    private boolean managerInterviewPassed;
}
