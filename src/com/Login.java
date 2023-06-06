package com;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.ResultSet;
import java.sql.SQLException;

@ManagedBean(name = "loginBean")
@SessionScoped
public class Login {
    public String getEmailormobile() {
        return emailormobile;
    }

    public void setEmailormobile(String emailormobile) {
        this.emailormobile = emailormobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String emailormobile;
    private String password;
    private DbConnection conn;
    public User user = new User();

    public Login() {
        conn = new DbConnection();
    }

    public String loginpro() throws SQLException {
        ResultSet rs = conn.getRecord(emailormobile, password);
        if (rs != null && rs.next()) {
            user.setFirstName(rs.getString("first_name"));
            user.setSurname(rs.getString("surname"));
            user.setEmailOrMobile(rs.getString("email_or_mobile"));
            user.setGender(rs.getString("gender"));
            user.setNewPassword(rs.getString("password"));
            user.setSelectedDay(rs.getInt("selectedDay"));
            user.setSelectedMonth(rs.getString("selectedMonth"));
            user.setSelectedYear(rs.getInt("selectedYear"));
            user.setId(rs.getInt("id"));
            return "car.xhtml";
        } else {
            return "index.xhtml";
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
