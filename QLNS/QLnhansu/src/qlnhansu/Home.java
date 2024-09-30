/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnhansu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton view, add, update, remove, addDepartment, viewDepartment, updateDepartment, removeDepartment, position, exit;

    Home() {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Quản lý nhân sự ");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        add = new JButton("Thêm Nhân Sự: ");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("Xem thông tin nhân sự");
        view.setBounds(820, 80, 180, 40);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Cập nhật nhân sự");
        update.setBounds(650, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Xóa nhân sự");
        remove.setBounds(820, 140, 180, 40);
        remove.addActionListener(this);
        image.add(remove);

        position = new JButton("Chức vụ");
        position.setBounds(650, 500, 180, 40);
        position.addActionListener(this);
        image.add(position);

        exit = new JButton("Thoát");
        exit.setBounds(980, 550, 100, 40);
        exit.addActionListener(this);
        image.add(exit);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);

        JLabel heading1 = new JLabel("Quản lý bộ phận ");
        heading1.setBounds(620, 280, 400, 40);
        heading1.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading1);

        addDepartment = new JButton("Thêm Bộ Phận ");
        addDepartment.setBounds(650, 340, 150, 40);
        addDepartment.addActionListener(this);
        image.add(addDepartment);

        viewDepartment = new JButton("Xem thông tin bộ phận");
        viewDepartment.setBounds(840, 340, 180, 40);
        viewDepartment.addActionListener(this);
        image.add(viewDepartment);

        updateDepartment = new JButton("Cập nhật Bộ Phận");
        updateDepartment.setBounds(650, 400, 150, 40);
        updateDepartment.addActionListener(this);
        image.add(updateDepartment);

        removeDepartment = new JButton("Xóa Bộ phận");
        removeDepartment.setBounds(840, 400, 180, 40);
        removeDepartment.addActionListener(this);
        image.add(removeDepartment);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == remove) {
            setVisible(false);
            new RemoveEmployee();
        } else if (ae.getSource() == addDepartment) {
            setVisible(false);
            new AddDepartment();
        } else if (ae.getSource() == viewDepartment) {
            setVisible(false);
            new ViewDepartment();
        } else if (ae.getSource() == updateDepartment) {
            setVisible(false);
            new ViewDepartment();
        } else if (ae.getSource() == removeDepartment) {
            setVisible(false);
            new RemoveDepartment();
        } else if (ae.getSource() == position) {
            setVisible(false);
            new ViewPosition();
        } else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
