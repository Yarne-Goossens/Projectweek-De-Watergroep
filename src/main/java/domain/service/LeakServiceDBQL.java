package domain.service;

import domain.model.Leak;
import util.DbConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeakServiceDBQL implements LeakService{
    private final Connection connection;
    private final String schema;

    public LeakServiceDBQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public void update(Leak leak) {
        String query = String.format("UPDATE %s.leak SET first_name = ? , last_name = ? , email= ? , city = ? , postal =? , street = ? , house_number = ? , comment =? where id = ?", schema);
        try{
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, leak.getFirstname());
            preparedStatement.setString(2, leak.getLastname());
            preparedStatement.setString(3, leak.getEmail());
            preparedStatement.setString(4,leak.getCity());
            preparedStatement.setInt(5,leak.getPostal());
            preparedStatement.setString(6,leak.getStreet());
            preparedStatement.setString(7,leak.getHouseNumber());
            preparedStatement.setString(7,leak.getComment());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
          throw new DbException(e.getMessage());
        }
    }


    private Connection getConnection() {
        return this.connection;
    }
}
