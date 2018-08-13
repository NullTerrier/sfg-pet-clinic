package services;
/*
 * @author Marecki
 */

import model.Owner;
import model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Owner owner);

    Set<Vet> findAll();
}
