
    package qlnhansu;

    import java.awt.*;
    import javax.swing.*;
    import com.toedter.calendar.JDateChooser;
    import java.awt.event.*;
    import java.util.Random;
    import java.sql.ResultSet;
    import javax.swing.text.AbstractDocument;
    import javax.swing.text.AttributeSet;
    import javax.swing.text.BadLocationException;
    import javax.swing.text.DocumentFilter;

    public class AddEmployee extends JFrame implements ActionListener{

        Random ran = new Random();
        int number = ran.nextInt(999999);

        JTextField tfName, tfPositionID, tfAddress, tfPhone, tfEmail, tfSalary, tfDepartmentID, tfGender;
        JDateChooser dcDob;
        JComboBox cbEducation;
        JComboBox<String> cbDepartment, cbPosition;
        JLabel lblEmpID;
        JButton add, back;
        JRadioButton male, female, other; // Sử dụng nhóm nút radio cho giới tính
        ButtonGroup genderGroup; // Để chỉ cho phép chọn một giới tính

        AddEmployee() {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel heading = new JLabel("Thêm Thông tin Nhân sự");
            heading.setBounds(320, 30, 500, 50);
            heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
            add(heading);

            JLabel labelName = new JLabel("Tên: ");
            labelName.setBounds(50, 150, 150, 30);
            labelName.setFont(new Font("serif", Font.PLAIN, 20));
            add(labelName);

            tfName = new JTextField();
            tfName.setBounds(200, 150, 150, 30);
            add(tfName);

            JLabel labelPositionID = new JLabel("Chức Vụ: ");
            labelPositionID.setBounds(400, 150, 150, 30);
            labelPositionID.setFont(new Font("serif", Font.PLAIN, 20));
            add(labelPositionID);
            cbPosition = new JComboBox();
            cbPosition.setBackground(Color.WHITE);
            cbPosition.setBounds(600, 150, 150, 30);
            add(cbPosition);
//            tfPositionID = new JTextField();
//            tfPositionID.setBounds(600, 150, 150, 30);
//            add(tfPositionID);

            JLabel labelDob = new JLabel("Ngày Sinh: ");
            labelDob.setBounds(50, 200, 150, 30);
            labelDob.setFont(new Font("serif", Font.PLAIN, 20));
            add(labelDob);

            dcDob = new JDateChooser();
            dcDob.setBounds(200, 200, 150, 30);
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

            JLabel labelDepartmentID = new JLabel("Mã Bộ Phận");
            labelDepartmentID.setBounds(50, 350, 150, 30);
            labelDepartmentID.setFont(new Font("serif", Font.PLAIN, 20));
            add(labelDepartmentID);
            cbDepartment = new JComboBox();
            cbDepartment.setBackground(Color.WHITE);
            cbDepartment.setBounds(200, 350, 150, 30);
            add(cbDepartment);

//            tfDepartmentID = new JTextField();
//            tfDepartmentID.setBounds(200, 350, 150, 30);
//            add(tfDepartmentID);
                
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

            JLabel labelEmpID = new JLabel("Mã Nhân Sự: ");
            labelEmpID.setBounds(50, 400, 150, 30);
            labelEmpID.setFont(new Font("serif", Font.PLAIN, 20));
            add(labelEmpID);

            lblEmpID = new JLabel("" + number);
            lblEmpID.setBounds(200, 400, 150, 30);
            lblEmpID.setFont(new Font("serif", Font.PLAIN, 20));
            add(lblEmpID);

            add = new JButton("Thêm");
            add.setBounds(250, 550, 150, 40);
            add.addActionListener(this);
            add.setBackground(Color.BLACK);
            add.setForeground(Color.WHITE);
            add(add);

            back = new JButton("Back");
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
            if (ae.getSource() == add) {
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
                String empID = lblEmpID.getText();

                try {
                    Conn conn = new Conn();
                    String query = "insert into nhanvien values('"+name+"', '"+empID+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+departmentID+"', '"+gender+"', '"+positionID+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Details added successfully");
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
            new AddEmployee();
        }
    }
