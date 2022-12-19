package domain.service;

import domain.model.Employee;
import util.DbConnectionService;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeServiceDBSQL implements EmployeeService {

    private final Connection connection;
    private final String schema;

    public EmployeeServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public void addEmployee(Employee employee) {
        String query = String.format("insert into %s.employee (name,email,password) values (?,?,?)", schema);
        try{
            PreparedStatement sql = getConnection().prepareStatement(query);
            sql.setString(1, employee.getName());
            sql.setString(2, employee.getEmail());
            sql.setString(3, employee.getPassword());
            sql.execute();
        } catch (SQLException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Employee findEmployeeWithEmail(String email) {
        String query = String.format("select * from %s.employee where email=?", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setString(1, email);
            ResultSet result =  statement.executeQuery();
            while (result.next()){
                String nameString = result.getString("name");
                String mailString = result.getString("email");
                String passwordString = result.getString("password");
                return new Employee(nameString, mailString, passwordString);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Employee> getAllEmployees() {
        return null;
    }

    /**
     * Check the connection and reconnect when necessary
     * @return the connection with the db, if there is one
     */
    private Connection getConnection() {
        return this.connection;
    }
}
