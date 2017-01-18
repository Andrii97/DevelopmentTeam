package ua.training.model.entity;

/**
 * Created by andrii on 18.01.17.
 */
public class Developer {
    private User user;
    private Qualification qualification;
    private Boolean isFree;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }
}
