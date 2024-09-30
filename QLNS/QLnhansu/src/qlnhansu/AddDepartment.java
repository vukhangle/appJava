
package qlnhansu;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class AddDepartment extends JFrame implements ActionListener {
    
    JTextField tfDepartmentID, tfDepartmentName, tfEmployeeCount, tfAddress, tfPhoneNumber, tfEmail;
    JComboBox<String> managerComboBox;
    JButton add, back;
    JDateChooser dateChooser;
    
    AddDepartment() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Thêm thông tin bộ phận");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelDepartmentID = new JLabel("Mã bộ phận: ");
        labelDepartmentID.setBounds(50, 100, 150, 30);
        labelDepartmentID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDepartmentID);
        
        tfDepartmentID = new JTextField();
        tfDepartmentID.setBounds(250, 100, 200, 30);
        add(tfDepartmentID);
        
        JLabel labelDepartmentName = new JLabel("Tên bộ phận: ");
        labelDepartmentName.setBounds(50, 150, 150, 30);
        labelDepartmentName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDepartmentName);
        
        tfDepartmentName = new JTextField();
        tfDepartmentName.setBounds(250, 150, 200, 30);
        add(tfDepartmentName);
        
        JLabel labelEstablishmentDate = new JLabel("Ngày thành lập: ");
        labelEstablishmentDate.setBounds(50, 200, 150, 30);
        labelEstablishmentDate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEstablishmentDate);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(250, 200, 200, 30);
        add(dateChooser);
        
        JLabel labelManagerName = new JLabel("Tên người quản lý: ");
        labelManagerName.setBounds(50, 250, 150, 30);
        labelManagerName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelManagerName);
        
        managerComboBox = new JComboBox<>(); // Tạo combobox cho chức vụ quản lý
        managerComboBox.setBounds(250, 250, 200, 30);
        add(managerComboBox);
        
        JLabel labelEmployeeCount = new JLabel("Số lượng nhân viên: ");
        labelEmployeeCount.setBounds(50, 300, 150, 30);
        labelEmployeeCount.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmployeeCount);
        
        tfEmployeeCount = new JTextField();
        tfEmployeeCount.setBounds(250, 300, 200, 30);
        add(tfEmployeeCount);
        
        JLabel labelAddress = new JLabel("Địa chỉ: ");
        labelAddress.setBounds(50, 350, 150, 30);
        labelAddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelAddress);
        
        tfAddress = new JTextField();
        tfAddress.setBounds(250, 350, 200, 30);
        add(tfAddress);
        
        JLabel labelPhoneNumber = new JLabel("Số điện thoại: ");
        labelPhoneNumber.setBounds(50, 400, 150, 30);
        labelPhoneNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPhoneNumber);
        
        tfPhoneNumber = new JTextField();
        tfPhoneNumber.setBounds(250, 400, 200, 30);
        // Sử dụng DocumentFilter để lọc dữ liệu đầu vào và chỉ cho phép nhập số
        ((AbstractDocument) tfPhoneNumber.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                StringBuilder sb = new StringBuilder(string);
                for (int i = sb.length() - 1; i >= 0; i--) {
                    char c = sb.charAt(i);
                    if (!Character.isDigit(c)) {
                        sb.deleteCharAt(i);
                    }
                }
                super.insertString(fb, offset, sb.toString(), attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text != null) {
                    StringBuilder sb = new StringBuilder(text);
                    for (int i = sb.length() - 1; i >= 0; i--) {
                        char c = sb.charAt(i);
                        if (!Character.isDigit(c)) {
                            sb.deleteCharAt(i);
                        }
                    }
                    text = sb.toString();
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
        add(tfPhoneNumber);
        
        JLabel labelEmail = new JLabel("Email: ");
        labelEmail.setBounds(50, 450, 150, 30);
        labelEmail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmail);
        
        tfEmail = new JTextField();
        tfEmail.setBounds(250, 450, 200, 30);
        add(tfEmail);
        
        add = new JButton("Thêm");
        add.setBounds(200, 550, 150, 40);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Quay lại");
        back.setBounds(400, 550, 150, 40);
        back.addActionListener(this);
        add(back);
        
        setSize(700, 700);
        setLocation(300, 50);
        setVisible(true);
        loadManagerComboBox();
    }
     private void loadManagerComboBox() {
    try {
        Conn conn = new Conn();
        String query = "SELECT DISTINCT NV.name FROM chucvu CV JOIN nhanvien NV ON CV.PositionID = NV.PositionID WHERE CV.name = 'Quản Lý'";
        ResultSet rs = conn.s.executeQuery(query);
        while (rs.next()) {
            String managerName = rs.getString("NV.name");
            managerComboBox.addItem(managerName); // Thêm tên chức vụ vào combobox
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String departmentID = tfDepartmentID.getText();
            String departmentName = tfDepartmentName.getText();
            String establishmentDate = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String managerName = (String) managerComboBox.getSelectedItem(); // Lấy tên chức vụ quản lý từ combobox
            int employeeCount = Integer.parseInt(tfEmployeeCount.getText());
            String address = tfAddress.getText();
            String phoneNumber = tfPhoneNumber.getText();
            String email = tfEmail.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into bophan (DepartmentID, name, NgayLap, ManagerName, SoluongNV, Address, Phone, Email) values ('"+departmentID+"', '"+departmentName+"', '"+establishmentDate+"', '"+managerName+"', "+employeeCount+", '"+address+"', '"+phoneNumber+"', '"+email+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Thêm thông tin bộ phận thành công");
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
        new AddDepartment();
    }
}
