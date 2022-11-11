package partyregistration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Testing {

    private Validator v = Validation.buildDefaultValidatorFactory().getValidator();

    @InjectMocks
    ParticipantService service;

    @Mock
    ParticipantRepo repo;

    @Test
    void testFindByPhonenumber() {
        when(repo.findByPhonenumber("12341234")).thenReturn(new Participant("12341234", "Test", "Testesen", "dsadsadadsdsa", "dsadsadsadsa", "M"));

        Participant p = service.getParticipant("12341234");

        assertEquals(p.getPhonenumber(), "12341234");
    }

    @Test
    public void testValidatePasswordCorrect() {
        String[] hashAndSalt = Utils.hashPassword("password", "1234567887654321");
        assertTrue(Utils.validatePassword("password", hashAndSalt[0], hashAndSalt[1]));
    }

    @Test
    public void testValidatePasswordWrong() {
        String[] hashAndSalt = Utils.hashPassword("password", "1234567887654321");
        assertFalse(Utils.validatePassword("drowssap", hashAndSalt[0], hashAndSalt[1]));
    }

    @Test
    public void testValidatePasswordDifferentSalt() {
        String[] hashAndSalt = Utils.hashPassword("password", "1234567887654321");
        assertFalse(Utils.validatePassword("password", hashAndSalt[0], "8765432112345678"));
    }

    @Test
    public void testCreateParticipantCorrect() {
        Participant p = new Participant("12341234", "Test", "Testesen", "dsadsadadsdsa", "dsadsadsadsa", "M");
        Set<ConstraintViolation<Participant>> violations = v.validate(p);
        assertTrue(violations.size() == 0);
    }

    @Test
    public void testCreateParticipantWrong() {
        Participant p = new Participant("Not a number", "not uppercase", "Has space", null, null, "A");
        Set<ConstraintViolation<Participant>> violations = v.validate(p);
        assertTrue(violations.size() != 0);
    }


}
