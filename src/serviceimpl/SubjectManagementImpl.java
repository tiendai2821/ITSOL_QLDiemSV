package serviceimpl;

import App.MainRun;
import entity.Subject;
import service.SubjectManagement;
import sun.applet.Main;
import sun.rmi.server.Activation$ActivationSystemImpl_Stub;
import util.DataUtil;
import util.file.FileUtil;

import java.util.Scanner;

public class SubjectManagementImpl implements SubjectManagement {
    @Override
    public void addSubjectAndShow() {
        if(MainRun.subjects[0] == null){
            Subject.setMaMhLast(99);
        }else {
            Subject.setMaMhLast(getMaMhLastFromFile());
        }
        System.out.println("Nhập số môn học muốn thêm:");
        int n = new  Scanner(System.in).nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("Nhập thông tin cho môn học thứ "+(i+1));
            Subject subject = new Subject();
            subject.InputInfo();
            addSubjectToArr(subject);
        }
        FileUtil fileUtil = new FileUtil();
        fileUtil.writeDataToFile(MainRun.subjects,MainRun.subjectsFile);
        // show
        for(int i = 0; i<MainRun.subjects.length; i++){
            if(MainRun.subjects[i] != null){
                System.out.println(MainRun.subjects[i]);
            }
            else {
                break;
            }
        }
    }
    private int getMaMhLastFromFile(){
        for(int i = 0; i<MainRun.subjects.length; i++){
            if(MainRun.subjects[i]==null){
                return MainRun.subjects[i-1].getMaMh();
            }
        }
        return -1;
    }
    private void addSubjectToArr(Subject subject){
        for(int i = 0; i< MainRun.subjects.length; i++){
            if(MainRun.subjects[i] == null){
                MainRun.subjects[i] = subject;
                break;
            }
        }
    }
}
