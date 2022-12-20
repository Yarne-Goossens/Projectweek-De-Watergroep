package domain.service;

import domain.model.Animal;
import domain.model.LeakReport;
import util.DbConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeakReportServiceDBSQL implements LeakReportService{
    private final Connection connection;
    private final String schema;

    public LeakReportServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public void addLeakReport(LeakReport leak) {
        String query = String.format("insert into %s.leak " +
                "(first_name,last_name,email,city,postal,street,house_number,comment) values (?,?,?,?,?,?,?,?)", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, leak.getFirstName());
            preparedStatement.setString(2, leak.getLastName());
            preparedStatement.setString(3, leak.getEmail());
            preparedStatement.setString(4, leak.getCity());
            preparedStatement.setString(5, String.valueOf(leak.getPostalCode()));
            preparedStatement.setString(6, leak.getStreet());
            preparedStatement.setString(7, String.valueOf(leak.getHouseNumber()));
            preparedStatement.setString(8, leak.getComment());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Animal findLeakId(int id) {
        return null;
    }

    @Override
    public ArrayList<LeakReport> getAllLeakReports() {
        return null;
    }

    //@Override
    /*public ArrayList<LeakReport> getAllLeakReports() {
        ArrayList<LeakReport> leaks = new ArrayList<>();
        String sql = String.format("SELECT * from %s.leak", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String type = result.getString("type");
                int food = result.getInt("food");
                int id = result.getInt("id");
                String name = result.getString("name");
                String type = result.getString("type");
                int food = result.getInt("food");
                int food = result.getInt("food");
                leaks.add(new LeakReport(id, name, type, food));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return animals;
    }*/

    private Connection getConnection() {
        return this.connection;
    }
}
