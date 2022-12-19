package domain.service;

import domain.model.Animal;
import domain.model.Employee;

import java.util.ArrayList;

public class AppService {

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


    // userService
    private EmployeeService employees = new EmployeeServiceDBSQL();

    public void addUser(Employee employee) {
        employees.addEmployee(employee);
    }

    public Employee findUserWithEmail(String email){
        return employees.findEmployeeWithEmail(email);
    }

    public ArrayList<Employee> getAllUsers() {
        return employees.getAllEmployees();
    }
}
