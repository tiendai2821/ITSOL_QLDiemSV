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
        System.out.println(scoreTables[0]);
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
                    scoreManagement.s
                    break;
                case 5:
                    //
                    break;
                case 6:
                    //
                    break;
                case 7:
                    System.out.println("Tks for use our system");
                    return;
            }
        }
    }
    private static int function(){
        System.out.println("\n\nHỆ THỐNG QUẢN LÝ ĐIỂM CHO SINH VIÊN \n\n");
        System.out.println("1. Nhập danh sách sinh viên mới và in ra danh sách sinh viên.");
        System.out.println("2. In ra danh sách mô học mới và in ra danh sách môn học.");
        System.out.println("3. Nhập điểm cho sinh viên trong hệ thống.");
        System.out.println("4. Sắp xếp danh sách bảng điểm theo họ tên sinh viên.");
        System.out.println("5. Sắp xếp danh sách bảng điểm theo tên môn học");
        System.out.println("6. Tính tổng điểm chung cho mỗi sinh viên.");
        System.out.println("7. Thoát hệ thống.");

        System.out.println("--------------------------------------");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");
        int function = -1;
        do{
            function = new Scanner(System.in).nextInt();
            if(function<=7&& function>=1){
                break;
            }
            System.out.println("Lựa chọn từ 1 đến 9, mời nhập lại: ");
        }while(true);
        return function;
    }
}
