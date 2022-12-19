package domain.service;

import domain.model.User;

import java.util.ArrayList;

public class UserServiceInMemory implements UserService{

    private int id=0;
    private ArrayList<User> users = new ArrayList<>();

    public UserServiceInMemory(){
        this.addUser(new User(id, "Jan-Willem", "jw@wg.be", "pwd"));
        this.addUser(new User(id, "Yannick", "yv@wg.be", "psw"));
    }

    @Override
    public void addUser(User user) {
        users.add(user);
        id++;
    }

    @Override
    public User findUserWithEmail(String name) {
        for(User u : users){
            if(u.getName().equals(name)){
                return u;
            }
        }
        return null;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return users;
    }
}
