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

    }



    @Override
    public ArrayList<LeakReport> getAllLeakReports() {
        ArrayList<LeakReport> leakReports = new ArrayList<>();
        String sql = String.format("SELECT * FROM %s.leak", schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String city = resultSet.getString("city");
                int postal = Integer.parseInt(resultSet.getString("postal"));
                String street = resultSet.getString("street");
                String  houseNr = resultSet.getString("house_number");
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


    @Override
    public void updateLeak(LeakReport leak) {
        String query = String.format("UPDATE %s.leak SET city = ? , postal = ? , street = ? , house_number = ? , comment =? where id = ?", schema);
        try{
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1,leak.getCity());
            preparedStatement.setInt(2,leak.getPostalCode());
            preparedStatement.setString(3,leak.getStreet());
            preparedStatement.setString(4,leak.getHouseNumber());
            preparedStatement.setString(5,leak.getComment());
            preparedStatement.setInt(6,leak.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public LeakReport getLeakFromId(int idleak) {
            String sql = String.format("SELECT * from %s.leak WHERE id = ?;", schema);
            try {
                PreparedStatement statement = getConnection().prepareStatement(sql);
                statement.setInt(1, idleak);
                ResultSet result = statement.executeQuery();
                if(result.next()){

                    int id = result.getInt("id");
                    String firstname = result.getString("first_name");
                    String lastname = result.getString("last_name");
                    String email = result.getString("email");
                    String comment = result.getString("comment");
                    String housenumber = result.getString("house_number");
                    String city = result.getString("city");
                    String street = result.getString("street");
                    int postal = result.getInt("postal");


                    return new LeakReport(id,postal,housenumber,firstname,lastname,email,city,street,comment);
                }
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        return null;

    }


    private Connection getConnection() {
        return this.connection;
    }
}
