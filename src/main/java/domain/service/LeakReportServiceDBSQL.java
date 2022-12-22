package domain.service;


import domain.model.LeakReport;
import domain.model.LeakStatus;
import util.DbConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeakReportServiceDBSQL implements LeakReportService {
    private Connection connection;
    private final String schema;

    public LeakReportServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public void addLeakReport(LeakReport leak) {
        String query = String.format("insert into %s.leak " + "(first_name,last_name,email,city,postal,street," +
                "house_number,comment,status) values (?,?,?,?,?,?,?,?,?)", schema);
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
            preparedStatement.setString(9, LeakStatus.OPEN.toString());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }




    @Override
    public LeakReport findLeakId(int id) {
        return null;

    }

    @Override
    public ArrayList<LeakReport> getAllLeakReports() {
        ArrayList<LeakReport> leakReports = new ArrayList<>();
        String sql = String.format("SELECT * FROM %s.leak order by id", schema);
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
                String houseNr = resultSet.getString("house_number");
                String comment = resultSet.getString("comment");
                int serviceAssignmentId = resultSet.getInt("service_id");
                String statusString = resultSet.getString("status");
                LeakReport leakReport = new LeakReport(id, postal, houseNr, firstName, lastName, email, city, street, serviceAssignmentId);
                leakReport.setComment(comment);
                leakReport.setStatus(LeakStatus.valueOf(statusString));
                leakReports.add(leakReport);
            }
            return leakReports;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public void updateLeak(LeakReport leak) {
        String query = String.format("UPDATE %s.leak SET city = ? , postal = ? , street = ? , house_number = ? , " +
                "comment = ?, service_id = ? where id = ?", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, leak.getCity());
            preparedStatement.setInt(2, leak.getPostalCode());
            preparedStatement.setString(3, leak.getStreet());
            preparedStatement.setString(4, leak.getHouseNumber());
            preparedStatement.setString(5, leak.getComment());
            preparedStatement.setInt(6, leak.getServiceAssignmentId());
            preparedStatement.setInt(7, leak.getId());
            preparedStatement.executeUpdate();
            System.out.println(leak);

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
            if (result.next()) {

                int id = result.getInt("id");
                String firstname = result.getString("first_name");
                String lastname = result.getString("last_name");
                String email = result.getString("email");
                String comment = result.getString("comment");
                String housenumber = result.getString("house_number");
                String city = result.getString("city");
                String street = result.getString("street");
                int postal = result.getInt("postal");
                int serviceAssignmentId = result.getInt("service_id");
                String statusString = result.getString("status");
                LeakReport report = new LeakReport(id, postal, housenumber, firstname, lastname, email, city, street, comment, serviceAssignmentId);
                report.setStatus(LeakStatus.valueOf(statusString));
                return report;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

            return null;

        }

    @Override
    public void updateLeakStatus(int id, LeakStatus status) {
        String sql = String.format("update %s.leak set status = ? where id = ?", schema);
        try {
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setString(1, status.toString());
            statement.setInt(2, id);
            statement.execute();
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
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

