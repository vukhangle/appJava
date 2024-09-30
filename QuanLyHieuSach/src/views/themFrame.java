/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.loaiController;
import controllers.nxbController;
import controllers.sachController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.Loai;
import models.NXB;
import models.Sach;
import util.imageProcess;

/**
 *
 * @author myPC
 */
public class themFrame extends javax.swing.JFrame {
    loaiController loaiCTL = new loaiController();
    sachController tcCTL = new sachController();
    nxbController nxbCTL = new nxbController();
    NXB[] nxb_list = nxbCTL.getNxb();
    Loai[] loai_list = loaiCTL.getLoaiList();
    String path  = System.getProperty("user.dir") + "\\TESTPHOTOS";
    ImageIcon icon;
    String pathName = "";
    InputStream is = null;
    imageProcess imagePRC = new imageProcess();
    /**
     * Creates new form themFrame
     */
    public themFrame() {
        initComponents();
        init();
    }
    public void init(){
        setTitle("Thêm sách mới");
        setMa100();
        setSchedule(yearCB, monthCB, dayCB);
        updateInfor();
        for(int i = 0; i<loai_list.length;i++){
            loaiCB.addItem(loai_list[i].getTenLoai());
        }
        for(int i = 0; i<nxb_list.length;i++){
            nxbCB.addItem(nxb_list[i].getTenNxb());
        }
    }
    public void themFunc(){
        Sach tc = new Sach();
        String ma = maTcMoiField.getText();
        String ten = tenTcMoiField.getText();
        int sl = Integer.parseInt(String.valueOf(slMoiField.getValue()));
        String nxb = String.valueOf(nxbCB.getSelectedItem());
        String ngayXb = String.valueOf(yearCB.getSelectedItem())+"-"+String.valueOf(monthCB.getSelectedItem())+"-"
                +String.valueOf(dayCB.getSelectedItem());
        String loai = String.valueOf(loaiCB.getSelectedItem());
        int giaTien = Integer.parseInt(String.valueOf(giaTienField.getText()));
        
        if(!ten.equals("")){
            tc = new Sach(ma, ten, sl, nxb, ngayXb, loai, giaTien);
        
            try {
                tcCTL.insertTapChi(tc);
                if(is!=null)imagePRC.updateImage(ma, is);
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công!", "Message", 1);
                System.out.println("Thêm thành công");
            } catch (Exception e) {
                System.err.println("Không thêm được");
            }
            setMa100();
            tenTcMoiField.setText("");
        }
    }
    //hàm dặt mã
    public void setMa100(){
        int i = tcCTL.layMaCuoi();
        if(i<10){
            maTcMoiField.setText("S0"+i);
        }
        else{
            maTcMoiField.setText("S"+i);
        }
    }
    //ham chon ảnh
    public void chonFileAnh(){
        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setCurrentDirectory(new File(path));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGE", "png", "jpeg", "jpg");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            pathName = path;
            ImageIcon icon = new ImageIcon(path);
            imageLabel.setIcon(imagePRC.scaleImage(icon,imageLabel));
            try {
                is = new FileInputStream(selectedFile);
            } catch (FileNotFoundException ex) {
            }
            setTitle(selectedFile.getName());
        } else {
            System.out.println("No data");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        maTcMoiField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tenTcMoiField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        slMoiField = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        nxbCB = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        loaiCB = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        yearCB = new javax.swing.JComboBox<>();
        monthCB = new javax.swing.JComboBox<>();
        dayCB = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        chonBTN = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        giaTienField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM SÁCH MỚI");

        maTcMoiField.setEditable(false);

        jLabel2.setText("Mã ");

        jLabel3.setText("Tên ");

        jLabel4.setText("Số lượng");

        jLabel5.setText("NXB");

        jLabel6.setText("Loại");

        jLabel7.setText("Ngày xuất bản");

        yearCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearCBActionPerformed(evt);
            }
        });

        monthCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthCBActionPerformed(evt);
            }
        });

        jButton1.setText("THÊM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Thêm hình ảnh");

        chonBTN.setText("Chọn File");
        chonBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chonBTNActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        imageLabel.setBackground(new java.awt.Color(0, 0, 0));
        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setText("Giá");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(yearCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monthCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dayCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(slMoiField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(giaTienField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(loaiCB, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nxbCB, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tenTcMoiField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maTcMoiField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chonBTN)
                        .addGap(116, 116, 116))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maTcMoiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tenTcMoiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(slMoiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(giaTienField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nxbCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(yearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loaiCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(chonBTN))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yearCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCBActionPerformed
        // TODO add your handling code here:
        updateInfor();
    }//GEN-LAST:event_yearCBActionPerformed

    private void monthCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthCBActionPerformed
        // TODO add your handling code here:
        updateInfor();
    }//GEN-LAST:event_monthCBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        themFunc();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void chonBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chonBTNActionPerformed
        // TODO add your handling code here:
        chonFileAnh();
    }//GEN-LAST:event_chonBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(themFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(themFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(themFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(themFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new themFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chonBTN;
    private javax.swing.JComboBox<String> dayCB;
    private javax.swing.JTextField giaTienField;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> loaiCB;
    private javax.swing.JTextField maTcMoiField;
    private javax.swing.JComboBox<String> monthCB;
    private javax.swing.JComboBox<String> nxbCB;
    private javax.swing.JSpinner slMoiField;
    private javax.swing.JTextField tenTcMoiField;
    private javax.swing.JComboBox<String> yearCB;
    // End of variables declaration//GEN-END:variables
    
    
    //Ham update du lieu 
    public void updateInfor(){
        dayCB.setModel(new DefaultComboBoxModel(new String[]{}));
        if(monthCB.getSelectedIndex()>=0 && yearCB.getSelectedIndex()>=0){
            int monthNow = LocalDate.now().getMonthValue();
            int yearNow = LocalDate.now().getYear();
            int year = Integer.parseInt(String.valueOf(yearCB.getSelectedItem()));
            int month = Integer.parseInt(String.valueOf(monthCB.getSelectedItem()));
            int dayCount = 30;
            if(month == monthNow && year == yearNow){
                dayCount = LocalDate.now().getDayOfMonth();
            }
            else if(month == 2){
                dayCount = 28;
            }
            else if(month <= 8){
                if(month == 8 || month%2 == 1){
                    dayCount = 31;
                }
                else{
                    dayCount = 30;
                }
            }else if (month%2 == 1) dayCount = 30;
            else dayCount = 31;
            
            for(int i = dayCount; i>=1; i--){
                if(i<10){
                    dayCB.addItem("0"+i);
                }else{
                    dayCB.addItem(""+i);
                }
            }
        }
        dayCB.setSelectedItem(LocalDate.now().getDayOfMonth());
    }
    //Ham cai comboBox
    public void setSchedule(JComboBox yearCB, JComboBox monthCB,JComboBox dayCB ){
        //Them nam
        int currentYear = LocalDate.now().getYear();
        for(int i = currentYear; i>=2000;i--){
            yearCB.addItem(i);
        }
        //Them thang cho months
        for(int i = 1; i<=12;i++){
            if(i<10){
                monthCB.addItem("0"+i);
            }else{
                monthCB.addItem(i);
            }
        }
        monthCB.setSelectedItem(LocalDate.now().getMonthValue());
    }
}