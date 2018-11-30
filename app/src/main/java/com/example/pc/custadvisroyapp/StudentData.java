package com.example.pc.custadvisroyapp;

public class StudentData {

    String RegNo,Name,Address;
    long Phone;
    int UG_Atmp,UG_Ernd,Curr_SCH,Prev_SCH;
    float U_GPA,U_CGPA;

    public StudentData(String regNo, String name, String address, long phone, int UG_Atmp, int UG_Ernd, int curr_SCH, int prev_SCH, float u_GPA, float u_CGPA) {
        RegNo = regNo;
        Name = name;
        Address = address;
        Phone = phone;
        this.UG_Atmp = UG_Atmp;
        this.UG_Ernd = UG_Ernd;
        Curr_SCH = curr_SCH;
        Prev_SCH = prev_SCH;
        U_GPA = u_GPA;
        U_CGPA = u_CGPA;
    }

    public void setRegNo(String regNo) {
        RegNo = regNo;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setPhone(long phone) {
        Phone = phone;
    }

    public void setUG_Atmp(int UG_Atmp) {
        this.UG_Atmp = UG_Atmp;
    }

    public void setUG_Ernd(int UG_Ernd) {
        this.UG_Ernd = UG_Ernd;
    }

    public void setCurr_SCH(int curr_SCH) {
        Curr_SCH = curr_SCH;
    }

    public void setPrev_SCH(int prev_SCH) {
        Prev_SCH = prev_SCH;
    }

    public void setU_GPA(float u_GPA) {
        U_GPA = u_GPA;
    }

    public void setU_CGPA(float u_CGPA) {
        U_CGPA = u_CGPA;
    }

    public String getRegNo() {
        return RegNo;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public long getPhone() {
        return Phone;
    }

    public int getUG_Atmp() {
        return UG_Atmp;
    }

    public int getUG_Ernd() {
        return UG_Ernd;
    }

    public int getCurr_SCH() {
        return Curr_SCH;
    }

    public int getPrev_SCH() {
        return Prev_SCH;
    }

    public float getU_GPA() {
        return U_GPA;
    }

    public float getU_CGPA() {
        return U_CGPA;
    }
}
