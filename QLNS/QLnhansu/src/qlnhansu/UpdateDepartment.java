package qlnhansu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateDepartment extends JFrame implements ActionListener {

    JTextField tfdepartmentName, tfemployeeCount, tfaddress, tfphoneNumber, tfemail;
    JComboBox<String> managerComboBox;
    JButton update, back;
    String departmentID;

    UpdateDepartment(String departmentID) {
        this.departmentID = departmentID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Cập nhật thông tin bộ phận");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelDepartmentName = new JLabel("Tên bộ phận: ");
        labelDepartmentName.setBounds(50, 100, 150, 30);
        labelDepartmentName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDepartmentName);

        tfdepartmentName = new JTextField();
        tfdepartmentName.setBounds(250, 100, 200, 30);
        add(tfdepartmentName);

        JLabel labelManagerName = new JLabel("Tên người quản lý: ");
        labelManagerName.setBounds(50, 150, 150, 30);
        labelManagerName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelManagerName);

        managerComboBox = new JComboBox<>();
        managerComboBox.setBounds(250, 150, 200, 30);
        add(managerComboBox);

        JLabel labelEmployeeCount = new JLabel("Số lượng nhân viên: ");
        labelEmployeeCount.setBounds(50, 200, 150, 30);
        labelEmployeeCount.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmployeeCount);

        tfemployeeCount = new JTextField();
        tfemployeeCount.setBounds(250, 200, 200, 30);
        add(tfemployeeCount);

        JLabel labelAddress = new JLabel("Địa chỉ: ");
        labelAddress.setBounds(50, 250, 150, 30);
        labelAddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelAddress);

        tfaddress = new JTextField();
        tfaddress.setBounds(250, 250, 200, 30);
        add(tfaddress);

        JLabel labelPhoneNumber = new JLabel("Số điện thoại: ");
        labelPhoneNumber.setBounds(50, 300, 150, 30);
        labelPhoneNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPhoneNumber);

        tfphoneNumber = new JTextField();
        tfphoneNumber.setBounds(250, 300, 200, 30);
        add(tfphoneNumber);

        JLabel labelEmail = new JLabel("Email: ");
        labelEmail.setBounds(50, 350, 150, 30);
        labelEmail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmail);

        tfemail = new JTextField();
        tfemail.setBounds(250, 350, 200, 30);
        add(tfemail);

        loadManagerComboBox();

        try {
            Conn c = new Conn();
            String query = "select * from bophan where DepartmentID = '" + departmentID + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                tfdepartmentName.setText(rs.getString("name"));
                managerComboBox.setSelectedItem(rs.getString("ManagerName"));
                tfemployeeCount.setText(rs.getString("SoluongNV"));
                tfaddress.setText(rs.getString("Address"));
                tfphoneNumber.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("Cập nhật thông tin");
        update.setBounds(250, 450, 200, 40);
        update.addActionListener(this);
        add(update);

        back = new JButton("Quay lại");
        back.setBounds(480, 450, 150, 40);
        back.addActionListener(this);
        add(back);

        setSize(700, 600);
        setLocation(300, 50);
        setVisible(true);
    }

    private void loadManagerComboBox() {
        try {
            Conn conn = new Conn();
            String query = "SELECT DISTINCT NV.name FROM chucvu CV JOIN nhanvien NV ON CV.PositionID = NV.PositionID WHERE CV.name = 'Quản Lý'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                String managerName = rs.getString("NV.name");
                managerComboBox.addItem(managerName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String departmentName = tfdepartmentName.getText();
            String managerName = (String) managerComboBox.getSelectedItem();
            int employeeCount = Integer.parseInt(tfemployeeCount.getText());
            String address = tfaddress.getText();
            String phoneNumber = tfphoneNumber.getText();
            String email = tfemail.getText();

            try {
                Conn conn = new Conn();
                String query = "update bophan set name = '" + departmentName + "', ManagerName = '" + managerName + "', SoluongNV = " + employeeCount + ", Address = '" + address + "', Phone = '" + phoneNumber + "', Email = '" + email + "' where DepartmentID = '" + departmentID + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin bộ phận thành công");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new ViewDepartment();
        }
    }

    public static void main(String[] args) {
        new UpdateDepartment("");
    }
}