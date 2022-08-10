package emailapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailTest {

    private Email email;

    @BeforeEach
    void setUp() {
        email = new Email("John", "Smith", "0000000000", "dev");
    }

    @Test
    void setMailboxCapacity() {
        email.setMailboxCapacity(1000);
        assertEquals(1000, email.getMailboxCapacity());
    }

    @Test
    void setAlternateEmail() {
        email.setAlternateEmail("john.smith@imaginationmail.com");
        assertEquals("john.smith@imaginationmail.com", email.getAlternateEmail());
    }

    @Test
    void showInfo() {
        String expected = "Info: firstName='John', lastName='Smith', email='john.smith@dev.company.com', mailboxCapacity=500";
        assertEquals(expected, email.showInfo());
    }

}