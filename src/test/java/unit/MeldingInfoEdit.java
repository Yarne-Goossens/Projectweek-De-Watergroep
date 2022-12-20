package unit;

import domain.model.Leak;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MeldingInfoEdit {
    private Leak leak;

    @Before
    public void setUp(){
        this.leak = new Leak(1,"Abdullah","Alrawe","a14alrawe@gmail.com","Leuven","4b","tiensestraat","",3000);

    }

    @Test
    public void given_location_is_given__then_leak_is_updated_and_other_info_are_kept(){
        leak.setCity("Brussel");
        leak.setPostal(1000);
        leak.setHouseNumber("12b");

        assertEquals(leak.getCity(),"Brussel");
        assertEquals(leak.getPostal(),1000);
        assertEquals(leak.getHouseNumber(),"12b");
        assertEquals(leak.getFirstname(),"Abdullah");

    }

    @Test
    public void given_comment_is_given__then_leak_is_updated_and_other_info_are_kept(){
       leak.setComment("Hello world");
        assertEquals(leak.getComment(),"Hello world");
        assertEquals(leak.getPostal(),3000);
    }

    @Test
    public void given_comment_is_empty__then_leak_is_updated_and_other_info_are_kept(){
        leak.setComment("");
        assertEquals(leak.getComment(),"");
        assertEquals(leak.getPostal(),3000);
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
        leak.setPostal(999);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_postal_is_5_digits_then_leak_is_not_updated(){
        leak.setPostal(10000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_firstname_is_changed_then_leak_is_not_updatedt(){
        leak.setFirstname("new name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_lastname_is_changed_then_leak_is_not_updatedt(){
        leak.setLastname("new last name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_email_is_changed_then_leak_is_not_updatedt(){
        leak.setEmail("new email");
    }
}

