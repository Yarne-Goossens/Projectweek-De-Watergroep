package domain.service;

import domain.model.Animal;
import domain.model.LeakReport;

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

    public ArrayList<Animal> getAllLeaks() {
        return animals.getAllAnimals();
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


    // userService
    private UserService users = new UserServiceInMemory();




}
