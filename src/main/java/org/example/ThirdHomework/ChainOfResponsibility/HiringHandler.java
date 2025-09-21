package org.example.ThirdHomework.ChainOfResponsibility;

// самый базовый обработчик
public abstract class HiringHandler {
    protected HiringHandler next;

    public HiringHandler setNext(HiringHandler next) {
        this.next = next;
        return next;
    }

    public abstract void handle(Candidate candidate);
}
