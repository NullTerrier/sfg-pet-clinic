package marek.makuch.sfgpetclinic.services.map;
/*
 * @author Marecki
 */

import marek.makuch.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;
import marek.makuch.sfgpetclinic.services.PetService;

import java.util.Set;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
