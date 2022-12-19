package domain.service;

import domain.model.Animal;
import domain.model.Email;

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


    // emailService
    private EmailService emailService = new MailService();
    public void sendEmail(Email email){
        emailService.sendEmail(email);
    }

    // userService
    private UserService users = new UserServiceInMemory();


}
