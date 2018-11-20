package marek.makuch.sfgpetclinic.repositories;
/*
 * @author Marecki
 */

import marek.makuch.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
