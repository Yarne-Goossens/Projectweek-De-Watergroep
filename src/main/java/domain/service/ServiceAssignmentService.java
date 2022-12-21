package domain.service;

import domain.model.ServiceAssignment;

import java.util.ArrayList;

public interface ServiceAssignmentService {

    void addServiceAssignment(ServiceAssignment serviceAssignment);

    ServiceAssignment findServiceAssignmentById(int id);


    void closeAssignment(ServiceAssignment serviceAssignment);

    ArrayList<ServiceAssignment> getAllServiceAssignments();

    void updateServiceAssignment(ServiceAssignment serviceAssignment);
}
