package cs2031.utec.edu.pe.repositories;

import cs2031.utec.edu.pe.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
