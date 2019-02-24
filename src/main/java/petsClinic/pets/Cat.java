package petsClinic.pets;

public class Cat extends Pet {
    private static final String TYPE_NAME = "Cat";
    public Cat(String name) {
        super(name, TYPE_NAME);
    }

    public Cat(Pet pet) {
        super(pet, TYPE_NAME);
    }
}
