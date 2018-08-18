package marek.makuch.sfgpetclinic.services;
/*
 * @author Marecki
 */

import marek.makuch.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
