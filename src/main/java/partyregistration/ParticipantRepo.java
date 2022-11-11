package partyregistration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepo extends JpaRepository<Participant, Integer> {

    public Participant findByPhonenumber(String phonenumber);

    public List<Participant> findAllByOrderByFirstnameAscLastnameAsc();

}
