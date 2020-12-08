package com.jsp.db;

import com.jsp.model.User;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;

public class CRUDUsers {
    private static final String URL = "jdbc:mysql://localhost:3306/jsp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";
    private static final String SELECT_QUERY = "SELECT * FROM users;";

    private static Connection getConnection() {


        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SELECT_QUERY);

            while (rs.next()) {
                int id = rs.getInt("idusers");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                users.add(new User(id, name, surname, email, password));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }

    public static User saveUser(User user) {
        User userResult = new User();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (NAME, SURNAME, EMAIL, PASSWORD) values (?, ?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userResult = getUser(user.getEmail());
    }

    public static User getUser(String emailSearch) {
        User user = new User();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM users where Email = '" + emailSearch + "' ;");

            while (rs.next()) {
                int id = rs.getInt("idusers");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                user.setId(id);
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(email);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return user;
    }

    public static void removeUserById(int id){
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users where idusers = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
