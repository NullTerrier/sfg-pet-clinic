package services;
/*
 * @author Marecki
 */

import model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
