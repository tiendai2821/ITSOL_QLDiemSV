package entity;

import java.io.Serializable;
import java.util.Arrays;

public class ScoreTable implements Serializable {
    private Student student;
    private SubjectScore[] subjectScores;

    public ScoreTable(Student student, SubjectScore[] subjectScores) {
        this.student = student;
        this.subjectScores = subjectScores;
    }

    @Override
    public String toString() {
        return "ScoreTable{" +
                "studentId=" + student.getMaSV() +
                ", subjectScores=" + Arrays.toString(subjectScores) +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SubjectScore[] getSubjectScores() {
        return subjectScores;
    }

    public void setSubjectScores(SubjectScore[] subjectScores) {
        this.subjectScores = subjectScores;
    }
}
