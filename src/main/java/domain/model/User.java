package domain.model;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;

    public User(int id, String name, String email, String password){
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
    }

    private void setId(int id){
        this.id=id;
    }

    private void setName(String name){
        this.name=name;
    }

    private void setEmail(String email){
        this.email=email;
    }

    private void setPassword(String password){
        this.password=password;
    }

    public boolean isCorrectPassword(String password){
        return this.password.equals(password);
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){return this.email;}
}
