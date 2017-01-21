package ua.training.model.entity;

/**
 * Created by andrii on 18.01.17.
 */
public class DeveloperHasTask {
    Developer developer;
    Task task;
    Project project;
    Integer elapsedTime;

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public static class Builder {
        DeveloperHasTask instance = new DeveloperHasTask();

        public Builder setDeveloper(Developer developer) {
            instance.developer = developer;
            return this;
        }

        public Builder setTask(Task task) {
            instance.task = task;
            return this;
        }

        public Builder setProject(Project project) {
            instance.project = project;
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
