package domain.service;

import domain.model.Employee;
import domain.model.EmployeeType;
import util.DbConnectionService;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeServiceDBSQL implements EmployeeService {

    private Connection connection;
    private final String schema;

    public EmployeeServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public void addEmployee(Employee employee) {
        String query = String.format("insert into %s.employee (name,email,password,type) values (?,?,?,?)", schema);
        try{
            PreparedStatement sql = getPreparedStatement(query);
            sql.setString(1, employee.getName());
            sql.setString(2, employee.getEmail());
            sql.setString(3, employee.getPassword());
            sql.setString(4, employee.getType().toString());
            sql.execute();
        } catch (SQLException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Employee findEmployeeWithEmail(String email) {
        String query = String.format("select * from %s.employee where email=?", schema);
        try {
            PreparedStatement statement = getPreparedStatement(query);
            statement.setString(1, email);
            ResultSet result =  statement.executeQuery();
            while (result.next()){
                int id  = result.getInt("id");
                String nameString = result.getString("name");
                String mailString = result.getString("email");
                String passwordString = result.getString("password");
                EmployeeType type = EmployeeType.valueOf(result.getString("type"));
                return new Employee(id,nameString, mailString, passwordString, type);
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
        checkConnection();
        return this.connection;
    }

    /**
     * Check if the connection is still open
     * When connection has been closed: reconnect
     */
    private void checkConnection() {
        try {
            if (this.connection == null || this.connection.isClosed()) {
                System.out.println("Connection has been closed");
                this.reConnect();
            }
        } catch (SQLException throwables) {
            throw new ServiceException(throwables.getMessage());
        }
    }

    /**
     * Reconnects application to db
     */
    private void reConnect() {
        if (this.connection != null) {
            DbConnectionService.disconnect();   // close connection with db properly
        }
        DbConnectionService.reconnect();      // reconnect application to db server
        this.connection = DbConnectionService.getDbConnection();    // assign connection to DBSQL
    }
    /**
     * Prepare Statement
     */
    private PreparedStatement getPreparedStatement(String sql) throws SQLException {

        return getConnection().prepareStatement(sql);
    }
}
