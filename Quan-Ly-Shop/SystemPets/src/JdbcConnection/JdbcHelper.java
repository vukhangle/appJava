/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Thinkpad
 */
public class JdbcHelper {
  Connection connect;

  public JdbcHelper() {
    String url = "jdbc:sqlserver://localhost:1433;databaseName=dichvuthucung";
    String use = "sa";
    String pass = "123456";
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      connect = DriverManager.getConnection(url, use, pass);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Connection getConnect() {
    return connect;
  }

  public void setConnect(Connection connect) {
    this.connect = connect;
  }

  public void Diconnect() {
    try {
      connect.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
