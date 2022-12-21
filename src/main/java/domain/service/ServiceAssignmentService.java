package domain.service;

import domain.model.ServiceAssignment;

import java.util.ArrayList;

public interface ServiceAssignmentService {

    void addServiceAssignment(ServiceAssignment serviceAssignment);

    ServiceAssignment findServiceAssignmentById(int id);

    ArrayList<ServiceAssignment> getAllServiceAssignments();

    void updateServiceAssignment(ServiceAssignment serviceAssignment);
}
