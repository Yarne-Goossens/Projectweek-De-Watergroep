package unit.LeakSubmission;

import domain.model.LeakReport;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeakSubmissionTest {
    private LeakReport leak;

    @Before
    public void setLeak() {
        leak = new LeakReport();
    }

    @Test
    public void test_first_name_is_empty() {
        try {
            leak.setFirstName("");
        } catch (IllegalArgumentException e) {
            assertEquals("Vul een voornaam in.", e.getMessage());
        }
    }

    @Test
    public void test_email_is_not_valid() {
        try {
            leak.setEmail("david.vandebroeck");
        } catch (IllegalArgumentException e) {
            assertEquals("Geef een geldige email in.", e.getMessage());
        }
    }

    @Test
    public void test_postal_code_is_invalid() {
        try {
            leak.setPostalCode(365005);
        } catch (IllegalArgumentException e) {
            assertEquals("Postcode is niet geldig", e.getMessage());
        }
    }
}