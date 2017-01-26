package ua.training.model.entity;

/**
 * Created by andrii on 25.01.17.
 */
public class TaskRequirements {
    private Integer taskId;
    private Qualification qualification;
    private Integer Qualification;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public ua.training.model.entity.Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Integer qualification) {
        Qualification = qualification;
    }

    public void setQualification(ua.training.model.entity.Qualification qualification) {
        this.qualification = qualification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskRequirements that = (TaskRequirements) o;

        if (taskId != null ? !taskId.equals(that.taskId) : that.taskId != null) return false;
        if (qualification != that.qualification) return false;
        return Qualification != null ? Qualification.equals(that.Qualification) : that.Qualification == null;
    }

    @Override
    public int hashCode() {
        int result = taskId != null ? taskId.hashCode() : 0;
        result = 31 * result + (qualification != null ? qualification.hashCode() : 0);
        result = 31 * result + (Qualification != null ? Qualification.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaskRequirements{" +
                "taskId=" + taskId +
                ", qualification=" + qualification +
                ", Qualification=" + Qualification +
                '}';
    }
}
