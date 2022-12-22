package unit;

import static org.junit.Assert.*;

import domain.model.LeakReport;
import org.junit.Before;
import org.junit.Test;

public class MeldingInfoEdit {

    private LeakReport leak;

    @Before
    public void setUp(){
        this.leak = new LeakReport(1,3000,"4b","Abdullah","Alrawe","a14alrawe@gmail.com","Leuven","tiensestraat","Some comment",0);

    }

    @Test
    public void given_location_is_given__then_leak_is_updated_and_other_info_are_kept(){
        leak.setCity("Brussel");
        leak.setPostalCode(1000);
        leak.setHouseNumber("12b");

        assertEquals(leak.getCity(),"Brussel");
        assertEquals(leak.getPostalCode(),1000);
        assertEquals(leak.getHouseNumber(),"12b");
        assertEquals(leak.getFirstName(),"Abdullah");

    }

    @Test
    public void given_comment_is_given__then_leak_is_updated_and_other_info_are_kept(){
       leak.setComment("Hello world");
        assertEquals(leak.getComment(),"Hello world");
        assertEquals(leak.getPostalCode(),3000);
    }

    @Test
    public void given_comment_is_empty__then_leak_is_updated_and_other_info_are_kept(){
        leak.setComment("");
        assertEquals(leak.getComment(),"");
        assertEquals(leak.getPostalCode(),3000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_city_is_empty__then_leak_is_not_updated(){
        leak.setCity("");

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_houseNumber_is_empty__then_leak_is_not_updated(){
        leak.setHouseNumber("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_postal_is_3_digits_then_leak_is_not_updated(){
        leak.setPostalCode(999);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_postal_is_5_digits_then_leak_is_not_updated(){
        leak.setPostalCode(10000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_firstname_is_changed_then_leak_is_not_updatedt(){
        leak.setFirstName("new name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_lastname_is_changed_then_leak_is_not_updatedt(){
        leak.setLastName("new last name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_email_is_changed_then_leak_is_not_updatedt(){
        leak.setEmail("new email");
    }
}

