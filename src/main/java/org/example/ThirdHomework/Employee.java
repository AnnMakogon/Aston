package org.example.ThirdHomework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String position;
    private double baseSalary;
    private int experience;
    private int bugsFound;
    private int teamSize;
}
