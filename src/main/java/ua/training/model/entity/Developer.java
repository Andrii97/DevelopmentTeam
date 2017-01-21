package ua.training.model.entity;

/**
 * Created by andrii on 18.01.17.
 */
public class Developer {
    private User user;
    private Qualification qualification;
    private Boolean isFree;

    public Developer(User user, Qualification qualification, Boolean isFree) {
        this.user = user;
        this.qualification = qualification;
        this.isFree = isFree;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developer)) return false;

        Developer developer = (Developer) o;

        if (!user.equals(developer.user)) return false;
        if (qualification != developer.qualification) return false;
        return isFree != null ? isFree.equals(developer.isFree) : developer.isFree == null;
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + qualification.hashCode();
        result = 31 * result + (isFree != null ? isFree.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "user=" + user +
                ", qualification=" + qualification +
                ", isFree=" + isFree +
                '}';
    }
}
