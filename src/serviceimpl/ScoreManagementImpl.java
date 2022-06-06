package serviceimpl;

import App.MainRun;
import entity.ScoreTable;
import entity.Student;
import entity.Subject;
import entity.SubjectScore;
import service.ScoreManagement;
import sun.applet.Main;
import util.file.FileUtil;

import java.util.Scanner;

public class ScoreManagementImpl implements ScoreManagement {



    public void addScoreTableAndShow(){

        if(!checkData()){
            System.out.println("Chưa có dữ liệu sinh viên hoặc môn học!!");
            return;
        }
        System.out.print("Nhập mã sinh viên muốn thêm: ");
        int studentID;
        do {
            try {

                studentID = Integer.parseInt(new Scanner(System.in).next());
                if (searchStudentByID(studentID) != null)
                    break;
                System.out.print("Mã sinh viên không tồn tại vui lòng nhập lại: ");
            }catch (NumberFormatException e){
                System.out.print("Mã sinh viên phải là số vui lòng nhập lại: ");
            }
        }while (true);
        int n;
        System.out.print("Nhập số lượng môn học muốn thêm: ");
        do{
            try {
                n = Integer.parseInt(new Scanner(System.in).next());
                if (n > 0)
                    break;
                System.out.print("Số lượng môn học phải là số nguyên dương vui lòng nhập lại: ");
            }catch (NumberFormatException e){
                System.out.print("Số lượng môn học phải là số nguyên dương vui lòng nhập lại: ");
            }
        }while (true);
        SubjectScore[] subjectScores=new SubjectScore[n];
        for(int i=0;i<n;i++) {
            System.out.print("Nhập mã môn học thứ " + (i + 1) + " : ");
            int subjectID;
            do {
                try {

                    subjectID = Integer.parseInt(new Scanner(System.in).next());
                    if (searchSubjectByID(subjectID) != null && checkSameSubject(subjectScores, subjectID))
                        break;
                    System.out.print("Mã môn học không tồn tại hoặc bị trùng vui lòng nhập lại: ");
                } catch (NumberFormatException e) {
                    System.out.print("Mã môn phải là số nguyên dương vui lòng nhập lại: ");
                }
            } while (true);

            float score;
            System.out.print("Nhập điểm số của môn học thứ " + (i + 1) + " : ");
            do {
                try {
                    score = Float.parseFloat(new Scanner(System.in).next());
                    if (score >= 0&&score<=10)
                        break;
                    System.out.print("Điểm số phải >=0 vui lòng nhập lại: ");
                } catch (NumberFormatException e) {
                    System.out.print("Điểm số phải là 1 số vui lòng nhập lại: ");
                }
            }while (true);
            SubjectScore g=new SubjectScore();
            g.setSubject(searchSubjectByID(subjectID));
            g.setScore(score);
            subjectScores[i]=g;

        }
        for(int i=0;i<MainRun.scoreTables.length;i++) {
            if (MainRun.scoreTables[i] == null) {
                ScoreTable st=new ScoreTable(searchStudentByID(studentID),subjectScores);
                MainRun.scoreTables[i]=st;
                break;
            }
        }
        FileUtil fileUtil = new FileUtil();
        fileUtil.writeDataToFile(MainRun.scoreTables,MainRun.scoreTablesFile);

        for(int i=0;i<MainRun.scoreTables.length;i++){
            if(MainRun.scoreTables[i]!=null)
                System.out.println(MainRun.scoreTables[i]);
        }
    }
    // check data
    private boolean checkData(){
        boolean checkStudent=false;
        boolean checkSubject=false;
        for(int i=0;i< MainRun.students.length;i++){
            if(MainRun.students[i]!=null){
                checkStudent=true;
                break;
            }
        }
        for(int i=0;i<MainRun.subjects.length;i++){
            if(MainRun.subjects[i]!=null){
                checkSubject=true;
                break;
            }
        }
        return checkStudent&&checkSubject;
    }
    // search student by id
    private Student searchStudentByID(int id){
        for(int i = 0; i< MainRun.students.length; i++){
            if(MainRun.students[i]!=null){
                if(MainRun.students[i].getMaSV()==id)
                    return MainRun.students[i];
            }
        }
        return null;
    }
    // search subject by id
    private Subject searchSubjectByID(int id){
        for(int i=0;i<MainRun.subjects.length;i++){
            if(MainRun.subjects[i]!=null){
                if(MainRun.subjects[i].getMaMh()==id)
                    return MainRun.subjects[i];
            }
        }
        return null;
    }
    // check same subject ( xem lại )
    private boolean checkSameSubject(SubjectScore[] subjectScores, int id){
        for(int i=0;i<subjectScores.length;i++){
            if(subjectScores[i]!=null) {
                if (subjectScores[i].getSubject().getMaMh() == id)
                    return false;
            }
        }
        return true;
    }
    @Override
    public void sortScoreTablesByName(){
        for(int i=0;i<MainRun.scoreTables.length-1;i++){
            ScoreTable sti=MainRun.scoreTables[i];
            if(sti!=null){
                for (int j=i+1;j<MainRun.scoreTables.length;j++){
                     ScoreTable stj=MainRun.scoreTables[j];
                    if(stj!=null){
                        if(sti.getStudent().getName().compareTo(stj.getStudent().getName())>0){
                            ScoreTable tmp=sti;
                            MainRun.scoreTables[i]=stj;
                            MainRun.scoreTables[j]=tmp;
                        }
                    }

                }
            }
            else {
                break;
            }
        }
        for( int i = 0; i<MainRun.scoreTables.length; i++){
            if(MainRun.scoreTables[i] !=null){
                System.out.println(MainRun.scoreTables[i]);
            }else{
                break;
            }
        }
    }

    @Override
    public void sortScoreTablesBySubjectName() {

    }

    @Override
    public  void calculateGPA(){
        for(int i=0;i<MainRun.scoreTables.length;i++){
            if(MainRun.scoreTables[i]!=null){
                float gpa=0;
                int credit=0;
                for(int j=0;j<MainRun.scoreTables[i].getSubjectScores().length;j++){
                    credit+=(MainRun.scoreTables[i].getSubjectScores()[j].getSubject().getDvHoctrinh());
                    gpa+=(MainRun.scoreTables[i].getSubjectScores()[j].getScore()*MainRun.scoreTables[i].getSubjectScores()[j].getSubject().getMaMh());

                }
                System.out.println("Sinh vien "+MainRun.scoreTables[i].getStudent().getName()+" có gpa là: "+((float)gpa/credit));
            }
        }
    }
}
