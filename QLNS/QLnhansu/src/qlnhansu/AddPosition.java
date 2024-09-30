
package qlnhansu;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AddPosition extends JFrame implements ActionListener {
    
    JTextField tfPositionID, tfPositionName, tfSalary;
    JButton add, back;
    
    AddPosition() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Thêm thông tin chức vụ");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelPositionID = new JLabel("Mã chức vụ: ");
        labelPositionID.setBounds(50, 100, 150, 30);
        labelPositionID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPositionID);
        
        tfPositionID = new JTextField();
        tfPositionID.setBounds(250, 100, 200, 30);
        add(tfPositionID);
        
        JLabel labelPositionName = new JLabel("Tên chức vụ: ");
        labelPositionName.setBounds(50, 150, 150, 30);
        labelPositionName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPositionName);
        
        tfPositionName = new JTextField();
        tfPositionName.setBounds(250, 150, 200, 30);
        add(tfPositionName);
        
        JLabel labelSalary = new JLabel("Lương: ");
        labelSalary.setBounds(50, 200, 150, 30);
        labelSalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelSalary);
        
        tfSalary = new JTextField();
        tfSalary.setBounds(250, 200, 200, 30);
        add(tfSalary);
        
        add = new JButton("Thêm");
        add.setBounds(200, 250, 150, 40);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Quay lại");
        back.setBounds(400, 250, 150, 40);
        back.addActionListener(this);
        add(back);
        
        setSize(700, 400);
        setLocation(300, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String positionID = tfPositionID.getText();
            String positionName = tfPositionName.getText();
            double salary = Double.parseDouble(tfSalary.getText());
            
            try {
                Conn conn = new Conn();
                String query = "insert into chucvu (PositionID, name, salary) values ('"+positionID+"', '"+positionName+"', "+salary+")";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Thêm thông tin chức vụ thành công");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddPosition();
    }
}
