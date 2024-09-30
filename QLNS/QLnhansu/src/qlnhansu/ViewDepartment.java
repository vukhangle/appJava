/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnhansu;

/**
 *
 * @author namng
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewDepartment extends JFrame implements ActionListener{

    JTable table;
    Choice cdepartmentId;
    JButton search, print, update, back;
    
    ViewDepartment() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Department Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        cdepartmentId = new Choice();
        cdepartmentId.setBounds(180, 20, 150, 20);
        add(cdepartmentId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bophan");
            while(rs.next()) {
                cdepartmentId.add(rs.getString("DepartmentID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bophan");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == search) {
        String query = "select * from bophan where DepartmentID = '"+cdepartmentId.getSelectedItem()+"'";
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == print) {
        try {
            table.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == update) {
        // Hiển thị cửa sổ UpdateDepartment khi nhấn nút "Update"
        openUpdateDepartmentWindow();
    } else {
        setVisible(false);
        new Home();
    }
}

// Phương thức để hiển thị cửa sổ UpdateDepartment
private void openUpdateDepartmentWindow() {
    // Lấy Department ID được chọn từ Choice
    String selectedDepartmentID = cdepartmentId.getSelectedItem();
    // Tạo cửa sổ UpdateDepartment và truyền Department ID đã chọn
    new UpdateDepartment(selectedDepartmentID);
    // Ẩn cửa sổ hiện tại của ViewDepartment
    setVisible(false);
}


    public static void main(String[] args) {
        new ViewDepartment();
    }
}
