package marek.makuch.sfgpetclinic.bootstrap;
/*
 * @author Marecki
 */

import marek.makuch.sfgpetclinic.model.*;
import marek.makuch.sfgpetclinic.services.PetTypeService;
import marek.makuch.sfgpetclinic.services.SpecialityService;
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
    private final SpecialityService specialityService;


    public DataLoader(OwnerService ownerMapService, VetService vetMapService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerMapService;
        this.vetService = vetMapService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedDogType = petTypeService.save(dog);
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loaded pet Types");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedRadiology = specialityService.save(radiology);
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("Loaded specialities.");

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

        fionasPet.setPetType(savedCatType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Kruzi");

        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
