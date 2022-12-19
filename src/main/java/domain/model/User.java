package domain.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Geen naam gegeven");
        }
        this.name=name;
    }

    private void setEmail(String email){
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Geen email gegeven");
        }
        String USERID_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(USERID_PATTERN);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new IllegalArgumentException("Email is niet correct");
        }
        this.email=email;
    }

    private void setPassword(String password){
        if (password.isEmpty())
            throw new IllegalArgumentException("Geen paswoord gegeven");
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
