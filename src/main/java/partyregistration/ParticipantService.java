package partyregistration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepo participantRepo;

    public boolean createParticipant(String phonenumber, String firstname, String lastname, String password, String gender) {
        String[] hashAndSalt = Utils.hashPassword(password, null);

        if (participantRepo.findByPhonenumber(phonenumber) != null) {
            return false;
        }

        participantRepo.save(new Participant(phonenumber, firstname, lastname, hashAndSalt[0], hashAndSalt[1], gender));
        return true;
    }

    public Participant getParticipant(String phonenumber) {
        return participantRepo.findByPhonenumber(phonenumber);
    }

    public List<Participant> getAllParticipants() {
        return participantRepo.findAllByOrderByFirstnameAscLastnameAsc();
    }

}
