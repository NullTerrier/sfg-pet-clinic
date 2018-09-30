package marek.makuch.sfgpetclinic.services.map;
/*
 * @author Marecki
 */

import marek.makuch.sfgpetclinic.model.Owner;
import marek.makuch.sfgpetclinic.model.Pet;
import marek.makuch.sfgpetclinic.services.PetService;
import marek.makuch.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;
import marek.makuch.sfgpetclinic.services.OwnerService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {

            if (object.getPets() != null) {

                object.getPets().stream().filter(pet -> pet == null).forEach(pet -> {

                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }

                        if (pet.getId() == null) {
                            Pet savedPet = petService.save(pet);
                            pet.setId(savedPet.getId());
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required for Pet");
                    }


                });
            }


            return super.save(object);

        } else {
            return null;
        }

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        List<Map.Entry<Long, Owner>> found = super.map.entrySet().stream()
                .filter(e -> e.getValue().getLastName().equals(lastName))
                .collect(Collectors.toList());
        return (Owner) found.get(0);
    }
}
