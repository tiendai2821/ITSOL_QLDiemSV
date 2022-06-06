package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Subject implements Serializable {
    private static int  maMhLast;
    private int maMh;
    private String name;
    private int dvHoctrinh;
    private String loaiMon;
    private String daiCuong = "Đại cương";
    private String csNganh ="Cơ sở ngành";
    private String chuyenNganh = "Chuyên ngành";

    public Subject() {
        maMhLast ++;
        this.maMh = maMhLast;
    }

    public static int getMaMhLast() {
        return maMhLast;
    }

    public static void setMaMhLast(int maMhLast) {
        Subject.maMhLast = maMhLast;
    }

    public int getMaMh() {
        return maMh;
    }

    public void setMaMh(int maMh) {
        this.maMh = maMh;
    }
    public void InputInfo(){
        System.out.println("Mời nhập tên môn học: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Mời nhập số đơn vị học trình");
        this.dvHoctrinh = new Scanner(System.in).nextInt();
        System.out.println("Mời nhập loại môn học: ");
        System.out.println("1. Đại cương");
        System.out.println("2. Cơ sở ngành");
        System.out.println("3. Chuyên ngành");
        int n;
        do{
            n = new Scanner(System.in).nextInt();
            switch (n){
                case 1:
                    this.loaiMon = daiCuong;
                    break;
                case 2:
                    this.loaiMon = csNganh;
                    break;
                case 3:
                    this.loaiMon = chuyenNganh;
                    break;
            }
            if(n>=1 && n<=3) break;
            System.out.println("Chỉ nhập từ 1 đến 3, mời nhập lại:");
        }while (true);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDvHoctrinh() {
        return dvHoctrinh;
    }

    public void setDvHoctrinh(int dvHoctrinh) {
        this.dvHoctrinh = dvHoctrinh;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "Mã môn học=" + maMh +
                ", tên môn học='" + name + '\'' +
                ", số đvht=" + dvHoctrinh +
                ", loại môn='" + loaiMon + '\'' +
                '}';
    }
}
