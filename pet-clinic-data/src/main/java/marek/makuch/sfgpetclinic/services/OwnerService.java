package marek.makuch.sfgpetclinic.services;
/*
 * @author Marecki
 */

import marek.makuch.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
