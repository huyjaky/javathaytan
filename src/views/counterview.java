package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

import modules.Student;
import modules.arrStudent;

public class counterview extends JFrame {
  private JTable table;
  private JScrollPane scrollPane;
  private JButton addButton;
  private JButton deleteButton;
  private JButton changeButton;
  private arrStudent studentList;

  public counterview() {
    arrStudent arr = new arrStudent();
    this.studentList = arr.readObject();

    // Tạo table và scroll pane để chứa table
    String[] columnNames = { "Mã SV", "Họ Tên", "Số điện thoại", "Quê quán" };

    Object[][] data = new Object[studentList.getArrSt().size()][4];
    for (int i = 0; i < studentList.getArrSt().size(); i++) {
      data[i][0] = studentList.getArrSt().get(i).getMaSV();
      data[i][1] = studentList.getArrSt().get(i).getHoTen();
      data[i][2] = studentList.getArrSt().get(i).getSoDienThoai();
      data[i][3] = studentList.getArrSt().get(i).getQueQuan();
    }
    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    table = new JTable();
    table.setModel(model);
    scrollPane = new JScrollPane(table);

    // Tạo các button để thêm và xoá sinh viên
    addButton = new JButton("Thêm");
    deleteButton = new JButton("Xoá");
    changeButton = new JButton("Luu");

    addButton.addActionListener(e -> {
      // Xử lý khi người dùng click nút thêm sinh viên
      model.addRow(new Object[] { "", "", "" });
      Student newST = new Student("", "", "", "");
      arr.addStudent(newST);
    });

    table.getModel().addTableModelListener(e -> {
      int row_ = e.getFirstRow();
      int col_ = e.getColumn();
      if (row_ == -1 || col_ == -1 ) return;
      System.out.println(row_);
      System.out.println(col_);
      System.out.println(table.getValueAt(row_, col_));
      String value = (String) table.getValueAt(row_, col_);
      arr.setVl(row_, col_, value);
    });

    deleteButton.addActionListener(e -> {
      // Xử lý khi người dùng click nút xoá sinh viên
      int row = table.getSelectedRow();
      arr.getArrSt().remove(row);
      System.out.println(arr.toString());
      model.removeRow(row);
    });
    changeButton.addActionListener(e -> {
      // Xử lý khi người dùng click nút thêm sinh viên
      arr.saveLocal();
    });


    // Thêm các thành phần vào frame
    this.getContentPane().add(scrollPane, BorderLayout.CENTER);
    JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
    buttonPanel.add(addButton);
    buttonPanel.add(deleteButton);
    buttonPanel.add(changeButton);
    this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

    // Cài đặt thuộc tính cho frame
    this.setTitle("Danh sách sinh viên");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 300);
    this.setVisible(true);
  }
}
