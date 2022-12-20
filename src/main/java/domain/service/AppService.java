package domain.service;

import domain.model.Animal;
import domain.model.Email;
import domain.model.Leak;

import java.util.ArrayList;

public class AppService {

    // currentAnimalService
    private AnimalService animals = new AnimalServiceDBSQL();
    private EmailService emailService = new MailService();
    public void addAnimal(Animal animal) {
        animals.addAnimal(animal);
    }
    public LeakService leakService = new LeakServiceDBQL();

    public Animal findAnimalWithName(String naam) {
        return animals.findAnimalWithName(naam);
    }

    public ArrayList<Animal> getAllAnimals() {
        return animals.getAllAnimals();
    }


    public void sendEmail(Email email){
        emailService.sendEmail(email);
    }


    // userService
    private UserService users = new UserServiceInMemory();



    //Leak
    public void updateLeak(Leak leak){
        leakService.update(leak);
    }




}
