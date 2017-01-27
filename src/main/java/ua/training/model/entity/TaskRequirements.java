package ua.training.model.entity;

/**
 * Created by andrii on 25.01.17.
 */
public class TaskRequirements {
    private Integer taskId;
    private Qualification qualification;
    private Integer developersNumber;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getDevelopersNumber() {
        return developersNumber;
    }

    public void setDevelopersNumber(Integer developersNumber) {
        this.developersNumber = developersNumber;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskRequirements that = (TaskRequirements) o;

        if (taskId != null ? !taskId.equals(that.taskId) : that.taskId != null) return false;
        if (qualification != that.qualification) return false;
        return developersNumber != null ? developersNumber.equals(that.developersNumber) : that.developersNumber == null;
    }

    @Override
    public int hashCode() {
        int result = taskId != null ? taskId.hashCode() : 0;
        result = 31 * result + (qualification != null ? qualification.hashCode() : 0);
        result = 31 * result + (developersNumber != null ? developersNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaskRequirements{" +
                "taskId=" + taskId +
                ", qualification=" + qualification +
                ", developersNumber=" + developersNumber +
                '}';
    }

    public static class Builder{
        TaskRequirements instance = new TaskRequirements();

        public Builder setTaskId(Integer taskId) {
            instance.taskId = taskId;
            return this;
        }

        public Builder setQualification(Qualification qualification) {
            instance.qualification = qualification;
            return this;
        }

        public Builder setDevelopersNumber(Integer developersNumber) {
            instance.developersNumber = developersNumber;
            return this;
        }

        public TaskRequirements build() {
            return instance;
        }
    }
}
