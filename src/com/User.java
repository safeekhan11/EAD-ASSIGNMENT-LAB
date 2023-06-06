package com;

public class User {
    private String firstName;
    private String surname;
    private String emailOrMobile;
    private String newPassword;
    private int selectedDay;
    private String selectedMonth;
    private int selectedYear;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private  int id;
    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailOrMobile() {
        return emailOrMobile;
    }

    public void setEmailOrMobile(String emailOrMobile) {
        this.emailOrMobile = emailOrMobile;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public int getSelectedDay() {
        return selectedDay;
    }

    public void setSelectedDay(int selectedDay) {
        this.selectedDay = selectedDay;
    }

    public String getSelectedMonth() {
        return selectedMonth;
    }

    public void setSelectedMonth(String selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    public int getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(int selectedYear) {
        this.selectedYear = selectedYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
