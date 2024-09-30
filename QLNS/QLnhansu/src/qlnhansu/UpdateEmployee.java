package qlnhansu;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tfName, tfAddress, tfPhone, tfEmail, tfSalary;
    JDateChooser dcDob;
    JComboBox<String> cbEducation, cbDepartment, cbPosition;
    JButton update, back;
    JRadioButton male, female, other;
    ButtonGroup genderGroup;
    String empID ;

    UpdateEmployee(String empID) {
        this.empID  = empID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Cập Nhật Thông tin Nhân sự");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelName = new JLabel("Tên: ");
        labelName.setBounds(50, 100, 150, 30);
        labelName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelName);

        tfName = new JTextField();
        tfName.setBounds(200, 100, 150, 30);
        add(tfName);

        JLabel labelPositionID = new JLabel("Chức Vụ: ");
        labelPositionID.setBounds(400, 100, 150, 30);
        labelPositionID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPositionID);

        cbPosition = new JComboBox<String>();
        cbPosition.setBackground(Color.WHITE);
        cbPosition.setBounds(600, 100, 150, 30);
        add(cbPosition);

        JLabel labelDob = new JLabel("Ngày Sinh: ");
        labelDob.setBounds(50, 150, 150, 30);
        labelDob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDob);

        dcDob = new JDateChooser();
        dcDob.setBounds(200, 150, 150, 30);
        add(dcDob);

        JLabel labelSalary = new JLabel("Lương (VND): ");
        labelSalary.setBounds(400, 200, 150, 30);
        labelSalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelSalary);

        tfSalary = new JTextField();
        tfSalary.setBounds(600, 200, 150, 30);
        // Sử dụng DocumentFilter để lọc dữ liệu đầu vào và chỉ cho phép nhập số
        ((AbstractDocument) tfSalary.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
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
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
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
        add(tfSalary);

        JLabel labelAddress = new JLabel("Địa chỉ: ");
        labelAddress.setBounds(50, 250, 150, 30);
        labelAddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 250, 150, 30);
        add(tfAddress);

        JLabel labelPhone = new JLabel("Điện thoại: ");
        labelPhone.setBounds(400, 250, 150, 30);
        labelPhone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPhone);   
        tfPhone = new JTextField();
        tfPhone.setBounds(600, 250, 150, 30);
        // Sử dụng DocumentFilter để lọc dữ liệu đầu vào và chỉ cho phép nhập số
        ((AbstractDocument) tfPhone.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
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
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
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
        add(tfPhone);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 300, 150, 30);
        labelEmail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(200, 300, 150, 30);
        add(tfEmail);

        JLabel labelEducation = new JLabel("Cấp Bậc");
        labelEducation.setBounds(400, 300, 150, 30);
        labelEducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEducation);

        String courses[] = {"Trung Cấp","Cao Đẳng", "Đại Học","Thạc sĩ/Tiến sĩ","Giáo Sư"};
        cbEducation = new JComboBox(courses);
        cbEducation.setBackground(Color.WHITE);
        cbEducation.setBounds(600, 300, 150, 30);
        add(cbEducation);

        JLabel labelDepartmentID = new JLabel(" Bộ Phận");
        labelDepartmentID.setBounds(50, 350, 150, 30);
        labelDepartmentID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDepartmentID);
        cbDepartment = new JComboBox();
        cbDepartment.setBackground(Color.WHITE);
        cbDepartment.setBounds(200, 350, 150, 30);
        add(cbDepartment);

        JLabel labelGender = new JLabel("Giới tính");
        labelGender.setBounds(400, 350, 150, 30);
        labelGender.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelGender);

        male = new JRadioButton("Nam");
        male.setBackground(Color.WHITE);
        male.setBounds(600, 350, 70, 30);
        add(male);

        female = new JRadioButton("Nữ");
        female.setBackground(Color.WHITE);
        female.setBounds(680, 350, 70, 30);
        add(female);

        other = new JRadioButton("Khác");
        other.setBackground(Color.WHITE);
        other.setBounds(760, 350, 70, 30);
        add(other);

        // Gộp các nút radio vào một nhóm
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JLabel labelEmpID = new JLabel(" Mã Nhân Sự: ");
        labelEmpID.setBounds(50, 400, 150, 30);
        labelEmpID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmpID);

        JLabel empIDLbl = new JLabel(empID);
        empIDLbl.setBounds(200, 400, 150, 30);
        empIDLbl.setFont(new Font("serif", Font.PLAIN, 20));
        add(empIDLbl);

        update = new JButton("Cập nhật");
        update.setBounds(250, 550, 150, 40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

        back = new JButton("Quay lại");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);

        loadDepartments();
        loadPositions();
    }


    public void loadDepartments() {
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM bophan";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                String departmentName = rs.getString("name");
                cbDepartment.addItem(departmentName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }        

    public void loadPositions() {
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM chucvu";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                String positionName = rs.getString("name");
                cbPosition.addItem(positionName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == update) {
        String name = tfName.getText();
        String departmentID = (String) cbDepartment.getSelectedItem();
        String positionID = (String) cbPosition.getSelectedItem();
        String dob = ((JTextField) dcDob.getDateEditor().getUiComponent()).getText();
        String salary = tfSalary.getText();
        String address = tfAddress.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();
        String education = (String) cbEducation.getSelectedItem();
        String gender = "";
        
        String queryDeptID = "SELECT departmentID FROM bophan WHERE name = '" + departmentID + "'";
        try {
            Conn conn = new Conn();
            ResultSet rsDeptID = conn.s.executeQuery(queryDeptID);
            if (rsDeptID.next()) {
                departmentID = rsDeptID.getString("departmentID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String queryPosID = "SELECT positionID FROM chucvu WHERE name = '" + positionID + "'";
        try {
            Conn conn = new Conn();
            ResultSet rsPosID = conn.s.executeQuery(queryPosID);
            if (rsPosID.next()) {
                positionID = rsPosID.getString("positionID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (male.isSelected()) {
            gender = "Nam";
        } else if (female.isSelected()) {
            gender = "Nữ";
        } else if (other.isSelected()) {
            gender = "Khác";
        }
        
       try {
                Conn conn = new Conn();
                String query = "UPDATE nhanvien SET name = '" + name + "', dob = '" + dob + "', salary = '" + salary + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "', education = '" + education + "', departmentID = '" + departmentID + "', gender = '" + gender + "', positionID = '" + positionID + "' WHERE empID = '" + this.empID  + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Thông tin nhân viên được cập nhật thành công");
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
        new UpdateEmployee("");
    }
}
