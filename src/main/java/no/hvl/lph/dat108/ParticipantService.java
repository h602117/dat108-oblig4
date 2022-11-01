package no.hvl.lph.dat108;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepo participantRepo;

    public void createParticipant(String firstname, String lastname, String phonenumber, String password, String gender) {
        participantRepo.save(new Participant(firstname, lastname, phonenumber, password, gender));
    }

    public List<Participant> getAllParticipants() {
        return participantRepo.findAll();
    }

}
