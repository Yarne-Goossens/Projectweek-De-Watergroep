package domain.service;

import domain.model.AssignmentType;
import domain.model.Employee;
import domain.model.EmployeeType;
import domain.model.ServiceAssignment;
import util.DbConnectionService;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ServiceAssignmentServiceDBSQL implements ServiceAssignmentService{

    private final Connection connection;
    private final String schema;

    public ServiceAssignmentServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public void addServiceAssignment(ServiceAssignment serviceAssignment) {
        String query = String.format("insert into %s.service_assignment (city, postal, street, house_number, type, start_date, comment) values (?,?,?,?,?,?,?)", schema);
        try{
            PreparedStatement sql = getConnection().prepareStatement(query);
            sql.setString(1, serviceAssignment.getCity());
            sql.setString(2, String.valueOf(serviceAssignment.getPostalCode()));
            sql.setString(3, serviceAssignment.getStreet());
            sql.setString(4, serviceAssignment.getHouseNumber());
            sql.setString(5, serviceAssignment.getType().toString());
            sql.setDate(6, Date.valueOf(serviceAssignment.getStartDate()));
            sql.setString(7, serviceAssignment.getComment());
            sql.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public ServiceAssignment findServiceAssignmentById(int findId) {
        String querry = "select " +
                "s.id,city,postal,street,house_number,technician, " +
                "s.type as service_type, start_date, end_date, comment, " +
                "e.id as technician_id, name, email, password, e.type as employee_type  " +
                "from %s.service_assignment as s " +
                "left outer join %s.employee as e on s.technician_id = e.id " +
                "where s.id = ? ";
        querry = String.format(querry,schema,schema);
        ServiceAssignment serviceAssignment = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, findId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String city = resultSet.getString("city");
                int postal = resultSet.getInt("postal");
                String street = resultSet.getString("street");
                String houseNumber = resultSet.getString("house_number");
                int technicianId = resultSet.getInt("technician_id");
                AssignmentType type = AssignmentType.valueOf(resultSet.getString("service_type").toUpperCase());
                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                LocalDate endDate;
                try {
                    endDate = resultSet.getDate("end_date").toLocalDate();
                } catch (NullPointerException e) {
                    endDate = null;
                }
                String comment = resultSet.getString("comment");
                String naamTechnician = resultSet.getString("name");
                String emailTechnician = resultSet.getString("email");
                String passwordTechnician = resultSet.getString("password");
                String typeTechnician = resultSet.getString("employee_type");

                Employee technician;
                if (naamTechnician == null) {
                    technician = null;
                } else technician = new Employee(technicianId,naamTechnician,emailTechnician,passwordTechnician, EmployeeType.valueOf(typeTechnician.toUpperCase()));

                serviceAssignment = new ServiceAssignment(id, city, postal, street, houseNumber, type, startDate, endDate, comment, technician);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return serviceAssignment;
    }

    @Override
    public void closeAssignment(ServiceAssignment serviceAssignment) {
        String querry = "UPDATE %s.service_assignment SET end_date = ?  WHERE id = ? ";
        querry = String.format(querry,schema);
        try{
            PreparedStatement preparedStatement = getConnection().prepareStatement(querry);
            preparedStatement.setDate(1, Date.valueOf(LocalDate.now()));
            preparedStatement.setInt(2, serviceAssignment.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    @Override
    public ArrayList<ServiceAssignment> getAllServiceAssignments() {
        ArrayList<ServiceAssignment> serviceAssignments = new ArrayList<>();
        String querry = "select " +
                "s.id,city,postal,street,house_number,technician, " +
                "s.type as service_type, start_date, end_date, comment, " +
                "e.id as technician_id, name, email, password, e.type as employee_type " +
                "from %s.service_assignment as s " +
                "left outer join %s.employee as e on s.technician_id = e.id ";
        querry = String.format(querry,schema,schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String city = resultSet.getString("city");
                int postal = resultSet.getInt("postal");
                String street = resultSet.getString("street");
                String houseNumber = resultSet.getString("house_number");
                int technicianId = resultSet.getInt("technician_id");
                AssignmentType type = AssignmentType.valueOf(resultSet.getString("service_type").toUpperCase());
                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                LocalDate endDate;
                try {
                    endDate = resultSet.getDate("end_date").toLocalDate();
                } catch (NullPointerException e) {
                    endDate = null;
                }
                String comment = resultSet.getString("comment");


                String naamTechnician = resultSet.getString("name");
                String emailTechnician = resultSet.getString("email");
                String passwordTechnician = resultSet.getString("password");
                String typeTechnician = resultSet.getString("employee_type");

                Employee technician;
                if (naamTechnician == null) {
                    technician = null;
                } else technician = new Employee(technicianId,naamTechnician,emailTechnician,passwordTechnician, EmployeeType.valueOf(typeTechnician.toUpperCase()));

                ServiceAssignment serviceAssignment = new ServiceAssignment(id, city, postal, street, houseNumber, type, startDate, endDate, comment, technician);
                serviceAssignments.add(serviceAssignment);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return serviceAssignments;
    }

    @Override
    public void updateServiceAssignment(ServiceAssignment serviceAssignment) {
        String querry = "UPDATE %s.service_assignment " +
                "SET city = ?, postal = ?, " +
                "street = ?, house_number = ?, " +
                "technician_id = ?, type = ?, start_date = ?, " +
                "end_date = ?, comment = ? " +
                "WHERE id = ? ";
        String query = String.format(querry,schema);
        try{
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, serviceAssignment.getCity());
            preparedStatement.setString(2, String.valueOf(serviceAssignment.getPostalCode()));
            preparedStatement.setString(3, serviceAssignment.getStreet());
            preparedStatement.setString(4, serviceAssignment.getHouseNumber());
            preparedStatement.setInt(5, serviceAssignment.getTechnician().getId());
            preparedStatement.setString(6, serviceAssignment.getType().toString().toUpperCase());
            preparedStatement.setDate(7, Date.valueOf(serviceAssignment.getStartDate()));
            if (serviceAssignment.getEndDate()==null) {
                preparedStatement.setDate(8, null);
            } else {
                preparedStatement.setDate(8, Date.valueOf(serviceAssignment.getEndDate()));
            }
            preparedStatement.setString(9, serviceAssignment.getComment());
            preparedStatement.setInt(10, serviceAssignment.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    /**
     * Check the connection and reconnect when necessary
     * @return the connection with the db, if there is one
     */
    private Connection getConnection() {
        return this.connection;
    }
}
