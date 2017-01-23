package ua.training.model.entity;

import java.time.LocalDate;

/**
 * Created by andrii on 12.01.17.
 */
public class Project {
    private Integer id;
    private String name;
    private Integer statementOfWorkId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer managerId;
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

    public Integer getStatementOfWorkId() {
        return statementOfWorkId;
    }

    public void setStatementOfWorkId(Integer statementOfWorkId) {
        this.statementOfWorkId = statementOfWorkId;
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

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
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

        public Builder setStatementOfWorkId(Integer statementOfWorkId) {
            instance.statementOfWorkId = statementOfWorkId;
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

        public Builder setManagerId(Integer managerId) {
            instance.managerId = managerId;
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
