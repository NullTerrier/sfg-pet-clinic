package marek.makuch.sfgpetclinic.repositories;
/*
 * @author Marecki
 */

import marek.makuch.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
