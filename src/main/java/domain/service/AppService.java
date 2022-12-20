package domain.service;

import domain.model.*;

import java.util.ArrayList;

public class AppService {
    //LEAKS
    private LeakReportService leakReport = new LeakReportServiceDBSQL();

    public void addLeakReport(LeakReport leak) {
        leakReport.addLeakReport(leak);
    }

    public Animal findLeakWithReport(String naam) {
        return animals.findAnimalWithName(naam);
    }

    public ArrayList<LeakReport> getAllLeaks() {
        return leakReport.getAllLeakReports();
    }

    // currentAnimalService
    private AnimalService animals = new AnimalServiceDBSQL();

    public void addAnimal(Animal animal) {
        animals.addAnimal(animal);
    }

    public Animal findAnimalWithName(String naam) {
        return animals.findAnimalWithName(naam);
    }

    public ArrayList<Animal> getAllAnimals() {
        return animals.getAllAnimals();
    }


    // emailService
    private EmailService emailService = new MailService();
    public void sendEmail(Email email){
        emailService.sendEmail(email);
    }

    // employeeService
    private EmployeeService employees = new EmployeeServiceDBSQL();

    public void addEmployee(Employee employee) {
        employees.addEmployee(employee);
    }

    public Employee findEmployeeWithEmail(String email){
        return employees.findEmployeeWithEmail(email);
    }

    public ArrayList<Employee> getAllEmployees() {
        return employees.getAllEmployees();
    }

    // ServiceAssignmentService

    private ServiceAssignmentService serviceAssignmentService = new ServiceAssignmentServiceDBSQL();

    public void addServiceAssignment(ServiceAssignment serviceAssignment){
        serviceAssignmentService.addServiceAssignment(serviceAssignment);
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
}
