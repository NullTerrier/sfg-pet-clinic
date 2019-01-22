package marek.makuch.sfgpetclinic.model;
/*
 * @author Marecki
 */

import com.google.common.collect.Sets;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {


    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;

        if (pets != null) {
            this.pets = pets;
        }
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = Sets.newHashSet();

    public void addPet(Pet pet) {

        if (pet.isNew()) {
            pets.add(pet);
        } else {
            return;
        }

        pet.setOwner(this);
    }

    /**
     * Return pet with given name
     * @param name to test
     * @return Optional of Pet
     */
    public Optional<Pet> getPet(String name) {
        return getPet(name, false);
    }

    /**
     * Return the Pet with the given name
     *
     * @param name to test
     * @param ignoreNew to ignore or not ignore new entites
     * @return Optional of Pet
     */
    public Optional<Pet> getPet(String name, boolean ignoreNew) {
        final String lowerName = name.toLowerCase();

        Predicate<Pet> isNewPredicate;

        if(!ignoreNew) {
            isNewPredicate = pet -> true;
        } else {
            isNewPredicate = pet -> !pet.isNew();
        }
        return pets.stream()
                .filter(isNewPredicate)
                .filter(pet -> lowerName.equals(pet.getName().toLowerCase()))
                .findFirst();

    }


}
