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
    private Long bill;

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

    public Long getBill() {
        return bill;
    }

    public void setBill(Long bill) {
        this.bill = bill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (!id.equals(project.id)) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        if (statementOfWork != null ? !statementOfWork.equals(project.statementOfWork) : project.statementOfWork != null)
            return false;
        if (startDate != null ? !startDate.equals(project.startDate) : project.startDate != null) return false;
        if (endDate != null ? !endDate.equals(project.endDate) : project.endDate != null) return false;
        if (manager != null ? !manager.equals(project.manager) : project.manager != null) return false;
        return bill != null ? bill.equals(project.bill) : project.bill == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (statementOfWork != null ? statementOfWork.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (bill != null ? bill.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", statementOfWork=" + statementOfWork +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", manager=" + manager +
                ", bill=" + bill +
                '}';
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

        public Builder setBill(Long bill) {
            instance.bill = bill;
            return this;
        }

        public Project build() {
            return instance;
        }
    }
}
