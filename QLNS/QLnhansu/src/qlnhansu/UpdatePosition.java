package qlnhansu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdatePosition extends JFrame implements ActionListener{
    
    JTextField tfPositionName, tfSalary;
    JLabel lblPositionID;
    JButton update, back;
    String positionID;
    
    UpdatePosition(String positionID) {
        this.positionID = positionID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("Cập Nhật Chức Vụ");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelPositionID = new JLabel("Mã Chức Vụ: ");
        labelPositionID.setBounds(50, 100, 150, 30);
        labelPositionID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPositionID);
        
        lblPositionID = new JLabel();
        lblPositionID.setBounds(250, 100, 150, 30);
        add(lblPositionID);
        
        JLabel labelPositionName = new JLabel("Tên Chức Vụ: ");
        labelPositionName.setBounds(50, 150, 150, 30);
        labelPositionName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPositionName);
        
        tfPositionName = new JTextField();
        tfPositionName.setBounds(250, 150, 200, 30);
        add(tfPositionName);
        
        JLabel labelSalary = new JLabel("Salary: ");
        labelSalary.setBounds(50, 200, 150, 30);
        labelSalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelSalary);
        
        tfSalary = new JTextField();
        tfSalary.setBounds(250, 200, 200, 30);
        add(tfSalary);
        
        try {
            Conn c = new Conn();
            String query = "select * from chucvu where PositionID = '"+positionID+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblPositionID.setText(rs.getString("PositionID"));
                tfPositionName.setText(rs.getString("name"));
                tfSalary.setText(rs.getString("salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        update = new JButton("Update Details");
        update.setBounds(200, 250, 150, 40);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(400, 250, 150, 40);
        back.addActionListener(this);
        add(back);
        
        setSize(700, 400);
        setLocation(300, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String name = tfPositionName.getText();
            double salary = Double.parseDouble(tfSalary.getText());
            
            try {
                Conn conn = new Conn();
                String query = "update chucvu set name = '"+name+"', salary = '"+salary+"' where PositionID = '"+positionID+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Cập nhật chức vụ thành công!!!");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new ViewPosition();
        }
    }

    public static void main(String[] args) {
        new UpdatePosition("");
    }
}
