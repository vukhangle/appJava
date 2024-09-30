/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Thinkpad
 */
public class DateHelper {
  static SimpleDateFormat formater = new SimpleDateFormat();

  //chuyen chuoi thanh ngay
  public static Date toDate(String date, String pattern) {
    try {
      formater.applyPattern(pattern);
      return formater.parse(date);
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }

  //chuyen ngay thanh chuoi
  public static String toString(Date date, String pattern) {
    formater.applyPattern(pattern);
    return formater.format(date);
  }

  //lay thoi gian hien tai
  public static Date now() {
    return new Date();
  }
  
  //chuyen doi ngay util thanh ngay sql
  public static java.sql.Date toSQL(java.util.Date date) {
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    return sqlDate;
  }
}
