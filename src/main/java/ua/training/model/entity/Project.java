package ua.training.model.entity;

import java.time.LocalDate;

/**
 * Created by andrii on 12.01.17.
 */
public class Project {
    private Integer id;
    private String name;
    private StatementOfWork statementOfWork;
    private LocalDate startDate;
    private LocalDate endDate;
    private User manager;
    private Integer bill;

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

    public StatementOfWork getStatementOfWork() {
        return statementOfWork;
    }

    public void setStatementOfWork(StatementOfWork statementOfWork) {
        this.statementOfWork = statementOfWork;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Integer getBill() {
        return bill;
    }

    public void setBill(Integer bill) {
        this.bill = bill;
    }

    public static class Builder {
        Project instance = new Project();

        public Builder setId(Integer id) {
            instance.id = id;
            return this;
        }

        public Builder setName(String name) {
            instance.name = name;
            return this;
        }

        public Builder setStatementOfWork(StatementOfWork statementOfWork) {
            instance.statementOfWork = statementOfWork;
            return this;
        }

        public Builder setStartDate(LocalDate startDate) {
            instance.startDate = startDate;
            return this;
        }

        public Builder setEndDate(LocalDate endDate) {
            instance.endDate = endDate;
            return this;
        }

        public Builder setManager(User manager) {
            instance.manager = manager;
            return this;
        }

        public Builder setBill(Integer bill) {
            instance.bill = bill;
            return this;
        }

        public Project build() {
            return instance;
        }
    }
}
