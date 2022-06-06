package entity;

import java.io.Serializable;

public class SubjectScore implements Serializable {
    private Subject subject;
    private float score;

    public SubjectScore() {
        this.subject = subject;
        this.score = score;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "|" +
                "Môn học="+subject.getMaMh() +"-" + subject.getName() +
                ", điểm=" + this.score +
                '|';
    }
}
