package org.example.info;
public class LongestProject {
    private int id;
    private int durationInMonths;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "id=" + id +
                ", durationInMonths=" + durationInMonths +
                '}';
    }
}