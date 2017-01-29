package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrii on 12.01.17.
 */
public class Task {
    private Integer id;
    private String name;
    private String description;
    private Integer statementOfWorkId;
    private List<TaskRequirements> taskRequirements; // qualification / developersNumber
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

    public Integer getStatementOfWorkId() {
        return statementOfWorkId;
    }

    public void setStatementOfWorkId(Integer statementOfWorkId) {
        this.statementOfWorkId = statementOfWorkId;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public List<TaskRequirements> getTaskRequirements() {
        return taskRequirements;
    }

    public void setTaskRequirements(List<TaskRequirements> taskRequirements) {
        this.taskRequirements = taskRequirements;
    }

    public void setTaskIdForTaskRequirements() {
        taskRequirements.forEach(requirements -> requirements.setTaskId(getId()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!id.equals(task.id)) return false;
        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (statementOfWorkId != null ? !statementOfWorkId.equals(task.statementOfWorkId) : task.statementOfWorkId != null)
            return false;
        if (taskRequirements != null ? !taskRequirements.equals(task.taskRequirements) : task.taskRequirements != null)
            return false;
        return isFinished != null ? isFinished.equals(task.isFinished) : task.isFinished == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (statementOfWorkId != null ? statementOfWorkId.hashCode() : 0);
        result = 31 * result + (taskRequirements != null ? taskRequirements.hashCode() : 0);
        result = 31 * result + (isFinished != null ? isFinished.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", statementOfWorkId=" + statementOfWorkId +
                ", taskRequirements=" + taskRequirements +
                ", isFinished=" + isFinished +
                '}';
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

        public Builder setStatementOfWorkId(Integer statementOfWorkId) {
            instance.statementOfWorkId = statementOfWorkId;
            return this;
        }

        public Builder setFinished(Boolean finished) {
            instance.isFinished = finished;
            return this;
        }

        public Builder setTaskRequirements(List<TaskRequirements> taskRequirements) {
            if(taskRequirements == null) {
                taskRequirements = new ArrayList<>();
            }
            instance.taskRequirements = taskRequirements;
            return this;
        }

        public Task build() {
            return instance;
        }
    }
}
