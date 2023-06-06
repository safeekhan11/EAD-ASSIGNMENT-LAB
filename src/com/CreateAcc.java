package com;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "signupBean")
@RequestScoped
public class CreateAcc {
    public User user;
    public DbConnection conn;
    private List<Integer> days;
    private List<String> months;
    private List<Integer> years;

    public CreateAcc() {
        user = new User();
        conn = new DbConnection();
        populateDropdowns();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String signup() {
        conn.insertRecord(user);
        return "login1.xhtml";

    }

    private void populateDropdowns() {
        // Initialize the dropdown values according to your requirements
        days = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        months = Arrays.asList("January", "February", "March", "April", "May", "June");
        years = Arrays.asList(2000, 2001, 2002, 2003, 2004, 2005);
    }

    public List<Integer> getDays() {
        return days;
    }

    public void setDays(List<Integer> days) {
        this.days = days;
    }

    public List<String> getMonths() {
        return months;
    }

    public void setMonths(List<String> months) {
        this.months = months;
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }


}
