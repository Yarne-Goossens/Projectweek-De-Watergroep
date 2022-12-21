package domain.model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {

    private int id;
    private String name;
    private String email;
    private String password;
    private EmployeeType type;

    public Employee(String name, String email, String password, EmployeeType type){
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setType(type);
    }

    public Employee(int id, String name, String email, String password, EmployeeType type){
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setType(type);
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

    public boolean isCorrectPassword(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return this.password.equals(hashPassword(password));
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){return this.email;}

    public String getPassword() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return hashPassword(this.password);
    }

    public String hashPassword(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //create MessageDigest
        MessageDigest crypt = MessageDigest.getInstance("SHA-512");
        //reset
        crypt.reset();
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        crypt.update(passwordBytes);
        //digest
        byte[] digest = crypt.digest();
        //convert to String
        BigInteger digestAsBigInteger = new BigInteger(1, digest);
        //return hashed password
        return digestAsBigInteger.toString(16);
    }

    private void setType(EmployeeType type){
        this.type=type;
    }

    public EmployeeType getType(){
        return this.type;
    }

    public int getId() {
        return id;
    }
}
