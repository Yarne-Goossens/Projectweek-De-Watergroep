package domain.service;

import domain.model.*;

import java.util.ArrayList;

public class AppService {
    private LeakReportService leakReport = new LeakReportServiceDBSQL();
    private EmailService emailService = new MailService();
    private AnimalService animals = new AnimalServiceDBSQL();
    private EmployeeService employees = new EmployeeServiceDBSQL();

    public void addLeakReport(LeakReport leak) {
        leakReport.addLeakReport(leak);
    }

    public Animal findLeakWithReport(String naam) {
        return animals.findAnimalWithName(naam);
    }

    public ArrayList<LeakReport> getAllLeaks() {
        return leakReport.getAllLeakReports();
    }



    public void addAnimal(Animal animal) {
        animals.addAnimal(animal);
    }



    public Animal findAnimalWithName(String naam) {
        return animals.findAnimalWithName(naam);
    }


    public void sendEmail(Email email) {
        emailService.sendEmail(email);
    }


    // userService
    public void addEmployee(Employee employee) {
        employees.addEmployee(employee);
    }

    public Employee findEmployeeWithEmail(String email) {
        return employees.findEmployeeWithEmail(email);
    }

    //Leak
    public void updateLeak(LeakReport leak) {
       leakReport.updateLeak(leak);
    }

    public ArrayList<Employee> getAllEmployees() {
        return employees.getAllEmployees();
    }

    public LeakReport getLeakFromId(int id){
       return leakReport.getLeakFromId(id);
    }

    // ServiceAssignmentService

    private ServiceAssignmentService serviceAssignmentService = new ServiceAssignmentServiceDBSQL();

    public void addServiceAssignment(ServiceAssignment serviceAssignment){
        serviceAssignmentService.addServiceAssignment(serviceAssignment);
    }

    public ArrayList getLeakAssignedToSOFromId(int serviceId){
        return serviceAssignmentService.getLeakAssignedToSOFromId(serviceId);
    }

    public ServiceAssignment findServiceAssignmentWithId(int id) {
        return serviceAssignmentService.findServiceAssignmentById(id);
    }
    public void updateServiceAssignment(ServiceAssignment serviceAssignment) {
        serviceAssignmentService.updateServiceAssignment(serviceAssignment);
    }

    public ArrayList<ServiceAssignment> getAllServiceAssignments(){
        return serviceAssignmentService.getAllServiceAssignments();
    }

    public  void closeAssignment(ServiceAssignment serviceAssignment){
        serviceAssignmentService.closeAssignment(serviceAssignment);
    }

    public int findIdFromAssignment(ServiceAssignment newAssignment) {
        return serviceAssignmentService.findIdFromAssignment(newAssignment);
    }
}


