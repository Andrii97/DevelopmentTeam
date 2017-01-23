package ua.training.model.entity;

/**
 * Created by andrii on 18.01.17.
 */
public class DeveloperHasTask {
    Integer developerId;
    Integer taskId;
    Integer projectId;
    Integer elapsedTime;

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public static class Builder {
        DeveloperHasTask instance = new DeveloperHasTask();

        public Builder setDeveloperId(Integer developerId) {
            instance.developerId = developerId;
            return this;
        }

        public Builder setTaskId(Integer taskId) {
            instance.taskId = taskId;
            return this;
        }

        public Builder setProjectId(Integer projectId) {
            instance.projectId = projectId;
            return this;
        }

        public Builder setElapsedTime(Integer elapsedTime) {
            instance.elapsedTime = elapsedTime;
            return this;
        }

        public DeveloperHasTask build() {
            return instance;
        }
    }
}
