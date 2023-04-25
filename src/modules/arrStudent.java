package modules;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class arrStudent implements Serializable{
  private ArrayList<Student> arrSt = new ArrayList<Student>();

  public void addStudent(Student st) {
    this.arrSt.add(st);
  }

  public void setVl (int row,int col,String value) {
    if (col == 0) {
      this.arrSt.get(row).setMaSV(value);
    } else if (col == 1) {
      this.arrSt.get(row).setHoTen(value);
    } else if (col == 2) {
      this.arrSt.get(row).setSoDienThoai(value);
    } else if (col == 3) {
      this.arrSt.get(row).setQueQuan(value);
    }
  }
  public void saveLocal() {
    try {
      FileOutputStream fos = new FileOutputStream("student.bin");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      System.out.println(this.arrSt);
      oos.writeObject(this);
      oos.close();
      fos.close();
      System.out.println("done");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public arrStudent readObject() {
    try {
      FileInputStream fis = new FileInputStream("student.bin");
      ObjectInputStream ois = new ObjectInputStream(fis);
      arrStudent studentFromFile = (arrStudent) ois.readObject();
      ois.close();
      fis.close();
      this.arrSt = studentFromFile.getArrSt();
      return studentFromFile;
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }


  @Override
  public String toString() {
    return "arrStudent [arrSt=" + arrSt + "]";
  }

  public ArrayList<Student> getArrSt() {
    return arrSt;
  }

  public void setArrSt(ArrayList<Student> arrSt) {
    this.arrSt = arrSt;
  }

}
