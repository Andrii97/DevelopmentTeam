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
        if (statementOfWorkId != null ? !statementOfWorkId.equals(project.statementOfWorkId) : project.statementOfWorkId != null)
            return false;
        if (startDate != null ? !startDate.equals(project.startDate) : project.startDate != null) return false;
        if (endDate != null ? !endDate.equals(project.endDate) : project.endDate != null) return false;
        if (managerId != null ? !managerId.equals(project.managerId) : project.managerId != null) return false;
        return bill != null ? bill.equals(project.bill) : project.bill == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (statementOfWorkId != null ? statementOfWorkId.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        result = 31 * result + (bill != null ? bill.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", statementOfWorkId=" + statementOfWorkId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", managerId=" + managerId +
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

        public Builder setBill(Long bill) {
            instance.bill = bill;
            return this;
        }

        public Project build() {
            return instance;
        }
    }
}
