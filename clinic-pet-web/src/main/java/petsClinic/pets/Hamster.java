package petsClinic.pets;

public class Hamster extends Pet {
    private static final String TYPE_NAME = "Hamster";
    public Hamster(String name) {
        super(name, TYPE_NAME);
    }

    public Hamster(Pet pet) {
        super(pet, TYPE_NAME);
    }
}
