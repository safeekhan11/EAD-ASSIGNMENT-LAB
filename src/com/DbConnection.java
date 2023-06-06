package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
    private String dbURL = "jdbc:mysql://localhost:3306/ass";
    private String username = "root";
    private String password = "";
    private Connection connection;
    public DbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, username, password);
            if (connection != null) {
                System.out.println("data base conn successfully established");
            }else{
                System.out.println("data base nottttttt established");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertRecord(User user) {
        try {
            String sqlQuery = "INSERT INTO users(first_Name, surname, email_or_mobile, password, selectedDay, selectedMonth, selectedYear, gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmailOrMobile());
            preparedStatement.setString(4, user.getNewPassword());
            preparedStatement.setInt(5, user.getSelectedDay());
            preparedStatement.setString(6, user.getSelectedMonth());
            preparedStatement.setInt(7, user.getSelectedYear());
            preparedStatement.setString(8, user.getGender());

            int noOfRowsInserted = preparedStatement.executeUpdate();
            if (noOfRowsInserted > 0) {
                System.out.println(noOfRowsInserted + " row(s) inserted!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean compare(String emailormobile , String password) {
        try {
            String sqlQuery = "SELECT * FROM users WHERE email_or_mobile = ? and password =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,emailormobile);
            preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//    public void updateRecord(String fName, String lName, String email, int  age, String gender, String address) {
//        try {
//            String sqlQuery1 = "UPDATE signup SET firstName=?,lastName=?,email=?,age=?,gender=?,address=? WHERE email=?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery1);
//            preparedStatement.setString(1, fName);
//            preparedStatement.setString(2, lName);
//            preparedStatement.setString(3, email);
//            preparedStatement.setInt(4, age);
//            preparedStatement.setString(5, gender);
//            preparedStatement.setString(6, address);
//            preparedStatement.setString(7, email);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public int deleteRecord(String email) {
//        int row =0;
//        try {
//            String sqlQuery = "DELETE from signup WHERE email=?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//            preparedStatement.setString(1, email);
//            row= preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return row;
//    }
//
//
    public ResultSet getRecord(String username,String password) {
        try {
            String sqlQuery = "SELECT * FROM users WHERE email_or_mobile=? and password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
        public List<Car> getCars() {

            List<Car> cars = new ArrayList<>();
            try{

                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars");
                 ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String carname = resultSet.getString("car_name");
                    String modelname = resultSet.getString("brand_name");
                    double price = resultSet.getInt("rent_price");


                    Car car = new Car(id, carname, modelname,price);
                    cars.add(car);

                    }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return cars;
        }

        public void bookcar1(int uid, int cid){
        try{
            String sql = "INSERT INTO user_car (user_id, car_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            // Set the parameter values
            statement.setInt(1, uid);
            statement.setInt(2, cid);
            // Execute the SQL statement
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User ID " + uid + " and Car ID " + cid + " successfully associated.");
            } else {
                System.out.println("Failed to associate User ID " + uid + " and Car ID " + cid);
            }}
         catch (SQLException e) {
        e.printStackTrace();
    }
    }
    private  void fetchUserCarData() {
        try{

            String sql = "SELECT u.*, c.* " +
                    "FROM users u " +
                    "JOIN user_car uc ON u.id = uc.user_id " +
                    "JOIN cars c ON c.id = uc.car_id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int userId = resultSet.getInt("u.id");
                String firstName = resultSet.getString("u.first_name");
                String surname = resultSet.getString("u.surname");
                String emailOrMobile = resultSet.getString("u.email_or_mobile");
                String password = resultSet.getString("u.password");
                int selectedDay = resultSet.getInt("u.selectedDay");
                int selectedMonth = resultSet.getInt("u.selectedMonth");
                int selectedYear = resultSet.getInt("u.selectedYear");
                String gender = resultSet.getString("u.gender");

                int carId = resultSet.getInt("c.id");
                String carName = resultSet.getString("c.car_name");
                String brandName = resultSet.getString("c.brand_name");
                double rentPrice = resultSet.getDouble("c.rent_price");

                // Process and use the retrieved user and car data as needed
                System.out.println("User ID: " + userId);
                System.out.println("First Name: " + firstName);
                System.out.println("Surname: " + surname);
                System.out.println("Email or Mobile: " + emailOrMobile);
                System.out.println("Password: " + password);
                System.out.println("Selected Day: " + selectedDay);
                System.out.println("Selected Month: " + selectedMonth);
                System.out.println("Selected Year: " + selectedYear);
                System.out.println("Gender: " + gender);
                System.out.println("Car ID: " + carId);
                System.out.println("Car Name: " + carName);
                System.out.println("Brand Name: " + brandName);
                System.out.println("Rent Price: " + rentPrice);
                System.out.println("----------------------------------");
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }





