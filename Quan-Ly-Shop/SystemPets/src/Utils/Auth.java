/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import model.NhanVien;


/**
 *
 * @author Thinkpad
 */
public class Auth {
  public static NhanVien user = null;
  public static void clear() {
    Auth.user = null;
  }
}
