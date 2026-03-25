package com.emp.dao;

import com.emp.model.Employee;
import com.emp.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // CREATE
    public void addEmployee(Employee emp) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO employee(name, email, salary) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setDouble(3, emp.getSalary());

            ps.executeUpdate();
            System.out.println("Employee Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM employee";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setEmail(rs.getString("email"));
                emp.setSalary(rs.getDouble("salary"));

                list.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    public void updateEmployee(int id, double salary) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE employee SET salary=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Employee Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteEmployee(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM employee WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Employee Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}