package services;
/*
 * @author Marecki
 */

import model.Owner;
import model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Owner owner);

    Set<Pet> findAll();
}
