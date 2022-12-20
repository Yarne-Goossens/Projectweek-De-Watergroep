package unit.login;

import domain.model.Employee;
import domain.model.EmployeeType;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;


public class EmployeeTest {

    private Employee dave;

    @Before
    public void setDave(){
        dave = new Employee("Dave", "dave@wg.be", "pwd", EmployeeType.valueOf("KCC"));
    }

    @Test
    public void test_if_password_is_encrypted() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        assertEquals(dave.getPassword(), dave.hashPassword("pwd"));
    }

    @Test
    public void test_if_email_is_correct(){
        Employee jos = new Employee("Jos", "jan-willem.curinckx@gmail.com", "pwd", EmployeeType.valueOf("TECHNICIAN"));
        System.out.println(jos.getEmail());
        System.out.println(jos.getType().getStringValue());
    }
}
