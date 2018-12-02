package marek.makuch.sfgpetclinic.services.springdatajpa;

import marek.makuch.sfgpetclinic.model.Pet;
import marek.makuch.sfgpetclinic.repositories.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
 * @author Marecki
 */
@ExtendWith(MockitoExtension.class)
class PetSDJpaServiceTest {

    @Mock
    PetRepository petRepository;

    final String KRUCI = "Kruci";

    @InjectMocks
    PetSDJpaService service;

    Pet pet;

    @BeforeEach
    void setUp() {
        pet = Pet.builder().id(1L).name(KRUCI).build();
    }

    @Test
    void findAll() {
        final Set<Pet> pets = new HashSet<>();
        pets.add(Pet.builder().id(1L).build());
        pets.add(Pet.builder().id(2L).build());

        when(petRepository.findAll()).thenReturn(pets);
        assertEquals(2, service.findAll().size());
    }

    @Test
    void findById() {
        when(petRepository.findById(any())).thenReturn(Optional.of(pet));
        final Pet foundPet = service.findById(1L);
        assertNotNull(foundPet);
        assertEquals(new Long(1L), foundPet.getId());
        verify(petRepository).findById(any());
    }

    @Test
    void save() {

        Pet petToSave = Pet.builder().id(1L).build();
        when(petRepository.save(any())).thenReturn(pet);
        final Pet save = service.save(petToSave);
        assertNotNull(save);
        verify(petRepository).save(any());

    }

    @Test
    void delete() {
        service.delete(pet);
        verify(petRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(petRepository).deleteById(any());
    }
}