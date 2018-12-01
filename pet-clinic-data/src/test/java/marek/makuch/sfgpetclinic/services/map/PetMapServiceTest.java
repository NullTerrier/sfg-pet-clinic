package marek.makuch.sfgpetclinic.services.map;

import marek.makuch.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * @author Marecki
 */

class PetMapServiceTest {

    PetMapService petMapService;

    private final String FAFIK ="Fafik";
    final Long ID = 1L;


    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petMapService.save(Pet.builder().id(ID).name(FAFIK).build());
    }

    @Test
    void findAll() {
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void findById() {
        final Pet byId = petMapService.findById(ID);
        assertNotNull(byId);
        assertEquals(ID, byId.getId());
    }

    @Test
    void save() {
        final long PET_ID = 2L;
        final Pet pet = petMapService.save(Pet.builder().id(PET_ID).build());
        assertEquals(2, petMapService.findAll().size());
        assertNotNull(petMapService.findById(PET_ID));

    }

    @Test
    void delete() {
        petMapService.delete(petMapService.findById(ID));
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteById() {
        petMapService.deleteById(ID);
        assertEquals(0, petMapService.findAll().size());
    }
}