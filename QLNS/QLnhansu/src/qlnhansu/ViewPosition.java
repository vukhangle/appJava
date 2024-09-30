package qlnhansu;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewPosition extends JFrame implements ActionListener{

    JTable table;
    Choice cpositionId;
    JButton search, print, update, back, add;
    
    ViewPosition() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Position Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        cpositionId = new Choice();
        cpositionId.setBounds(180, 20, 150, 20);
        add(cpositionId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from chucvu");
            while(rs.next()) {
                cpositionId.add(rs.getString("PositionID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from chucvu");
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
        
        add = new JButton("Add");
        add.setBounds(420, 70, 80, 20);
        add.addActionListener(this);
        add(add); // Đặt nút "Add" vào bố cục
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == search) {
        // Xử lý tìm kiếm
    } else if (ae.getSource() == print) {
        // Xử lý in
    } else if (ae.getSource() == update) {
        // Chuyển sang cửa sổ UpdatePosition khi nhấn nút "Update"
        openUpdatePositionWindow();
    } else if (ae.getSource() == add) {
        // Hiển thị cửa sổ AddPosition khi nhấn nút "Add"
        openAddPositionWindow();
    } else {
        setVisible(false);
        new Home();
    }
}

// Phương thức để hiển thị cửa sổ UpdatePosition
private void openUpdatePositionWindow() {
    // Lấy Position ID được chọn từ Choice
    String selectedPositionID = cpositionId.getSelectedItem();
    // Tạo cửa sổ UpdatePosition và truyền Position ID đã chọn
    new UpdatePosition(selectedPositionID);
    // Ẩn cửa sổ hiện tại của ViewPosition
    setVisible(false);
}


    
    // Phương thức để hiển thị cửa sổ AddPosition   
    private void openAddPositionWindow() {
        setVisible(false); // Ẩn cửa sổ hiện tại của ViewPosition
        new AddPosition(); // Hiển thị cửa sổ AddPosition
    }   

    public static void main(String[] args) {
        new ViewPosition();
    }
}
