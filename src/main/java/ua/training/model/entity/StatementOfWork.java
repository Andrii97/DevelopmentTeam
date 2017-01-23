package ua.training.model.entity;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by andrii on 12.01.17.
 */
public class StatementOfWork {
    private Integer id;
    private String name;
    private LocalDate filingDate;
    private List<Task> tasks;
    private Integer customerId;
    private Boolean isApproved;

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

    public LocalDate getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(LocalDate filingDate) {
        this.filingDate = filingDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public static class Builder{
        StatementOfWork instance = new StatementOfWork();

        public Builder setId(Integer id) {
            instance.id = id;
            return this;
        }

        public Builder setName(String name) {
            instance.name = name;
            return this;
        }

        public Builder setFilingDate(LocalDate filingDate) {
            instance.filingDate = filingDate;
            return this;
        }

        public Builder setTasks(List<Task> tasks) {
            instance.tasks = tasks;
            return this;
        }

        public Builder setCustomerId(Integer customerId) {
            instance.customerId = customerId;
            return this;
        }

        public Builder setApproved(Boolean approved) {
            instance.isApproved = approved;
            return this;
        }

        public StatementOfWork build() {
            return instance;
        }
    }
}
