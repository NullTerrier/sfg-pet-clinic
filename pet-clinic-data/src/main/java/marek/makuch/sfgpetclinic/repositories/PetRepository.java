package marek.makuch.sfgpetclinic.repositories;
/*
 * @author Marecki
 */

import marek.makuch.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
