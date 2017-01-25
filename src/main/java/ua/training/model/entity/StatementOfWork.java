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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatementOfWork that = (StatementOfWork) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (filingDate != null ? !filingDate.equals(that.filingDate) : that.filingDate != null) return false;
        if (tasks != null ? !tasks.equals(that.tasks) : that.tasks != null) return false;
        if (!customerId.equals(that.customerId)) return false;
        return isApproved.equals(that.isApproved);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (filingDate != null ? filingDate.hashCode() : 0);
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        result = 31 * result + customerId.hashCode();
        result = 31 * result + isApproved.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StatementOfWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", filingDate=" + filingDate +
                ", tasks=" + tasks +
                ", customerId=" + customerId +
                ", isApproved=" + isApproved +
                '}';
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
