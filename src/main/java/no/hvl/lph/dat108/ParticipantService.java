package no.hvl.lph.dat108;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepo participantRepo;

    public void createParticipant(String phonenumber, String firstname, String lastname, String password, String gender) {
        String[] hashAndSalt = Utils.hashPassword(password, null);
        participantRepo.save(new Participant(phonenumber, firstname, lastname, hashAndSalt[0], hashAndSalt[1], gender));
    }

    public Participant getParticipant(String phonenumber) {
        return participantRepo.findByPhonenumber(phonenumber);
    }

    public List<Participant> getAllParticipants() {
        return participantRepo.findAll();
    }

}
