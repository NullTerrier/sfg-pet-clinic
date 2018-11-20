package marek.makuch.sfgpetclinic.repositories;
/*
 * @author Marecki
 */

import marek.makuch.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
