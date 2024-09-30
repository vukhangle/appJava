package qlnhansu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DisplayEmployee extends JFrame implements ActionListener {

    JComboBox<String> empIDComboBox;
    JTextArea displayArea;
    JButton displayButton;

    DisplayEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Hiển Thị Thông tin Nhân viên");
        heading.setBounds(250, 30, 400, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelEmpID = new JLabel("Chọn Mã Nhân viên: ");
        labelEmpID.setBounds(50, 100, 150, 30);
        labelEmpID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmpID);

        empIDComboBox = new JComboBox<>();
        empIDComboBox.setBounds(250, 100, 200, 30);
        add(empIDComboBox);

        displayButton = new JButton("Hiển Thị");
        displayButton.setBounds(500, 100, 150, 30);
        displayButton.addActionListener(this);
        add(displayButton);

        displayArea = new JTextArea();
        displayArea.setBounds(50, 150, 600, 300);
        add(displayArea);

        setSize(700, 500);
        setLocation(300, 200);
        setVisible(true);

        loadEmpIDs();
    }

    public void loadEmpIDs() {
        try {
            Conn conn = new Conn();
            String query = "SELECT empID FROM nhanvien";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                empIDComboBox.addItem(rs.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == displayButton) {
            String selectedEmpID = (String) empIDComboBox.getSelectedItem();
            displayEmployeeInfo(selectedEmpID);
        }
    }

    public void displayEmployeeInfo(String empID) {
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM nhanvien WHERE empID = '" + empID + "'";
            ResultSet rs = conn.s.executeQuery(query);
            StringBuilder info = new StringBuilder();
            while (rs.next()) {
                info.append("Mã Nhân viên: ").append(rs.getString("empID")).append("\n");
                info.append("Tên: ").append(rs.getString("name")).append("\n");
                info.append("Ngày Sinh: ").append(rs.getString("dob")).append("\n");
                info.append("Lương: ").append(rs.getString("salary")).append("\n");
                // Thêm các thông tin khác tương tự
                info.append("\n");
            }
            displayArea.setText(info.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DisplayEmployee();
    }
}
