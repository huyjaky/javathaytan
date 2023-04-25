package modules;

import java.io.*;

public class Student implements Serializable{
  private String MaSV;
  private String HoTen;
  private String SoDienThoai;
  private String QueQuan;

  public Student(String MaSV, String HoTen, String SoDienThoai, String QueQuan) {
    this.MaSV = MaSV;
    this.HoTen = HoTen;
    this.SoDienThoai = SoDienThoai;
    this.QueQuan = QueQuan;
  }

  public String toString() {
    return "MaSV: " + this.MaSV + ", HoTen: " + this.HoTen + ", SoDienThoai: " + this.SoDienThoai + ", QueQuan: "
        + this.QueQuan;
  }

  public String getMaSV() {
    return MaSV;
  }

  public void setMaSV(String maSV) {
    MaSV = maSV;
  }

  public String getHoTen() {
    return HoTen;
  }

  public void setHoTen(String hoTen) {
    HoTen = hoTen;
  }

  public String getSoDienThoai() {
    return SoDienThoai;
  }

  public void setSoDienThoai(String soDienThoai) {
    SoDienThoai = soDienThoai;
  }

  public String getQueQuan() {
    return QueQuan;
  }

  public void setQueQuan(String queQuan) {
    QueQuan = queQuan;
  }
}
