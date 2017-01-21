package ua.training.model.entity;

import java.util.HashMap;

/**
 * Created by andrii on 12.01.17.
 */
public class Task {
    private Integer id;
    private String name;
    private String description;
    private StatementOfWork statementOfWork;
    private HashMap<Qualification, Integer> taskRequirements; // qualification / developersNumber
    private Boolean isFinished;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatementOfWork getStatementOfWork() {
        return statementOfWork;
    }

    public void setStatementOfWork(StatementOfWork statementOfWork) {
        this.statementOfWork = statementOfWork;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public HashMap<Qualification, Integer> getTaskRequirements() {
        return taskRequirements;
    }

    public void setTaskRequirements(HashMap<Qualification, Integer> taskRequirements) {
        this.taskRequirements = taskRequirements;
    }

    public static class Builder{
        Task instance = new Task();

        public Builder setId(int id) {
            instance.id = id;
            return this;
        }
        public Builder setName(String name) {
            instance.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            instance.description = description;
            return this;
        }

        public Builder setStatementOfWork(StatementOfWork statementOfWork) {
            instance.statementOfWork = statementOfWork;
            return this;
        }

        public Builder setFinished(Boolean finished) {
            instance.isFinished = finished;
            return this;
        }

        public Builder setTaskRequirements(HashMap<Qualification, Integer> taskRequirements) {
            instance.taskRequirements = taskRequirements;
            return this;
        }

        public Task build() {
            return instance;
        }
    }
}
