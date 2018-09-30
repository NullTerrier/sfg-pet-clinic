package marek.makuch.sfgpetclinic.bootstrap;
/*
 * @author Marecki
 */

import marek.makuch.sfgpetclinic.model.Owner;
import marek.makuch.sfgpetclinic.model.Pet;
import marek.makuch.sfgpetclinic.model.PetType;
import marek.makuch.sfgpetclinic.model.Vet;
import marek.makuch.sfgpetclinic.services.PetTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import marek.makuch.sfgpetclinic.services.OwnerService;
import marek.makuch.sfgpetclinic.services.VetService;

import java.time.LocalDate;

//when context is ready call run method of this class

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerMapService, VetService vetMapService, PetTypeService petTypeService) {
        this.ownerService = ownerMapService;
        this.vetService = vetMapService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedDogType = petTypeService.save(dog);
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loaded pet Types");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Bishops");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Bishops");
        owner2.setCity("Miami");
        owner2.setTelephone("123123123");

        Pet fionasPet = new Pet();

        mikesPet.setPetType(savedCatType);
        mikesPet.setOwner(owner2);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Kruzi");

        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
