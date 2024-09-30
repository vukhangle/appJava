/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Thinkpad
 */
public class Validator {
  public static boolean checkEmpty(JTextField field,StringBuilder sb, String msg) {
    boolean check = true;
    if (field.getText().equals("")) {
      sb.append(msg).append("\n");
      field.setBackground(Color.getHSBColor(100, 218, 350));
      check = false;
    } else {
      field.setBackground(Color.white);
    }
    return check;
  }
  
  public static boolean CheckNumber(JTextField field, StringBuilder sb, String msg) {
    boolean check = true;
    if (!checkEmpty(field, sb, msg)) {
      return false;
    }
    try {
      double nb = Double.parseDouble(field.getText());
    } catch (Exception e) {
      sb.append("Dữ liệu phải là số !").append("\n");
      field.setBackground(Color.getHSBColor(100, 218, 350));
      check = false;
    }
    if(check) {
      field.setBackground(Color.white);
    }
    return check;
  }
}
