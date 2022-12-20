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
        String query = String.format("insert into %s.animal " +
                "(id,first_name,last_name,email,city,postal,street,house_number,comment) values (?,?,?,?,?,?,?,?,?)", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, leak.getId());
            preparedStatement.setString(2, leak.getFirstName());
            preparedStatement.setString(3, leak.getLastName());
            preparedStatement.setString(4, leak.getEmail());
            preparedStatement.setString(5, leak.getCity());
            preparedStatement.setInt(6, leak.getPostalCode());
            preparedStatement.setString(7, leak.getStreet());
            preparedStatement.setInt(8, leak.getHouseNumber());
            preparedStatement.setString(9, leak.getComment());


            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Animal findLeakId(int id) {
        return null;
    }

    @Override
    public ArrayList<LeakReport> getAllLeakReports() {
        ArrayList<LeakReport> leakReports = new ArrayList<>();
        String sql = String.format("SELECT * FROM %s.leak", schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String city = resultSet.getString("city");
                int postal = Integer.parseInt(resultSet.getString("postal"));
                String street = resultSet.getString("street");
                int houseNr = Integer.parseInt(resultSet.getString("house_number"));
                String comment = resultSet.getString("comment");
                LeakReport leakReport = new LeakReport(id,postal,houseNr,firstName,lastName,email,city,street);
                leakReport.setComment(comment);
                leakReports.add(leakReport);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return leakReports;
    }

    private Connection getConnection() {
        return this.connection;
    }
}
