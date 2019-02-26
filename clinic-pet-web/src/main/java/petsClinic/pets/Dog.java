package petsClinic.pets;

public class Dog extends Pet {
    private static final String TYPE_NAME = "Dog";
    public Dog(String name) {
        super(name, TYPE_NAME);
    }

    public Dog(Pet pet) {
        super(pet, TYPE_NAME);
    }
}
