package marek.makuch.sfgpetclinic.model;
/*
 * @author Marecki
 */

public class PetType extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}