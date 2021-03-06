package App;
import entity.ScoreTable;
import entity.Student;
import entity.Subject;
import service.ScoreManagement;
import service.StudentManagement;
import service.SubjectManagement;
import serviceimpl.ScoreManagementImpl;
import serviceimpl.StudentManagementImpl;
import serviceimpl.SubjectManagementImpl;
import util.DataUtil;
import util.file.FileUtil;

import java.util.Scanner;

public class MainRun {
    public static StudentManagement studentMangement = new StudentManagementImpl();
    public static SubjectManagement subjectManagement = new SubjectManagementImpl();
    public static ScoreManagement scoreManagement = new ScoreManagementImpl();
    public static String studentsFile = "students.dat";
    public static String subjectsFile = "subjects.dat";
    public static String scoreTablesFile = "scoreTables.dat";
    public static Student[] students;
    public static Subject[] subjects;
    public static ScoreTable[] scoreTables;
    public static void main(String[] args) {
        initData();
        Menu();
    }
    private static void initData(){

        Object studentsFromFile = new FileUtil().readDataFromFile(MainRun.studentsFile);
        MainRun.students = DataUtil.isNullOrEmpty(studentsFromFile)?new Student[1000]:(Student[]) studentsFromFile;
        Object subjectsFromFile = new FileUtil().readDataFromFile(MainRun.subjectsFile);
        MainRun.subjects = DataUtil.isNullOrEmpty(subjectsFromFile)? new Subject[1000]:(Subject[]) subjectsFromFile;
        Object scoreTablesFromFile = new FileUtil().readDataFromFile(MainRun.scoreTablesFile);
        MainRun.scoreTables = DataUtil.isNullOrEmpty(scoreTablesFromFile)? new ScoreTable[1000]:(ScoreTable[]) scoreTablesFromFile;
        System.out.println(scoreTables.length);
    }
    private static void Menu(){
        while(true){
            int function = function();
            switch (function){
                case 1:
                    studentMangement.addStudentAndShow();
                    break;
                case 2:
                    subjectManagement.addSubjectAndShow();
                    break;
                case 3:
                    scoreManagement.addScoreTableAndShow();
                    break;
                case 4:
                    scoreManagement.sortScoreTablesByName();
                    break;
                case 5:
                    scoreManagement.sortScoreTablesBySubjectName();
                    break;
                case 6:
                    scoreManagement.calculateGPA();
                    break;
                case 7:
                    System.out.println("Tks for use our system");
                    return;
            }
        }
    }
    private static int function(){
        System.out.println("\n\nH??? TH???NG QU???N L?? ??I???M CHO SINH VI??N \n\n");
        System.out.println("1. Nh???p danh s??ch sinh vi??n m???i v?? in ra danh s??ch sinh vi??n.");
        System.out.println("2. Nh???p danh s??ch m?? h???c m???i v?? in ra danh s??ch m??n h???c.");
        System.out.println("3. Nh???p ??i???m cho sinh vi??n trong h??? th???ng.");
        System.out.println("4. S???p x???p danh s??ch b???ng ??i???m theo h??? t??n sinh vi??n.");
        System.out.println("5. S???p x???p danh s??ch b???ng ??i???m theo t??n m??n h???c");
        System.out.println("6. T??nh t???ng ??i???m chung cho m???i sinh vi??n.");
        System.out.println("7. Tho??t h??? th???ng.");

        System.out.println("--------------------------------------");
        System.out.print("Xin m???i nh???p l???a ch???n c???a b???n: ");
        int function = -1;
        do{
            function = new Scanner(System.in).nextInt();
            if(function<=7&& function>=1){
                break;
            }
            System.out.println("L???a ch???n t??? 1 ?????n 9, m???i nh???p l???i: ");
        }while(true);
        return function;
    }
}
