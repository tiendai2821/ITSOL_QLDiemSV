package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Student extends Person implements Serializable {
    private static int  maSVLast = 0;
    private String lop;
    private int maSV = 0;
    public Student() {
        maSVLast ++;
        this.maSV = maSVLast;
    }

    public static int getMaSVLast() {
        return maSVLast;
    }

    public static void setMaSVLast(int maSVLast) {
        Student.maSVLast = maSVLast;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public int getMaSV() {
        return maSV;
    }

    public void inputInfo(){
        System.out.println("Mời nhập tên SV: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Mời nhập địa chỉ cho SV: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Mời nhập số điện thoại cho SV: ");
        this.phonenum = new Scanner(System.in).nextLine();
        System.out.println("Mời nhập lớp cho sinh viên: ");
        this.lop = new Scanner(System.in).nextLine();
    }

    @Override
    public String toString() {
        return "Student{"+
                "id: "+maSV+
                " ,tên: " + name+
                " ,địa chỉ: "+ address+
                " ,sdt: " + phonenum+
                " ,lớp: "+ lop+"}"
                ;
    }
}
