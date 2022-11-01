package no.hvl.lph.dat108;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepo extends JpaRepository<Participant, Integer> {

    public Participant findByPhonenumber(String phonenumber);

}