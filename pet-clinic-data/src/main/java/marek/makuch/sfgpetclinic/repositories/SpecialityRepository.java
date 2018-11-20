package marek.makuch.sfgpetclinic.repositories;
/*
 * @author Marecki
 */

import marek.makuch.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
