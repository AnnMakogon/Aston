package org.example.ThirdHomework.Builder;

// создание IT проекта
public class ITProject {
    private String name;
    private String technologyStack;
    private int teamSize;
    private double budget;
    private int deadlineMonths;
    private String client;

    private ITProject(Builder builder) {
        this.name = builder.name;
        this.technologyStack = builder.technologyStack;
        this.teamSize = builder.teamSize;
        this.budget = builder.budget;
        this.deadlineMonths = builder.deadlineMonths;
        this.client = builder.client;
    }

    public static class Builder {
        private String name;
        private String technologyStack;
        private int teamSize;
        private double budget;
        private int deadlineMonths;
        private String client;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setTechnologyStack(String technologyStack) {
            this.technologyStack = technologyStack;
            return this;
        }

        public Builder setTeamSize(int teamSize) {
            this.teamSize = teamSize;
            return this;
        }

        public Builder setBudget(double budget) {
            this.budget = budget;
            return this;
        }

        public Builder setDeadlineMonths(int deadlineMonths) {
            this.deadlineMonths = deadlineMonths;
            return this;
        }

        public Builder setClient(String client) {
            this.client = client;
            return this;
        }

        public ITProject build() {
            return new ITProject(this);
        }
    }
}
