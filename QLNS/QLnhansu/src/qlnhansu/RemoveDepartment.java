/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnhansu;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveDepartment extends JFrame implements ActionListener {
    
    Choice cDeptId;
    JButton delete, back;
    
    RemoveDepartment() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelDeptId = new JLabel("Department ID");
        labelDeptId.setBounds(50, 50, 100, 30);
        add(labelDeptId);
        
        cDeptId = new Choice();
        cDeptId.setBounds(200, 50, 150, 30);
        add(cDeptId);
        
        try {
            Conn c = new Conn();
            String query = "select * from bophan";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cDeptId.add(rs.getString("DepartmentID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelDeptName = new JLabel("Department Name: ");
        labelDeptName.setBounds(50, 100, 150, 30);
        add(labelDeptName);
        
        JLabel lblDeptName = new JLabel();
        lblDeptName.setBounds(200, 100, 150, 30);
        add(lblDeptName);
        
        JLabel labelManagerName = new JLabel("Manager Name: ");
        labelManagerName.setBounds(50, 150, 150, 30);
        add(labelManagerName);
        
        JLabel lblManagerName = new JLabel();
        lblManagerName.setBounds(200, 150, 150, 30);
        add(lblManagerName);
        
        JLabel labelEmployeeCount = new JLabel("Employee Count: ");
        labelEmployeeCount.setBounds(50, 200, 150, 30);
        add(labelEmployeeCount);
        
        JLabel lblEmployeeCount = new JLabel();
        lblEmployeeCount.setBounds(200, 200, 150, 30);
        add(lblEmployeeCount);
        
        try {
            Conn c = new Conn();
            String query = "select * from bophan where DepartmentID = '"+cDeptId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblDeptName.setText(rs.getString("name"));
                lblManagerName.setText(rs.getString("ManagerName"));
                lblEmployeeCount.setText(rs.getString("SoluongNV"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cDeptId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from bophan where DepartmentID = '"+cDeptId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblDeptName.setText(rs.getString("name"));
                        lblManagerName.setText(rs.getString("ManagerName"));
                        lblEmployeeCount.setText(rs.getString("SoluongNV"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from bophan where DepartmentID = '"+cDeptId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Department information deleted successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveDepartment();
    }
}
