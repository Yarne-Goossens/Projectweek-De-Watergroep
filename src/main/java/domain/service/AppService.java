package domain.service;

import domain.model.Animal;
import domain.model.LeakReport;
import domain.model.Employee;
import domain.model.Email;
import domain.model.Leak;

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


    public ArrayList<Animal> getAllAnimals() {
        return animals.getAllAnimals();
    }

    public LeakReport getLeakFromId(int id){
       return leakReport.getLeakFromId(id);
    }

}


