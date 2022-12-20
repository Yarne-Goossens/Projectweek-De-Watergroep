package domain.service;

import domain.model.ServiceAssignment;

import java.util.ArrayList;

public interface ServiceAssignmentService {

    void addServiceAssignment(ServiceAssignment serviceAssignment);

    ServiceAssignment findServiceAssignmentBy();

    ArrayList<ServiceAssignment> getAllServiceAssignments();
}
