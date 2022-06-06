package serviceimpl;

import App.MainRun;
import entity.Student;
import service.StudentManagement;
import util.DataUtil;
import util.file.FileUtil;

import java.util.Scanner;

public class StudentManagementImpl implements StudentManagement {
//    public static Student[] students;

    @Override
    public void addStudentAndShow() {
        if(MainRun.students[0] == null){
            Student.setMaSVLast(9999);
        }else {
            Student.setMaSVLast(getMaSVLastInFile());
        }
        System.out.println("Nhập số lượng sinh viên muốn thêm mới:");
        int studentNumAdd = new Scanner(System.in).nextInt();
        for(int i = 0; i<studentNumAdd; i++){
            System.out.println("Nhập thông tin cho sinh viên thứ "+ i);
            Student student = new Student();
            student.inputInfo();
            // thêm student vào mảng
            addStudentToArr(student);
        }
        // lưu mảng
        FileUtil saveStudents = new FileUtil();
        saveStudents.writeDataToFile(MainRun.students,MainRun.studentsFile);
        // show mảng student
        for(int i = 0; i<=MainRun.students.length; i++){
            if(MainRun.students[i]!= null){
                System.out.println(MainRun.students[i]);
            }else {
                break;
            }
        }
    }



    private void addStudentToArr(Student student){
        for(int i = 0; i<MainRun.students.length; i++){
            if(DataUtil.isNullOrEmpty(MainRun.students[i])){
                MainRun.students[i] = student;
                break;
            }
        }
    }
    private int getMaSVLastInFile(){
        for(int i = 0; i< MainRun.students.length; i++){
            if(DataUtil.isNullOrEmpty(MainRun.students[i])){
                return MainRun.students[i-1].getMaSV();
            }
        }
        return -1;
    }


}
