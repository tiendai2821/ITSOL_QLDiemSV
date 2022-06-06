package entity;

import java.io.Serializable;
import java.util.Arrays;

public class ScoreTable implements Serializable {
    private Student student;
    private SubjectScore subjectScore;

    public ScoreTable(Student student, SubjectScore subjectScore) {
        this.student = student;
        this.subjectScore = subjectScore;
    }

    @Override
    public String toString() {
        return "ScoreTable{" +
                "studentId=" + student.getMaSV() +
                ", subjectScore=" + this.subjectScore +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SubjectScore getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScores(SubjectScore subjectScore) {
        this.subjectScore = subjectScore;
    }
}
